package africa.semicolon.notesManagementSystem.dtos.response;

import africa.semicolon.notesManagementSystem.data.models.Note;
import lombok.Data;

import java.util.List;

@Data
public class LogInResponse {
    private String username;
    private List<Note> notes;
}
