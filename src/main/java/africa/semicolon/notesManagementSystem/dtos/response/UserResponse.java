package africa.semicolon.notesManagementSystem.dtos.response;

import lombok.Data;

@Data
public class UserResponse {
    private String content;
    private Tags tag;
}
