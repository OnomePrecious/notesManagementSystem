package africa.semicolon.notesManagementSystem.data.dto;

import lombok.Data;

@Data
public class UserResponse {
    private String content;
    private Tags tag;
}
