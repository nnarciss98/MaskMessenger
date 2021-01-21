package be.n.maskmessengerapp.controller.api;

import be.n.maskmessengerapp.controller.service.MessageService;
import be.n.maskmessengerapp.model.datamodel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/maskmessenger/messages")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController (MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping(path = "{id}")
    public Optional<Message> getMessageById(@PathVariable("id") int id){
        return messageService.getMessageFromDatabase(id);
    }

    @GetMapping
    public List<Message> getAllMessages(){
        return messageService.getAllMessagesFromDatabase();
    }

    @PostMapping
    public String saveMessage(@ModelAttribute Message message){
        messageService.saveMessageToDatabase(message);
        return
                "<meta http-equiv = \"refresh\" content=\"0; URL='/chatroom'\" />\n";
    }


}
