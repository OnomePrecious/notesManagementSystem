package africa.semicolon.notesManagementSystem.data.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TagRequest {
    private String name;
    private LocalDateTime dateCreated;
}
