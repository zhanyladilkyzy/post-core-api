package kz.dar.backend.postcoreapi.service;

import kz.dar.backend.postcoreapi.model.Post;

import java.util.List;

public interface PostService {

    void createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(String postId);

    void updatePostById(String postId, Post post);

    void deletePostById(String postId);
}
