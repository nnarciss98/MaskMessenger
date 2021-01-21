package be.n.maskmessengerapp.controller.service;

import be.n.maskmessengerapp.model.datamodel.Message;
import be.n.maskmessengerapp.model.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Given that messages are only sent to the database and they cannot be updated nor deleted, the only functions they can
 * execute are to be sent to the database, or to be read.
 */

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Save the given message to the database.
     * @param message
     *          Message that has to be saved to the database.
     * @return
     *          The message that has been saved to the database.
     */
    public Message saveMessageToDatabase(Message message){
        message.setSenderName("Anonymous: ");
        return messageRepository.save(message);
    }

    /**
     * Gets the message from the database that has the given id.
     * @param id
     *          Message to be retrieved.
     * @return
     *          The message with the given id. If it doesn't exist, return a null object.
     */
    public Optional<Message> getMessageFromDatabase(int id){
        return messageRepository.findById(id);
    }

    /**
     * Gets all the messages in the database.
     * @return
     *          All messages in the database.
     */
    public List<Message> getAllMessagesFromDatabase(){
        List<Message> list = new ArrayList<>();
        messageRepository.findAll().forEach(e -> list.add(e));
        return list;
    }







}
