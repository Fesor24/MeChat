package com.app.mechat.controller;

import com.app.mechat.Dto.ChatRequestDto;
import com.app.mechat.Dto.ChatResponseDto;
import com.app.mechat.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping(":id")
    public ChatResponseDto getChatById(Long id){
        return chatService.getChatById(id);
    }

    @GetMapping("")
    public List<ChatResponseDto> getAllChats(){
        return chatService.getAllChats();
    }

    @PostMapping("")
    public Long createChat(ChatRequestDto request){
        return chatService.createChat(request.getMessage());
    }


}
