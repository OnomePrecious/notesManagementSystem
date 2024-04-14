package africa.semicolon.notesManagementSystem.data.repository;

import africa.semicolon.notesManagementSystem.data.models.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {
}
