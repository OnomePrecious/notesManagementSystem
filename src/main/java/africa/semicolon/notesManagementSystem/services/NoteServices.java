package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.models.Note;
import africa.semicolon.notesManagementSystem.dtos.request.EditNoteRequest;
import africa.semicolon.notesManagementSystem.dtos.request.NoteRequest;
import africa.semicolon.notesManagementSystem.dtos.request.ShareNoteRequest;
import africa.semicolon.notesManagementSystem.dtos.response.NoteResponse;
import africa.semicolon.notesManagementSystem.dtos.response.ShareNoteResponse;

import java.util.List;

public interface NoteServices {
    NoteResponse createNote (NoteRequest noteRequest);

    NoteResponse workTag(NoteRequest noteRequest);

    NoteResponse personalTag(NoteRequest noteRequest);

    NoteResponse projectTag(NoteRequest noteRequest);

    NoteResponse importantTag(NoteRequest noteRequest);

    NoteResponse editNote(EditNoteRequest editNoteRequest);
    NoteResponse deleteNote(NoteRequest noteRequest);
    List<Note> findAllNotes();
    ShareNoteResponse shareNote(ShareNoteRequest shareNoteRequest);
    Note cloneNote(Note cloneNoteRequest, String username);
}
