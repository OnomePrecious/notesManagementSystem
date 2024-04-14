package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.request.dto.ReminderRequest;
import africa.semicolon.notesManagementSystem.data.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl implements ReminderService{
    @Autowired
    private ReminderRepository reminderRepository;
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
