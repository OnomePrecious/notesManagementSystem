package africa.semicolon.notesManagementSystem.util;

import africa.semicolon.notesManagementSystem.data.models.Note;
import africa.semicolon.notesManagementSystem.data.models.User;
import africa.semicolon.notesManagementSystem.dtos.request.*;
import africa.semicolon.notesManagementSystem.dtos.response.*;

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
        noteResponse.setUsername(note.getUsername());
        noteResponse.setContent(note.getContent());
        noteResponse.setTag(note.getTag());
        noteResponse.setResponseTime(LocalDateTime.now());
        noteResponse.setNoteId(note.getId());
        return noteResponse;
    }

    public static void mapUserNoteRequest(NoteRequest noteRequest, Note note) {
        note.setUsername(noteRequest.getUsername());
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
    public static void mapShareNoteRequest(ShareNoteRequest shareNoteRequest, Note note){
        note.setId(shareNoteRequest.getId());
        note.setUsername(shareNoteRequest.getUsername());
        note.setDateCreated(LocalDateTime.now());
    }
    public static ShareNoteResponse mapToShareNoteResponseToNote(Note note) {
        ShareNoteResponse shareNoteResponse = new ShareNoteResponse();
        shareNoteResponse.setMessage("Successfully shared note " + note.getId());
        shareNoteResponse.setNoteId(note.getId());

        return shareNoteResponse;
    }


    public static void mapChangePasswordRequest(ChangePasswordRequest changePasswordRequest, User user){
        user.setUsername(changePasswordRequest.getUsername());
        user.setPassword(changePasswordRequest.getNewPassword());
    }


    public static ChangePasswordResponse mapChangePasswordRequestToUser(User user){
        ChangePasswordResponse changePasswordResponse = new ChangePasswordResponse();
        changePasswordResponse.setMessage("successful change of password " + user.getUsername());
        changePasswordResponse.setUsername(user.getUsername());
        return changePasswordResponse;
    }

}
