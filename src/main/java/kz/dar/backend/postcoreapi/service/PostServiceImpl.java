package kz.dar.backend.postcoreapi.service;

import kz.dar.backend.postcoreapi.model.Post;
import kz.dar.backend.postcoreapi.model.PostStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements  PostService {

    private static final HashMap<String, Post> postMap = new HashMap<>();

    static {
        Post post1 = new Post(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), PostStatus.CREATED);
        Post post2 = new Post(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), PostStatus.FORMED);
        Post post3 = new Post(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), PostStatus.SENT);

        postMap.put(post1.getPostId(), post1);
        postMap.put(post2.getPostId(), post2);
        postMap.put(post3.getPostId(), post3);
    }

    @Override
    public void createPost(Post post) {
        post.setPostId(UUID.randomUUID().toString());
        postMap.put(post.getPostId(), post);
    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public Post getPostById(String postId) {
        return postMap.get(postId);
    }

    @Override
    public void updatePostById(String postId, Post post) {
        post.setPostId(UUID.randomUUID().toString());
        postMap.put(post.getPostId(), post);
    }

    @Override
    public void deletePostById(String postId) {
        postMap.remove(postId);
    }
}
