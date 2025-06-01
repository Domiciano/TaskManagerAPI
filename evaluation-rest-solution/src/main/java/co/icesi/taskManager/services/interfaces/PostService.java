package co.icesi.taskManager.services.interfaces;

import java.util.List;

import co.icesi.taskManager.model.Post;

public interface PostService {
    Post createPost(Post post);
    Post updatePost(Post post);
    void deletePost(long postId);
    Post getPostById(long postId);
    List<Post> getAllPosts();
}
