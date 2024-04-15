package africa.semicolon.notesManagementSystem.data.models;

import africa.semicolon.notesManagementSystem.request.dto.Tags;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Tag {
    @Id
    private String id;
    private String name;
    private Tags tag;
    private LocalDateTime dateCreated;
}
