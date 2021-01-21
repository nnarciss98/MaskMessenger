package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, UUID> {

}
