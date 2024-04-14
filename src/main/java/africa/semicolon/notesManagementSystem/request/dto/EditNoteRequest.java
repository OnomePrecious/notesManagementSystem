package africa.semicolon.notesManagementSystem.request.dto;

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
