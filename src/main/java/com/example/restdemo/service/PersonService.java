package com.example.restdemo.service;

import com.example.restdemo.dto.Message;
import com.example.restdemo.dto.Person;
import com.example.restdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public Person addMeesageToPerson(int personId, Message message) {
        Person person = repository.findById(personId).get();
        message.setPerson(person);
        message.setTime(LocalDateTime.now());
        person.addMessage(message);
        return repository.save(person);
    }

    public Person deleteMessageFromPerson(int p_id, int m_id) {
        Person person = repository.findById(p_id).get();
        List<Message> messages = person.getMessages();
        for(Iterator<Message> iterator = messages.iterator(); iterator.hasNext();) {
            Message message = iterator.next();
            if (message.getId() == m_id) {
                iterator.remove();
                message.setPerson(null);
            }
        }
        return repository.save(person);
    }

    public List<Message> getMessagesFromPerson(int p_id) {
        return repository.findById(p_id).get().getMessages();
    }

    public Message getMessageFromPerson(int p_id, int m_id) {
        Person person = repository.findById(p_id).get();
        List<Message> messages = person.getMessages();
        for(Message message : messages) {
            if (message.getId() == m_id) {
                return message;
            }
        }
        return null;
    }

}