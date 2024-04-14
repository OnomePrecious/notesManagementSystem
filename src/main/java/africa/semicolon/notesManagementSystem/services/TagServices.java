package africa.semicolon.notesManagementSystem.services;

import africa.semicolon.notesManagementSystem.request.dto.EditTagRequest;
import africa.semicolon.notesManagementSystem.request.dto.TagRequest;
import africa.semicolon.notesManagementSystem.request.dto.TagResponse;

public interface TagServices {
    TagResponse createTag (TagRequest request);
    TagResponse editTag(EditTagRequest editTagRequest);

}
