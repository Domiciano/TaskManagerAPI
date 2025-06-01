package co.icesi.taskManager.controllers.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.icesi.taskManager.dtos.PostDto;

@RequestMapping("/posts")
public interface PostController {
    
    @GetMapping
    public ResponseEntity<List<PostDto>> findAllPost(Authentication auth);

    @PostMapping
    public ResponseEntity<?> addPost(@RequestBody PostDto dto);

    @PutMapping
    public ResponseEntity<?> updatePost(@RequestBody PostDto dto);

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable long id);

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id);

}
