package africa.semicolon.notesManagementSystem.request.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteResponse {
    private String content;
    private Tags tag;
    private String noteId;
    private LocalDateTime responseTime;
}
