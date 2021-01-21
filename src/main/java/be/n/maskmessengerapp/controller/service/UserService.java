package be.n.maskmessengerapp.controller.service;

import be.n.maskmessengerapp.model.datamodel.User;
import be.n.maskmessengerapp.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public List<User> getAllUsersFromDatabase(){
        return userRepository.findAll();
    }

    /**
     * Get the user with the given id.
     * @param id
     *          Id of the needed user.
     * @return
     *          User with the given Id, if it doesn't exist, return a null object.
     */
    public User getUserFromDatabaseWithId(UUID id){
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Save user to the database
     * @param user
     *          User that needs to be saved to the database.
     * @return
     *          User that has been saved to the database.
     */
    public User saveUserToDatabase(User user){
        return userRepository.save(user);
    }

    /**
     * Save a list of users to the database
     * @param users
     *          Users that need to be saved to the database.
     * @return
     *          Users that have been saved to the database.
     */
    public List<User> saveUserList(List<User> users){
        return userRepository.saveAll(users);
    }


    /**
     * Delete the user that has the given ID.
     * @param id
     *          ID of the user that needs to be deleted.
     * @return
     *          A message saying whether the user was deleted or not found in the database.
     */
    public String deleteUserById(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted.";
        }
        else {
            return "User doesn't exist";
        }
    }
}
