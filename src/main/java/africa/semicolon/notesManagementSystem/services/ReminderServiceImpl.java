package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.dto.EditReminderRequest;
import africa.semicolon.notesManagementSystem.data.dto.ReminderRequest;
import africa.semicolon.notesManagementSystem.exception.NoteDoesNotExistException;
import africa.semicolon.notesManagementSystem.exception.UserNotFoundException;
import africa.semicolon.notesManagementSystem.models.Note;
import africa.semicolon.notesManagementSystem.models.Reminder;
import africa.semicolon.notesManagementSystem.repository.NoteRepository;
import africa.semicolon.notesManagementSystem.repository.ReminderRepository;
import africa.semicolon.notesManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.notesManagementSystem.util.Mappers.*;

@Service
public class ReminderServiceImpl implements ReminderService{
    @Autowired
    private ReminderRepository reminderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public ReminderRequest createReminder(ReminderRequest reminderRequest) {
        return null;
    }

    @Override
    public ReminderRequest editReminder(ReminderRequest reminderRequest) {
        return null;
    }

    @Override
    public String deleteReminder(String id) {
        return null;
    }
}
