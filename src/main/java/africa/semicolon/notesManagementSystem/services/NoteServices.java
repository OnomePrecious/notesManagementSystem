package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.dto.EditNoteRequest;
import africa.semicolon.notesManagementSystem.data.dto.NoteRequest;
import africa.semicolon.notesManagementSystem.data.dto.NoteResponse;

public interface NoteServices {
    NoteResponse createNote (NoteRequest noteRequest);
    NoteResponse editNote(EditNoteRequest editNoteRequest);
    NoteResponse deleteNote(NoteRequest noteRequest);

}
