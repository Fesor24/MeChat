package com.app.mechat.service;

import com.app.mechat.Dto.ChatResponseDto;

import java.util.List;

public interface ChatService {
    List<ChatResponseDto> getAllChats();
    ChatResponseDto getChatById(Long id);
    Long createChat(String message);
}
