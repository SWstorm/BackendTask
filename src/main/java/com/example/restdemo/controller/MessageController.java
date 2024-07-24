package com.example.restdemo.controller;

import com.example.restdemo.dto.Message;
import com.example.restdemo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/message")
    public Iterable<Message> getMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findPersonById(@PathVariable int id) {
        return messageRepository.findById(id);
    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updatePerson(@PathVariable int id, @RequestBody Message message) {
        if (messageRepository.existsById(id)) {
            message.setId(id);
            messageRepository.save(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(messageRepository.save(message), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        messageRepository.deleteById(id);
    }
}
