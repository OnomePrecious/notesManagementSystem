package africa.semicolon.notesManagementSystem.controllers;

import africa.semicolon.notesManagementSystem.data.dto.EditNoteRequest;
import africa.semicolon.notesManagementSystem.data.dto.LogInRequest;
import africa.semicolon.notesManagementSystem.data.dto.NoteRequest;
import africa.semicolon.notesManagementSystem.data.dto.RegisterRequest;
import africa.semicolon.notesManagementSystem.exception.NotesManagementSystemError;
import africa.semicolon.notesManagementSystem.services.NoteServices;
import africa.semicolon.notesManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class NoteController {
    @Autowired
    private UserService userService;
    @Autowired
    private NoteServices noteServices;

    @PostMapping("/Register")
    public ResponseEntity<?> Registration(@RequestBody RegisterRequest registerRequest) {
        try {
            return new ResponseEntity<>(userService.register(registerRequest), CREATED);
        } catch (NotesManagementSystemError e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }
@PostMapping("log_in")
        public ResponseEntity<?> LogIn(@RequestBody LogInRequest logInRequest){
        try {
            return new ResponseEntity<>(userService.logIn(logInRequest), CREATED);

        } catch (NotesManagementSystemError e){
        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }
    @PostMapping("log_out")
    public ResponseEntity<?> LogOut(@RequestBody LogInRequest logInRequest){
    try{
        return new ResponseEntity<>(userService.logOut(logInRequest), CREATED);
    } catch (NotesManagementSystemError e){
        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
    }
    }
    @PostMapping("create_note")
        public ResponseEntity<?> createNote(@RequestBody NoteRequest noteRequest) {
        try {
            return new ResponseEntity<>(noteServices.createNote(noteRequest), CREATED);
        } catch (NotesManagementSystemError e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }
        @PostMapping("edit_note")
                public ResponseEntity<?> updateNote(EditNoteRequest editNoteRequest) {
            try {
                return new ResponseEntity<>(noteServices.editNote(editNoteRequest), CREATED);
            } catch (NotesManagementSystemError e) {
                return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
            }
        }

        @DeleteMapping("delete_note")
    public ResponseEntity<?> deleteNote(@RequestBody NoteRequest noteRequest){
        try{
            return new ResponseEntity<>(noteServices.deleteNote(noteRequest), CREATED);
        } catch (NotesManagementSystemError e){
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
        }
}