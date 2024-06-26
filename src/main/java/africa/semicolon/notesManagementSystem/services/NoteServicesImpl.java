package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.exception.NoteDoesNotExistException;
import africa.semicolon.notesManagementSystem.exception.UserNotFoundException;
import africa.semicolon.notesManagementSystem.data.models.Note;
import africa.semicolon.notesManagementSystem.data.repository.NoteRepository;
import africa.semicolon.notesManagementSystem.data.repository.UserRepository;
import africa.semicolon.notesManagementSystem.dtos.request.EditNoteRequest;
import africa.semicolon.notesManagementSystem.dtos.request.NoteRequest;
import africa.semicolon.notesManagementSystem.dtos.request.ShareNoteRequest;
import africa.semicolon.notesManagementSystem.dtos.response.NoteResponse;
import africa.semicolon.notesManagementSystem.dtos.response.ShareNoteResponse;
import africa.semicolon.notesManagementSystem.dtos.response.Tags;
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
        return mapUserNoteToResponse(note);

    }

    @Override
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public ShareNoteResponse shareNote(ShareNoteRequest shareNoteRequest) {
            var note = noteRepository.findNoteById(shareNoteRequest.getNoteId());
            if(note == null) throw new NoteDoesNotExistException("no notes available for sharing");
            var user = userRepository.findUserByUsername(shareNoteRequest.getUsername());
            if(!user.isLoggedIn()) throw new UserNotFoundException("You have to register first");
            var user1 = userRepository.findUserByUsername(shareNoteRequest.getReceiverName());
            var noteShared = cloneNote(note,user1.getUsername());
            user1.getNotes().add(noteShared);
            var notes =List.of(note,noteShared);
            noteRepository.saveAll(notes);
            userRepository.save(user);
            userRepository.save(user1);
            return mapToShareNoteResponseToNote(note);
        }

    @Override
    public Note cloneNote(Note cloneNoteRequest, String username) {
             Note clonedNote = new Note();
             clonedNote.setUsername(username);
             clonedNote.setContent(cloneNoteRequest.getContent());
             clonedNote.setTitle(cloneNoteRequest.getTitle());
             clonedNote.setTag(cloneNoteRequest.getTag());
             clonedNote.setDateCreated(cloneNoteRequest.getDateCreated());
             return noteRepository.save(clonedNote);
    }
}

