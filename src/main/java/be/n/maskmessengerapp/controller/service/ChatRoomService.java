package be.n.maskmessengerapp.controller.service;

import be.n.maskmessengerapp.model.datamodel.ChatRoom;
import be.n.maskmessengerapp.model.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    /**
     * The new chat room will be saved to the database.
     * @param chatRoom
     *          New chat room that will be added to the database.
     * @return
     */
    public ChatRoom createNewChatRoom(ChatRoom chatRoom){
        return chatRoomRepository.save(chatRoom);
    }

    /**
     * Get the chat room that has the given ID.
     * @param id
     *          ID of the chat room that has to be retrieved from the database.
     * @return
     *          ChatRoom with the given ID.
     */
    public Optional<ChatRoom> getChatRoomFromTheDatabase(UUID id){
        return chatRoomRepository.findById(id);
    }

    public String deleteChatRoomFromDatabase(UUID id){
        if (chatRoomRepository.existsById(id)){
            chatRoomRepository.deleteById(id);
            return "ChatRoom deleted.";
        }
        else {
            return "ChatRoom doesn't exist.";
        }
    }

}
