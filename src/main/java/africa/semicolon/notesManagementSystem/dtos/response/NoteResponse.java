package africa.semicolon.notesManagementSystem.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteResponse {
    private String username;
    private String content;
    private Tags tag;
    private String noteId;
    private LocalDateTime responseTime;
}
