package africa.semicolon.notesManagementSystem.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Note {
    @Id
    private String id;
    private String username;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
    private String tag;
    }

