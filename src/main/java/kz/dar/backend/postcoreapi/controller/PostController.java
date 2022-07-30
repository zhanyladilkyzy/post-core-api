package kz.dar.backend.postcoreapi.controller;

import kz.dar.backend.postcoreapi.model.Post;
import kz.dar.backend.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<String> sentPost(@Valid @RequestBody Post post) {
        postService.createPost(post);
        return new ResponseEntity<String>("Successfully sent", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId, @Valid @RequestBody Post post) {
         postService.updatePostById(postId, post);
         return new ResponseEntity<String>("Successfully updated!", HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<String>("Successfully deleted!", HttpStatus.OK);
    }

}
