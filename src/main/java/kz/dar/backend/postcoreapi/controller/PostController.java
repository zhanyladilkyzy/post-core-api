package kz.dar.backend.postcoreapi.controller;

import kz.dar.backend.postcoreapi.model.PostRequest;
import kz.dar.backend.postcoreapi.model.PostResponse;
import kz.dar.backend.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    Environment environment;

    @GetMapping("/check")
    public String check(){
        return "Post controller works! " + environment.getProperty("local.server.port");
    }


    @PostMapping("/create")
    private PostResponse createPost(@RequestBody PostRequest postRequest) {
        return postService.createPost(postRequest);
    }

    @GetMapping("/all")
    private List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    private PostResponse getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    private PostResponse updatePost(@PathVariable String postId, @RequestBody PostRequest postRequest) {
        postRequest.setPostId(postId);
        return postService.updatePostById(postId, postRequest);
    }

    @DeleteMapping("/{postId}")
    private ResponseEntity<String> deletePost(@PathVariable String postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<String>("Post deleted!", HttpStatus.OK);
    }

}
