package kz.dar.backend.postcoreapi.service;

import kz.dar.backend.postcoreapi.model.PostRequest;
import kz.dar.backend.postcoreapi.model.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse createPost(PostRequest postRequest);

    List<PostResponse> getAllPosts();

    PostResponse getPostById(String postId);

    PostResponse updatePostById(String postId, PostRequest postRequest);

    void deletePostById(String postId);
}
