package co.icesi.taskManager.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.icesi.taskManager.dtos.PostDto;
import co.icesi.taskManager.model.Post;

@Mapper(componentModel = "spring", uses = {CommentsMapper.class})
public interface PostMapper {
    
    @Mappings({
        @Mapping(source = "user", target = "user"),
        @Mapping(source = "comments", target = "comments", qualifiedByName = "commentsToCommentsDto")
    })
    PostDto postToPostDto(Post post);

    @Mappings({
        @Mapping(source = "user", target = "user", ignore = true),
        @Mapping(source = "comments", target = "comments", ignore = true)
    })
    Post postDtoToPost(PostDto postDto);
}
