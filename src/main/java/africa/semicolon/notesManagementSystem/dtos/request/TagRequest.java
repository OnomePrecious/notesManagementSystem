package africa.semicolon.notesManagementSystem.dtos.request;

import africa.semicolon.notesManagementSystem.dtos.response.Tags;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TagRequest {
    private String name;
    private Tags tag;
    private LocalDateTime dateCreated;
}
