package africa.semicolon.notesManagementSystem.request;

import africa.semicolon.notesManagementSystem.request.dto.Tags;
import lombok.Data;

@Data
public class UserResponse {
    private String content;
    private Tags tag;
}
