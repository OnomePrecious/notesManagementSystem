package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.request.dto.LogInRequest;
import africa.semicolon.notesManagementSystem.request.dto.LogInResponse;
import africa.semicolon.notesManagementSystem.request.dto.RegisterRequest;
import africa.semicolon.notesManagementSystem.request.dto.RegisterResponse;
import africa.semicolon.notesManagementSystem.data.models.User;

public interface UserService  {
    LogInResponse logIn(LogInRequest logInRequest);
    LogInResponse logOut(LogInRequest logInRequest);
    RegisterResponse register(RegisterRequest Request);
    User findUserByUsername(String username);
}
