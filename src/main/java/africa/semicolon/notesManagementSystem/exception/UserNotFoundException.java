package africa.semicolon.notesManagementSystem.exception;

public class UserNotFoundException extends NotesManagementSystemError {
    public UserNotFoundException(String message) {
        super(message);
    }
}
