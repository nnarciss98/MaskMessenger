package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {


}
