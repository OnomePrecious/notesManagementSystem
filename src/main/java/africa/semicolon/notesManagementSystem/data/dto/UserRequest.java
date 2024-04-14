package africa.semicolon.notesManagementSystem.data.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String content;
    private Tags tag;
}
