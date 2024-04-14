package africa.semicolon.notesManagementSystem.models;

import africa.semicolon.notesManagementSystem.data.dto.Tags;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document("Users")
public class User {
    private String username;
    private String password;
    private String email;
    @Id
    private String id;
    private Tags tag;
    private List<Note> notes;
    private boolean loggedIn;

}

