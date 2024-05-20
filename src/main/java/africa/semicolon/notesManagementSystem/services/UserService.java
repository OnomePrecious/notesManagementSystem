package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.dtos.request.ChangePasswordRequest;
import africa.semicolon.notesManagementSystem.dtos.request.LogInRequest;
import africa.semicolon.notesManagementSystem.dtos.response.ChangePasswordResponse;
import africa.semicolon.notesManagementSystem.dtos.response.LogInResponse;
import africa.semicolon.notesManagementSystem.dtos.request.RegisterRequest;
import africa.semicolon.notesManagementSystem.dtos.response.RegisterResponse;
import africa.semicolon.notesManagementSystem.data.models.User;

public interface UserService  {
    LogInResponse logIn(LogInRequest logInRequest);
    LogInResponse logOut(LogInRequest logInRequest);
    RegisterResponse register(RegisterRequest Request);
    User findUserByUsername(String username);
    ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest);
}
