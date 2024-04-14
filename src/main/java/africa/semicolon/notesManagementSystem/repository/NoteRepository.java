package africa.semicolon.notesManagementSystem.repository;

import africa.semicolon.notesManagementSystem.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    Note findNoteByContent(String content);

    List<Note> findNoteByUsername(String username);

    Note findNoteByTitle(String title);

    Note findNoteById(String noteId);
}
