package africa.semicolon.notesManagementSystem.data.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReminderResponse {
    private String id;
    private String noteId;
    private LocalDateTime reminderDate;
    private String message;

}
