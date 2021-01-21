package be.n.maskmessengerapp.controller.security.service;

import be.n.maskmessengerapp.model.datamodel.MyUserDetails;
import be.n.maskmessengerapp.model.datamodel.User;
import be.n.maskmessengerapp.model.repository.UserRepository;
import be.n.maskmessengerapp.controller.security.service.*;
import be.n.maskmessengerapp.model.datamodel.User;
import be.n.maskmessengerapp.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("User " + userName + " not found."));
        return user.map(MyUserDetails::new).get();
    }
}
