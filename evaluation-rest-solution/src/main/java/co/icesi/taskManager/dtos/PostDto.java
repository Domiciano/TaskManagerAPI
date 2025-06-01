package co.icesi.taskManager.dtos;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String content;
    private Timestamp createdAt;
    private UserDto user;
    private CommentsDto[] comments;
}
