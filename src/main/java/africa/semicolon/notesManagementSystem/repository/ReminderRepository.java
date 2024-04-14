package africa.semicolon.notesManagementSystem.repository;

import africa.semicolon.notesManagementSystem.models.Reminder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReminderRepository extends MongoRepository<Reminder, String> {
}
