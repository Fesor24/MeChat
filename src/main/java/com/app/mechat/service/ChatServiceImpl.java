package com.app.mechat.service;

import com.app.mechat.Dto.ChatResponseDto;
import com.app.mechat.entity.Chat;
import com.app.mechat.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository){
        this.chatRepository = chatRepository;
    }

    @Override
    public List<ChatResponseDto> getAllChats() {
        List<Chat> chats = this.chatRepository.findAll();

        List<ChatResponseDto> chatResponse = chats.stream()
                .map(chat -> new ChatResponseDto(
                        chat.getId(),
                        chat.getMessage(),
                        chat.getCreatedAt()

                ))
                .toList();

        return chatResponse;
    }

    @Override
    public ChatResponseDto getChatById(Long id) {
        Chat chat = chatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chat not found with Id: " + id));

        ChatResponseDto chatResponse = new ChatResponseDto(
                chat.getId(),
                chat.getMessage(),
                chat.getCreatedAt()

        );

        return chatResponse;
    }

    @Override
    public Long createChat(String message) {
        Chat chat = Chat.create(message);

        Chat newChat = chatRepository.save(chat);

        return newChat.getId();
    }
}
