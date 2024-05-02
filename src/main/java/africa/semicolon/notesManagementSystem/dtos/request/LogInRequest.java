package africa.semicolon.notesManagementSystem.dtos.request;

import lombok.Data;

@Data
public class LogInRequest {
    private String username;
    private String password;
}
