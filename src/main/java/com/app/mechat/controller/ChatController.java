package com.app.mechat.controller;

import com.app.mechat.dto.ChatRequestDto;
import com.app.mechat.dto.ChatResponseDto;
import com.app.mechat.primitives.Result;
import com.app.mechat.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<ChatResponseDto>> getChatById(Long id){
        return ResponseEntity.ok(chatService.getChatById(id));
    }

    @GetMapping
    public ResponseEntity<Result<List<ChatResponseDto>>> getAllChats(){
        return ResponseEntity.ok(chatService.getAllChats());
    }

    @PostMapping
    public ResponseEntity<Result<Long>> createChat(@RequestBody  ChatRequestDto request){
        return ResponseEntity.ok(chatService.createChat(request.message()));
    }


}
