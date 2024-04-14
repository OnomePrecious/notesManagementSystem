package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.dto.EditNoteRequest;
import africa.semicolon.notesManagementSystem.data.dto.NoteRequest;
import africa.semicolon.notesManagementSystem.data.dto.NoteResponse;
import africa.semicolon.notesManagementSystem.exception.NoteDoesNotExistException;
import africa.semicolon.notesManagementSystem.exception.UserNotFoundException;
import africa.semicolon.notesManagementSystem.models.Note;
import africa.semicolon.notesManagementSystem.repository.NoteRepository;
import africa.semicolon.notesManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.notesManagementSystem.util.Mappers.*;

@Service
public class NoteServicesImpl implements NoteServices{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public NoteResponse createNote(NoteRequest noteRequest) {
        Note note = new Note();
        var user = userRepository.findUserByUsername(noteRequest.getUsername());
        if(user==null)throw new UserNotFoundException("You have to be a registered user");
        if(!user.isLoggedIn())throw new UserNotFoundException("You have to log in first");
        mapUserNoteRequest(noteRequest, note);
        noteRepository.save(note);
        userRepository.save(user);
        return mapUserNoteToResponse(note);

    }
@Override
    public NoteResponse editNote(EditNoteRequest editNoteRequest) {
    var note = noteRepository.findNoteByContent(editNoteRequest.getContent());
    if(note == null) throw new NoteDoesNotExistException("no notes available for editing");
    mapEditNoteRequest(editNoteRequest, note);
    noteRepository.save(note);
    var user = userRepository.findUserByUsername(editNoteRequest.getUsername());
    if(!user.isLoggedIn()) throw new UserNotFoundException("You have to register first");
    user.setNotes(noteRepository.findNoteByUsername(editNoteRequest.getUsername()));
    userRepository.save(user);
        return mapUserNoteToResponse(note);

    }

    @Override
    public NoteResponse deleteNote(NoteRequest noteRequest) {
        var user = userRepository.findUserByUsername(noteRequest.getUsername());
        var note = noteRepository.findNoteByTitle(noteRequest.getTitle());
        if(note == null) throw new NoteDoesNotExistException("no notes available");
        if(!user.isLoggedIn()) throw new UserNotFoundException("You have to log in");
        noteRepository.deleteById(note.getId());
        noteRepository.delete(note);
        user.setNotes(noteRepository.findNoteByUsername(note.getContent()));
        userRepository.save(user);
        return mapUserNoteToResponse(note);

    }
}
