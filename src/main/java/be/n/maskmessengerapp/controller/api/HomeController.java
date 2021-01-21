package be.n.maskmessengerapp.controller.api;

import be.n.maskmessengerapp.controller.security.service.MyUserDetailsService;
import be.n.maskmessengerapp.controller.service.MessageService;
import be.n.maskmessengerapp.model.datamodel.Message;
import be.n.maskmessengerapp.model.datamodel.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.naming.Context;

@Controller
public class HomeController {

    @Autowired
    MessageService messageService;

    @GetMapping("/")
    public String home(){
        return ("main");
    }

    @GetMapping("/chatroom")
    public String chatroom(Model model) {

        model.addAttribute("messages", messageService.getAllMessagesFromDatabase());
        model.addAttribute("message", new Message());
        return "chatroom";
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1> Welcome to the admin home </h1>");
    }
}
