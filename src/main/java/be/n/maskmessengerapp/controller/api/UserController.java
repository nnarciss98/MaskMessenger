package be.n.maskmessengerapp.controller.api;

import be.n.maskmessengerapp.controller.service.UserService;
import be.n.maskmessengerapp.model.datamodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/maskmessenger/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    /**
     * Gets all users from the database.
     * It makes use of the GET request.
     * @return
     *          A list of all users registered in the database.
     */
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsersFromDatabase();
    }

    /**
     * Get the user with the given Id from the database.
     * It makes use of the GET request. It also uses a Json body with the field "id"
     *      that has the id of the requested user.
     * @param id
     *          Id of the user that needs to be get from the database.
     * @return
     *          The user with the given Id.
     */
    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id){
        return userService.getUserFromDatabaseWithId(id);
    }

    /**
     * Adds a new user to the database.
     * It makes use of the POST request. It sends a Json file with the needed details
     *      to create a new user in the database.
     * @param user
     */
    @PostMapping
    public void addUser(@RequestBody User user){
        userService.saveUserToDatabase(user);
    }

    /**
     * Delete a user from the database.
     * It makes use of the DELETE request. The request contains the Id of the user
     *      that needs to be deleted.
     * @param id
     */
    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") UUID id){
        userService.deleteUserById(id);
    }

}
