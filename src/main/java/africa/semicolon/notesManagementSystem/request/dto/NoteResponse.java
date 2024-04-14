package africa.semicolon.notesManagementSystem.request.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteResponse {
    private String content;
    private String tag;
    private LocalDateTime responseTime;
}
