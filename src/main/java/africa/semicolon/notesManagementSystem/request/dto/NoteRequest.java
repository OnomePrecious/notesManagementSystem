package africa.semicolon.notesManagementSystem.request.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteRequest {
    private String title;
    private String username;
    private String content;
    private String tag;
    private LocalDateTime timeOfRequest;
}