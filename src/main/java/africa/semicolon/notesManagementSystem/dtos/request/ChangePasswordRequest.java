package africa.semicolon.notesManagementSystem.dtos.request;

import lombok.Data;

@Data

public class ChangePasswordRequest {
    private String username;
    private String password;
    private String newPassword;
}
