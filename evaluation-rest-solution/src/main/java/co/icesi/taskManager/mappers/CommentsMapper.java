package co.icesi.taskManager.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import co.icesi.taskManager.dtos.CommentsDto;
import co.icesi.taskManager.model.Comments;
import co.icesi.taskManager.model.Post;
import co.icesi.taskManager.model.User;

@Mapper(componentModel = "spring")
public interface CommentsMapper {
    
    @Mappings({
        @Mapping(source = "user", target = "user"),
        @Mapping(source = "post", target = "postId", qualifiedByName = "postToLong")
    })
    @Named("commentsToCommentsDto")
    CommentsDto commentsToCommentsDto(Comments comments);

    @Named("postToLong")
    default Long postToLong(Post post) {
        return post != null ? post.getId() : null;
    }
}
