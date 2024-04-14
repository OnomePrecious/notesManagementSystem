package africa.semicolon.notesManagementSystem.data.dto;

import africa.semicolon.notesManagementSystem.models.Note;
import lombok.Data;

import java.util.List;

@Data
public class LogInResponse {
    private String username;
    private List<Note> notes;
}
