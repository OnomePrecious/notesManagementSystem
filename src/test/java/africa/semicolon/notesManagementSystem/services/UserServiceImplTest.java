package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.request.dto.LogInRequest;
import africa.semicolon.notesManagementSystem.request.dto.RegisterRequest;
import africa.semicolon.notesManagementSystem.exception.UnableToLogOutException;
import africa.semicolon.notesManagementSystem.exception.UsernameAlreadyExistsException;
import africa.semicolon.notesManagementSystem.data.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();

    }

    @Test
   public void test_thatICanLogIn() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("Precious");
        request.setPassword("My password");
        request.setEmail("precious onome002");
        request.setId("32");
        userService.register(request);

        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUsername("Precious");
        logInRequest.setPassword("My password");
        assertEquals(1,userRepository.count());

    }

    @Test
    public void test_thatICanLogOut() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("Precious");
        request.setPassword("My password");
        request.setEmail("precious onome002");
        request.setId("32");
        userService.register(request);

        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUsername("Precious");
        logInRequest.setPassword("My password");
        userService.logIn(logInRequest);
        userService.logOut(logInRequest);
        assertFalse(userRepository.findUserByUsername(logInRequest.getUsername()).isLoggedIn());

    }

    @Test
    public void testICanRegister() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("Precious");
        request.setPassword("My password");
        request.setEmail("precious onome002");
        request.setId("32");
        userService.register(request);


        assertEquals(1, userRepository.count());


    }
    @Test
    public void test_thatICanRegisterTwoPeople(){
        RegisterRequest request = new RegisterRequest();
        RegisterRequest request1 = new RegisterRequest();
        request.setUsername("Precious");
        request.setPassword("My password");
        request.setEmail("preciousonome002");
        request.setId("32");
        request1.setUsername("My name");
        request1.setPassword("password");
        request1.setEmail("precious67");
        request1.setId("34");
        userService.register(request);
        userService.register(request1);

        assertEquals(2, userRepository.count());

    }

    @Test
    public void test_thatICanFindUserByUsername() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("Precious");
        request.setPassword("My password");
        request.setEmail("precious onome002");
        request.setId("32");
        userService.register(request);

        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUsername("Precious");
        logInRequest.setPassword("My password");
        assertEquals("Precious", userRepository.findUserByUsername("Precious").getUsername());

    }
    @Test
    public void throwsExceptionWhenILogoutTwiceAtInterval(){
        RegisterRequest request = new RegisterRequest();
        request.setUsername("Precious");
        request.setPassword("My password");
        request.setEmail("precious onome002");
        request.setId("32");
        userService.register(request);

        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUsername("Precious");
        logInRequest.setPassword("My password");
        userService.logIn(logInRequest);
        userService.logOut(logInRequest);
        assertThrows(UnableToLogOutException.class, () -> userService.logOut(logInRequest));
    }
    @Test
    public void throwsExceptionWhenITryToRegisterWithAnExistingUsername(){
        RegisterRequest request = new RegisterRequest();
        RegisterRequest request1 = new RegisterRequest();
        request.setUsername("Precious");
        request.setPassword("My password");
        request.setEmail(" preciousonome002");
        request.setId("32");
        request1.setUsername("Precious");
        request1.setPassword("password");
        request1.setEmail("precious67");
        request1.setId("34");
        userService.register(request);
        assertThrows(UsernameAlreadyExistsException.class, () -> userService.register(request1));

    }


    }
