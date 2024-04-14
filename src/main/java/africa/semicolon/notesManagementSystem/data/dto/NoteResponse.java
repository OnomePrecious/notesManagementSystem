package africa.semicolon.notesManagementSystem.data.dto;

import africa.semicolon.notesManagementSystem.models.Tag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class NoteResponse {
    private String content;
    private String tag;
    private LocalDateTime responseTime;
}
