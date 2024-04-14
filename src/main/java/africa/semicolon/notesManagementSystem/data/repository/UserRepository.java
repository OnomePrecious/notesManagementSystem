package africa.semicolon.notesManagementSystem.data.repository;

import africa.semicolon.notesManagementSystem.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByUsername(String username);
}
