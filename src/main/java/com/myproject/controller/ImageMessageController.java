package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class ImageMessageController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/sendImage")
    public void sendImage(byte[] imageData) {
        // Broadcast image data to all subscribers
        this.messagingTemplate.convertAndSend("/topic/public", imageData);
    }
}
