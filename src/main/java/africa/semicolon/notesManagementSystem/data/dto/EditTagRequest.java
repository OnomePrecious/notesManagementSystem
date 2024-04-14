package africa.semicolon.notesManagementSystem.data.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class EditTagRequest {
    private String name;
    private LocalDateTime timeEdited;
}
