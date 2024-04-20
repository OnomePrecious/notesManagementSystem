package africa.semicolon.notesManagementSystem.request.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteRequest {
    private String title;
    private String username;
    private String content;
    private Tags tag;
    private String noteId;
    private LocalDateTime timeOfRequest;
}
