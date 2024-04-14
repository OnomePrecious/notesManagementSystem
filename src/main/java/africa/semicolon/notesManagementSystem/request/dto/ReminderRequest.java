package africa.semicolon.notesManagementSystem.request.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class ReminderRequest {
    private String id;
    private String noteId;
    private LocalDateTime reminderDate;
    private String message;
}
