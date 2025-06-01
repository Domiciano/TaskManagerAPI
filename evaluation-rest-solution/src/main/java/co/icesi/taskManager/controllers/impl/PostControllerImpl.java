package co.icesi.taskManager.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.icesi.taskManager.controllers.interfaces.PostController;
import co.icesi.taskManager.dtos.PostDto;
import co.icesi.taskManager.mappers.PostMapper;
import co.icesi.taskManager.model.Post;
import co.icesi.taskManager.services.interfaces.PostService;

@RestController
@RequestMapping("/posts")
public class PostControllerImpl implements PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostMapper mapper;

    @Override
    public ResponseEntity<List<PostDto>> findAllPost(Authentication auth) {
        try {
            List<Post> posts = postService.getAllPosts();
            List<PostDto> postDtos = posts.stream().map(mapper::postToPostDto).toList();
            return ResponseEntity.ok(postDtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_POST')")
    public ResponseEntity<?> addPost(PostDto dto) {
        Post post = mapper.postDtoToPost(dto);
        post = postService.createPost(post);
        if (post == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).body(mapper.postToPostDto(post));
    }

    @Override
    public ResponseEntity<?> updatePost(PostDto dto) {
        Post post = mapper.postDtoToPost(dto);
        post = postService.updatePost(post);
        if (post == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(200).body(mapper.postToPostDto(post));
    }

    @Override
    public ResponseEntity<?> deletePost(long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findById(long id) {
        try {
            Post post = postService.getPostById(id);
            PostDto dto = mapper.postToPostDto(post);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
