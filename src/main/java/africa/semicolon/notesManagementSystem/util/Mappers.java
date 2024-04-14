package africa.semicolon.notesManagementSystem.util;

import africa.semicolon.notesManagementSystem.data.dto.*;
import africa.semicolon.notesManagementSystem.models.Note;
import africa.semicolon.notesManagementSystem.models.Reminder;
import africa.semicolon.notesManagementSystem.models.Tag;
import africa.semicolon.notesManagementSystem.models.User;

public class Mappers {
    public static void mapUserRequestToRegister(RegisterRequest request, User user){
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
    }
    public static RegisterResponse mapUserToRegisterResponse(User user){
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        return registerResponse;
    }
    public static LogInResponse mapUserLogInResponse(User user, LogInResponse logInResponse){
        logInResponse.setUsername(user.getUsername());
        logInResponse.setNotes(user.getNotes());
        return logInResponse;
    }
    public static void mapUserLogInRequest(LogInRequest logInRequest, User user){
        user.setUsername(logInRequest.getUsername());
        user.setPassword(logInRequest.getPassword());

    }
    public static NoteResponse mapUserNoteToResponse(Note note){
        NoteResponse noteResponse = new NoteResponse();
        noteResponse.setContent(note.getContent());
        noteResponse.setTag(note.getTag());
        noteResponse.setResponseTime(note.getDateCreated());
        return noteResponse;
    }
    public static void mapUserNoteRequest(NoteRequest noteRequest, Note note){
        note.setContent(noteRequest.getContent());
        note.setTitle(noteRequest.getTitle());
        note.setTag(noteRequest.getTag());
        note.setDateCreated(noteRequest.getTimeOfRequest());
    }
    public static void mapEditNoteRequest(EditNoteRequest editNoteRequest, Note note){
        note.setTitle(editNoteRequest.getTitle());
        note.setContent(editNoteRequest.getContent());
        note.setTag(editNoteRequest.getTag());
        note.setDateCreated(editNoteRequest.getDateEdited());

    }
    public static void mapEditReminderRequest(EditReminderRequest editReminderRequest, Reminder reminder){
        reminder.setNoteId(editReminderRequest.getNoteId());
        reminder.setReminderDate(editReminderRequest.getReminderDate());
        reminder.setMessage(editReminderRequest.getMessage());
    }
    public static void mapEditTagRequest(EditTagRequest editTagRequest, Tag tag){
        tag.setName(editTagRequest.getName());
        tag.setDateCreated(editTagRequest.getTimeEdited());
    }
    public static void mapTagRequestToTag(TagRequest tagRequest, Tag tag){
        tag.setName(tagRequest.getName());
        tag.setDateCreated(tagRequest.getDateCreated());
    }
    public static TagResponse mapTagToTagResponse(Tag tag){
        TagResponse tagResponse = new TagResponse();
        tagResponse.setName(tag.getName());
        tagResponse.setResponseTime(tag.getDateCreated());
        return tagResponse;
    }
}