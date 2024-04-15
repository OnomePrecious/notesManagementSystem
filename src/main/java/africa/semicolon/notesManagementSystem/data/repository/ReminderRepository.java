package africa.semicolon.notesManagementSystem.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReminderRepository extends MongoRepository<Reminder, String> {
}
