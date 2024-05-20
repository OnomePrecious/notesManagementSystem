package africa.semicolon.notesManagementSystem.data.models;

import africa.semicolon.notesManagementSystem.dtos.response.Tags;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
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
    private List<Note> notes = new ArrayList<>();
    private boolean loggedIn;

}

