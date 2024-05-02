package africa.semicolon.notesManagementSystem.dtos.request;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class ShareNoteRequest {
    @Id
    private String id;
    private String username;
    private String noteId;
    private String receiverName;
    private LocalDateTime dateShared;
}
