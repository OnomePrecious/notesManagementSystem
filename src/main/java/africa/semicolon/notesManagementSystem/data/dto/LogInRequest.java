package africa.semicolon.notesManagementSystem.data.dto;

import lombok.Data;

@Data
public class LogInRequest {
    private String username;
    private String password;
}
