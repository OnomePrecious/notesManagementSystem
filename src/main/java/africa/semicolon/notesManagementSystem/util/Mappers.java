package africa.semicolon.notesManagementSystem.util;

import africa.semicolon.notesManagementSystem.request.dto.*;
import africa.semicolon.notesManagementSystem.data.models.Note;
import africa.semicolon.notesManagementSystem.data.models.User;

import java.time.LocalDateTime;

public class Mappers {
    public static void mapUserRequestToRegister(RegisterRequest request, User user) {
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
    }

    public static RegisterResponse mapUserToRegisterResponse(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        return registerResponse;
    }

    public static LogInResponse mapUserLogInResponse(User user, LogInResponse logInResponse) {
        logInResponse.setUsername(user.getUsername());
        logInResponse.setNotes(user.getNotes());
        return logInResponse;
    }


    public static NoteResponse mapUserNoteToResponse(Note note) {
        NoteResponse noteResponse = new NoteResponse();
        noteResponse.setContent(note.getContent());
        noteResponse.setTag(note.getTag());
        noteResponse.setResponseTime(LocalDateTime.now());
        noteResponse.setNoteId(note.getId());
        return noteResponse;
    }

    public static void mapUserNoteRequest(NoteRequest noteRequest, Note note) {
        note.setContent(noteRequest.getContent());
        note.setTitle(noteRequest.getTitle());
        note.setTag(noteRequest.getTag());
        note.setDateCreated(LocalDateTime.now());
    }
    public static void mapEditNoteRequest(EditNoteRequest editNoteRequest, Note note){
        note.setId(editNoteRequest.getNoteId());
       note.setTitle(editNoteRequest.getTitle());
        note.setContent(editNoteRequest.getContent());
       note.setTag(Tags.WORK);
        note.setDateCreated(LocalDateTime.now());

    }

}