package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.dtos.request.ChangePasswordRequest;
import africa.semicolon.notesManagementSystem.dtos.request.LogInRequest;
import africa.semicolon.notesManagementSystem.dtos.response.ChangePasswordResponse;
import africa.semicolon.notesManagementSystem.dtos.response.LogInResponse;
import africa.semicolon.notesManagementSystem.dtos.request.RegisterRequest;
import africa.semicolon.notesManagementSystem.dtos.response.RegisterResponse;
import africa.semicolon.notesManagementSystem.exception.UnableToLogInException;
import africa.semicolon.notesManagementSystem.exception.UnableToLogOutException;
import africa.semicolon.notesManagementSystem.exception.UserNotFoundException;
import africa.semicolon.notesManagementSystem.exception.UsernameAlreadyExistsException;
import africa.semicolon.notesManagementSystem.data.models.User;
import africa.semicolon.notesManagementSystem.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.notesManagementSystem.util.Mappers.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public LogInResponse logIn(LogInRequest logInRequest) {
        LogInResponse logInResponse = new LogInResponse();
        var user = findUserByUsername(logInRequest.getUsername());
        if (user.getUsername().equalsIgnoreCase(logInRequest.getUsername())) user.setLoggedIn(true);
        else throw new UnableToLogInException("Invalid username or password");
        if (user.getPassword().equalsIgnoreCase(logInRequest.getPassword())) user.setLoggedIn(true);
        else throw new UnableToLogInException("Invalid username or password");
        userRepository.save(user);
        return mapUserLogInResponse(user, logInResponse);
    }

    private boolean isAValidUser(User user) {
        return userRepository.findUserByUsername(user.getUsername()) == null;
    }

    @Override
    public LogInResponse logOut(LogInRequest logInRequest) {
        LogInResponse logInResponse = new LogInResponse();
        var user = findUserByUsername(logInRequest.getUsername());
        if (user.isLoggedIn()) user.setLoggedIn(false);
        else throw new UnableToLogOutException("you have logged out already");
        userRepository.save(user);
        return mapUserLogInResponse(user, logInResponse);
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = new User();
        mapUserRequestToRegister(request, user);
        if (isAValidUser(user)) userRepository.save(user);
        else throw new UsernameAlreadyExistsException("A user with this name already exist, try another username");
        return mapUserToRegisterResponse(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest) {
        var user = userRepository.findUserByUsername(changePasswordRequest.getUsername());
        if(!user.isLoggedIn()) throw new UserNotFoundException("You have to register first");
        mapChangePasswordRequest(changePasswordRequest, user);
        if(isAValidUser(user)) userRepository.save(user);
        else throw new UserNotFoundException("A user with this name already exist");
        return mapChangePasswordRequestToUser(user);
    }

}