package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.dto.EditNoteRequest;
import africa.semicolon.notesManagementSystem.data.dto.NoteRequest;
import africa.semicolon.notesManagementSystem.data.dto.NoteResponse;
import africa.semicolon.notesManagementSystem.models.Note;

import java.util.List;

public interface NoteServices {
    NoteResponse createNote (NoteRequest noteRequest);
    NoteResponse editNote(EditNoteRequest editNoteRequest);
    NoteResponse deleteNote(NoteRequest noteRequest);
    List<Note> findAllNote();

}
