package africa.semicolon.notesManagementSystem.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("Tags")
public class Tag {
    @Id
    private String id;
    private String name;
    private LocalDateTime dateCreated;
    //private List<String> tags;
}
