package africa.semicolon.notesManagementSystem.request.dto;

import africa.semicolon.notesManagementSystem.data.models.Note;
import lombok.Data;

import java.util.List;

@Data
public class LogInResponse {
    private String username;
    private List<Note> notes;
}
