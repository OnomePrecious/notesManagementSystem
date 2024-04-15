package africa.semicolon.notesManagementSystem.request.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class TagResponse {
    private String name;
    private Tags tag;
    private LocalDateTime responseTime;
}
