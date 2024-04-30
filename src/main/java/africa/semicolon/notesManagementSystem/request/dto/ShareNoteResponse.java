package africa.semicolon.notesManagementSystem.request.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ShareNoteResponse {
    private String message = "Note successfully shared";
    private String userName;
    private String receiverName;
    @Id
    private String id;
    private String noteId;
}
