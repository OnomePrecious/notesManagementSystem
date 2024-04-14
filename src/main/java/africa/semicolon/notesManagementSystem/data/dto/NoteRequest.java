package africa.semicolon.notesManagementSystem.data.dto;

import africa.semicolon.notesManagementSystem.models.Tag;
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
