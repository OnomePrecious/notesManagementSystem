package africa.semicolon.notesManagementSystem.data.repository;

import africa.semicolon.notesManagementSystem.data.models.Reminder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReminderRepository extends MongoRepository<Reminder, String> {
}
