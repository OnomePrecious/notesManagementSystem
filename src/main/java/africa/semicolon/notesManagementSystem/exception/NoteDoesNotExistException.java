package africa.semicolon.notesManagementSystem.exception;

public class NoteDoesNotExistException extends NotesManagementSystemError{
    public NoteDoesNotExistException(String message) {
        super(message);
    }
}
