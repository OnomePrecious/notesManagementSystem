package africa.semicolon.notesManagementSystem.controllers;

import africa.semicolon.notesManagementSystem.request.dto.*;
import africa.semicolon.notesManagementSystem.exception.NotesManagementSystemError;
import africa.semicolon.notesManagementSystem.services.NoteServices;
import africa.semicolon.notesManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/notes")
public class NotesManagementSystemController {
    @Autowired
    private UserService userService;
    @Autowired
    private NoteServices noteServices;

    @PostMapping("/Register")
    public ResponseEntity<?> Registration(@RequestBody RegisterRequest registerRequest) {
        try {
            var result = userService.register(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (NotesManagementSystemError e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
@PostMapping("log_in")
        public ResponseEntity<?> LogIn(@RequestBody LogInRequest logInRequest){
        try {
            var result = userService.logIn(logInRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);

        } catch (NotesManagementSystemError e){
        return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("log_out")
    public ResponseEntity<?> LogOut(@RequestBody LogInRequest logInRequest){
    try{
        var result = userService.logOut(logInRequest);
        return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
    } catch (NotesManagementSystemError e){
        return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
    }
    }
    @PostMapping("create_note")
        public ResponseEntity<?> createNote(@RequestBody NoteRequest noteRequest) {
        try {
            var result = noteServices.createNote(noteRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (NotesManagementSystemError e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
       @PatchMapping( "edit_note")
                public ResponseEntity<?> editNote(@RequestBody EditNoteRequest editNoteRequest) {
            try {
                var result = noteServices.editNote(editNoteRequest);
                return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
            } catch (NotesManagementSystemError e) {
                return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
            }
        }

        @DeleteMapping("delete_note")
    public ResponseEntity<?> deleteNote(@RequestBody NoteRequest noteRequest){
        try{
            var result = noteServices.deleteNote(noteRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (NotesManagementSystemError e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
        }
}