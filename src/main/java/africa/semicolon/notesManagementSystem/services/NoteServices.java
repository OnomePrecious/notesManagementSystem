package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.request.dto.EditNoteRequest;
import africa.semicolon.notesManagementSystem.request.dto.NoteRequest;
import africa.semicolon.notesManagementSystem.request.dto.NoteResponse;
import africa.semicolon.notesManagementSystem.data.models.Note;

import java.util.List;

public interface NoteServices {
    NoteResponse createNote (NoteRequest noteRequest);
    NoteResponse editNote(EditNoteRequest editNoteRequest);
    NoteResponse deleteNote(NoteRequest noteRequest);
    List<Note> findAllNote();

}
