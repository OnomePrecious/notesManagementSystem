package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.repository.NoteRepository;
import africa.semicolon.notesManagementSystem.data.repository.UserRepository;
import africa.semicolon.notesManagementSystem.dtos.request.*;
import africa.semicolon.notesManagementSystem.dtos.response.Tags;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NoteServicesImplTest {
    @Autowired
    private NoteServices noteServices;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        noteRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void test_thatICanCreateNote() {
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

        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setUsername("Precious");
        noteRequest.setTimeOfRequest(LocalDateTime.now());
        noteRequest.setContent("The content");
        noteRequest.setTag(Tags.WORK);
        noteServices.createNote(noteRequest);

        assertEquals(1, noteRepository.count());
    }

    @Test
    public void test_thatICanEditMyNote() {
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

        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setUsername("Precious");
        noteRequest.setTimeOfRequest(LocalDateTime.now());
        noteRequest.setTitle("The title");
        noteRequest.setContent("The content");
        noteRequest.setTag(Tags.WORK);
        var note = noteServices.createNote(noteRequest);

        EditNoteRequest editNoteRequest = new EditNoteRequest();
        editNoteRequest.setUsername("Precious");
        editNoteRequest.setDateEdited(LocalDateTime.now());
        editNoteRequest.setNoteId(note.getNoteId());
        editNoteRequest.setTitle("This title");
        editNoteRequest.setTag(Tags.PERSONAL);
        editNoteRequest.setContent("This content");
        noteServices.editNote(editNoteRequest);

        assertEquals("This title", noteRepository.findNoteByContent("This content").getTitle());


    }

    @Test
    public void test_thatICanDeleteMyNoteById() {
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

        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setUsername("Precious");
        noteRequest.setTimeOfRequest(LocalDateTime.now());
        noteRequest.setTitle("my title");
        noteRequest.setContent("The content");
        noteRequest.setTag(Tags.PERSONAL);
        noteServices.createNote(noteRequest);
        noteServices.deleteNote(noteRequest);


        assertEquals(0, noteRepository.count());

    }

    @Test
    public void test_thatICanDeleteNoteById() {
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

        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setUsername("Precious");
        noteRequest.setTimeOfRequest(LocalDateTime.now());
        noteRequest.setTitle("my title");
        noteRequest.setContent("The content");
        noteRequest.setTag(Tags.PERSONAL);
        NoteRequest noteRequest1 = new NoteRequest();
        noteRequest1.setUsername("Precious");
        noteRequest1.setTitle("the title");
        noteRequest1.setTimeOfRequest(LocalDateTime.now());
        noteRequest1.setContent("The content");
        noteRequest1.setTag(Tags.IMPORTANT);
        noteServices.createNote(noteRequest);
        noteServices.createNote(noteRequest1);
        noteServices.deleteNote(noteRequest);


        assertEquals(1, noteRepository.count());
    }

    @Test
    public void test_thatICanFindAllMyNotes() {
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

        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setUsername("Precious");
        noteRequest.setTimeOfRequest(LocalDateTime.now());
        noteRequest.setTitle("my title");
        noteRequest.setContent("The content");
        noteRequest.setTag(Tags.PERSONAL);
        NoteRequest noteRequest1 = new NoteRequest();
        noteRequest1.setUsername("Precious");
        noteRequest1.setTitle("the title");
        noteRequest1.setTimeOfRequest(LocalDateTime.now());
        noteRequest1.setContent("The content");
        noteRequest1.setTag(Tags.IMPORTANT);
        noteServices.createNote(noteRequest);
        noteServices.createNote(noteRequest1);

        assertEquals(2, noteRepository.count());
    }
    @Test
    public void testThatICanShareMyNote(){
        RegisterRequest request = new RegisterRequest();
        request.setUsername("Precious");
        request.setPassword("My password");
        request.setEmail("precious onome002");
        userService.register(request);

        RegisterRequest request1 = new RegisterRequest();
        request1.setUsername("My name");
        request1.setPassword("password");
        request1.setEmail("precious67");
        userService.register(request1);



        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUsername("Precious");
        logInRequest.setPassword("My password");
        userService.logIn(logInRequest);

        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setUsername("Precious");
        noteRequest.setTimeOfRequest(LocalDateTime.now());
        noteRequest.setContent("The content");
        noteRequest.setTag(Tags.WORK);
       var note = noteServices.createNote(noteRequest);

        ShareNoteRequest shareNoteRequest = new ShareNoteRequest();
        shareNoteRequest.setUsername("Precious");
        shareNoteRequest.setNoteId(note.getNoteId());
        shareNoteRequest.setReceiverName("My name");
        shareNoteRequest.setDateShared(LocalDateTime.now());
        noteServices.shareNote(shareNoteRequest);
        var user1 =userService.findUserByUsername(request1.getUsername());
        assertEquals(2, noteRepository.count());

        assertEquals(user1.getNotes().size(),1);
    }

        @Test
    public void test_thatUserCanChangePassword(){
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

            ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
            changePasswordRequest.setUsername("Precious");
            changePasswordRequest.setPassword("new password");
            userService.changePassword(changePasswordRequest);

            assertEquals("Precious", userRepository.findUserByUsername("Precious"));

        }
}