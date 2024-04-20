package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.request.dto.EditNoteRequest;
import africa.semicolon.notesManagementSystem.request.dto.NoteRequest;
import africa.semicolon.notesManagementSystem.request.dto.NoteResponse;
import africa.semicolon.notesManagementSystem.exception.NoteDoesNotExistException;
import africa.semicolon.notesManagementSystem.exception.UserNotFoundException;
import africa.semicolon.notesManagementSystem.data.models.Note;
import africa.semicolon.notesManagementSystem.data.repository.NoteRepository;
import africa.semicolon.notesManagementSystem.data.repository.UserRepository;
import africa.semicolon.notesManagementSystem.request.dto.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.notesManagementSystem.util.Mappers.*;

@Service
public class NoteServicesImpl implements NoteServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public NoteResponse createNote(NoteRequest noteRequest) {
        Note note = new Note();
        var user = userRepository.findUserByUsername(noteRequest.getUsername());
        if (user == null) throw new UserNotFoundException("You have to be a registered user");
        if (!user.isLoggedIn()) throw new UserNotFoundException("You have to log in first");
        mapUserNoteRequest(noteRequest, note);
        noteRepository.save(note);
        userRepository.save(user);
        return mapUserNoteToResponse(note);

    }

    @Override
    public NoteResponse workTag(NoteRequest noteRequest) {
        Note foundNote = noteRepository.findNoteByTitle(noteRequest.getTitle());
        foundNote.setTag(Tags.WORK);
        return mapUserNoteToResponse(foundNote);
    }

    @Override
    public NoteResponse personalTag(NoteRequest noteRequest) {
        Note foundNote = noteRepository.findNoteByTitle(noteRequest.getTitle());
        foundNote.setTag(Tags.PERSONAL);
        return mapUserNoteToResponse(foundNote);
    }

    @Override
    public NoteResponse projectTag(NoteRequest noteRequest){
        Note foundNote = noteRepository.findNoteByTitle(noteRequest.getTitle());
        foundNote.setTag(Tags.PROJECT);
        return mapUserNoteToResponse(foundNote);

}
@Override
public NoteResponse importantTag(NoteRequest noteRequest){
    Note foundNote = noteRepository.findNoteByTitle(noteRequest.getTitle());
    foundNote.setTag(Tags.IMPORTANT);
    return mapUserNoteToResponse(foundNote);

}
    @Override
    public NoteResponse editNote(EditNoteRequest editNoteRequest) {
        var note = noteRepository.findNoteById(editNoteRequest.getNoteId());
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
    @Override
    public List<Note> findAllNote() {
        return noteRepository.findAll();
    }
}
