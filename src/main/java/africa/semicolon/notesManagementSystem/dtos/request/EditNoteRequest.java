package africa.semicolon.notesManagementSystem.dtos.request;

import africa.semicolon.notesManagementSystem.dtos.response.Tags;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EditNoteRequest {
    private String username;
    private String noteId;
    private String title;
    private String content;
    private Tags tag;
    private LocalDateTime dateEdited;

}
