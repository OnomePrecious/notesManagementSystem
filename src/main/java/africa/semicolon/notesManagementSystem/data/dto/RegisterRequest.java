package africa.semicolon.notesManagementSystem.data.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    @Id
    private String id;
}
