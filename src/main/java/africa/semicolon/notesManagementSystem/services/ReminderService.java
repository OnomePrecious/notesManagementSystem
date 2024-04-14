package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.dto.ReminderRequest;

public interface ReminderService {
    ReminderRequest createReminder(ReminderRequest reminderRequest);
    ReminderRequest editReminder(ReminderRequest reminderRequest);
    String deleteReminder(String id);
}
