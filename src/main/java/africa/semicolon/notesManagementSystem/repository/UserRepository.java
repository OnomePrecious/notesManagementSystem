package africa.semicolon.notesManagementSystem.repository;

import africa.semicolon.notesManagementSystem.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByUsername(String username);
}
