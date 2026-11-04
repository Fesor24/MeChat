package com.app.mechat.service;

import com.app.mechat.dto.ChatResponseDto;
import com.app.mechat.primitives.Result;

import java.util.List;

public interface ChatService {
    Result<List<ChatResponseDto>> getAllChats();
    Result<ChatResponseDto> getChatById(Long id);
    Result<Long> createChat(String message);
}
