package africa.semicolon.notesManagementSystem.dtos.request;

import africa.semicolon.notesManagementSystem.dtos.response.Tags;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String content;
    private Tags tag;
}
