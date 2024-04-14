package africa.semicolon.notesManagementSystem.request.dto;

import lombok.Data;

@Data
public class LogInRequest {
    private String username;
    private String password;
}
