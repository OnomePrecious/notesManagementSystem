package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.data.dto.EditTagRequest;
import africa.semicolon.notesManagementSystem.data.dto.TagRequest;
import africa.semicolon.notesManagementSystem.data.dto.TagResponse;
import africa.semicolon.notesManagementSystem.models.Tag;

import java.util.List;

public interface TagServices {
    TagResponse createTag (TagRequest request);
    TagResponse editTag(EditTagRequest editTagRequest);

}
