package africa.semicolon.notesManagementSystem.data.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reminder {
    private String id;
    private String noteId;
    private LocalDateTime reminderDate;
    private String message;
}
