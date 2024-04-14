package africa.semicolon.notesManagementSystem.data.dto;

import africa.semicolon.notesManagementSystem.models.Tag;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EditNoteRequest {
    private String username;
    private String title;
    private String content;
    private String tag;
    private LocalDateTime dateEdited;

}
