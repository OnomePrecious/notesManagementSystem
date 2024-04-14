package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.dto.LogInRequest;
import africa.semicolon.notesManagementSystem.data.dto.LogInResponse;
import africa.semicolon.notesManagementSystem.data.dto.RegisterRequest;
import africa.semicolon.notesManagementSystem.data.dto.RegisterResponse;
import africa.semicolon.notesManagementSystem.exception.UnableToLogInException;
import africa.semicolon.notesManagementSystem.exception.UnableToLogOutException;
import africa.semicolon.notesManagementSystem.exception.UsernameAlreadyExistsException;
import africa.semicolon.notesManagementSystem.models.User;
import africa.semicolon.notesManagementSystem.repository.UserRepository;
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
        if (user.getPassword().equalsIgnoreCase(logInRequest.getPassword())) user.setLoggedIn(true);
        else throw new UnableToLogInException("you must have registered before you can login");
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
        mapUserRequestToRegister(request,user);
        if(isAValidUser(user)) userRepository.save(user);
        else throw new UsernameAlreadyExistsException("user already exist");
        return mapUserToRegisterResponse(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
