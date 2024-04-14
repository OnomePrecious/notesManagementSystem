package africa.semicolon.notesManagementSystem.repository;

import africa.semicolon.notesManagementSystem.models.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {
}
