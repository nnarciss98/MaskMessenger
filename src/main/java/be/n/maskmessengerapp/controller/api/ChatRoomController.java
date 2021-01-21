package be.n.maskmessengerapp.controller.api;

import be.n.maskmessengerapp.controller.service.ChatRoomService;
import be.n.maskmessengerapp.model.datamodel.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/maskmessenger/conversation")
public class ChatRoomController {

    private ChatRoomService chatRoomService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService){
        this.chatRoomService = chatRoomService;
    }

    @PostMapping
    public void createConversation(@RequestBody ChatRoom chatRoom){
        this.chatRoomService.createNewChatRoom(chatRoom);
    }

    /**
     * Search a conversation with the given Id.
     * @param id
     *          Id of the conversation that needs to be retrieved from the database
     * @return
     *          The conversation with the given Id, if it exists.
     */
    @GetMapping(path = "{id}")
    public Optional<ChatRoom> getConversationbyId(@PathVariable("id") UUID id){
        return chatRoomService.getChatRoomFromTheDatabase(id);
    }

    /**
     * Delete the conversation that has the given Id.
     * @param id
     *          Id of the conversation that needs to be deleted.
     */
    @DeleteMapping(path = "{id}")
    public void deleteConversation(@PathVariable("id") UUID id){
        chatRoomService.deleteChatRoomFromDatabase(id);
    }





}
