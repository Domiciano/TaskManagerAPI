package co.icesi.taskManager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.taskManager.model.Post;
import co.icesi.taskManager.repositories.PostRepository;
import co.icesi.taskManager.services.interfaces.PostService;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {

        if (postIsValid(post)) {
            postRepository.save(post);
            return post;
        } else {
            return null;
        }

    }

    private boolean postIsValid(Post post) {
        return true;
    }

    @Override
    public Post updatePost(Post post) {
        Post p = postRepository.findById(post.getId()).orElseThrow(() -> new RuntimeException("Post not found"));
        p.setCreatedAt(post.getCreatedAt());
        p.setContent(post.getContent());
        p.setUser(post.getUser());
        p.setComments(post.getComments());

        if (postIsValid(p)) {
            postRepository.save(p);
            return p;
        } else {
            return null;
        }
    }

    @Override
    public void deletePost(long postId) {
        Post p = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(p);
    }

    @Override
    public Post getPostById(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        return post;

    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

}
