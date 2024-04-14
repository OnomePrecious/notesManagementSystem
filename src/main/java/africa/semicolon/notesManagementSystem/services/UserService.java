package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.dto.LogInRequest;
import africa.semicolon.notesManagementSystem.data.dto.LogInResponse;
import africa.semicolon.notesManagementSystem.data.dto.RegisterRequest;
import africa.semicolon.notesManagementSystem.data.dto.RegisterResponse;
import africa.semicolon.notesManagementSystem.models.User;

public interface UserService  {
    LogInResponse logIn(LogInRequest logInRequest);
    LogInResponse logOut(LogInRequest logInRequest);
    RegisterResponse register(RegisterRequest Request);
    User findUserByUsername(String username);

}
