package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "sendername")
    private String senderName;
    @Column(name = "messagetext")
    private String messageText;

    /* Getters for the message class */

    public int getId() {
        return id;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMessageText() {
        return messageText;
    }

    /* Setters for the message class */

    public void setId(int id) {
        this.id = id;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
