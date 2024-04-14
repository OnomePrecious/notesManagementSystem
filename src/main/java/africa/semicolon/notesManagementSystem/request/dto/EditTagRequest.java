package africa.semicolon.notesManagementSystem.request.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class EditTagRequest {
    private String name;
    private LocalDateTime timeEdited;
}
