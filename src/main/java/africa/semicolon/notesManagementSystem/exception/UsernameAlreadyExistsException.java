package africa.semicolon.notesManagementSystem.exception;

public class UsernameAlreadyExistsException extends NotesManagementSystemError {
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
