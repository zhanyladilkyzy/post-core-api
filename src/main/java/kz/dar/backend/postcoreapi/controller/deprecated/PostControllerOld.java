package kz.dar.backend.postcoreapi.controller.deprecated;

import kz.dar.backend.postcoreapi.model.PostModel;
import kz.dar.backend.postcoreapi.service.deprecated.PostServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deprecated/post")
public class PostControllerOld {

    @Autowired
    private PostServiceOld postServiceOld;

    @Autowired
    Environment environment;

    @GetMapping("/check")
    public String check(){
        return "Post controller works! " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<String> sentPost(@Valid @RequestBody PostModel postModel) {
        postServiceOld.createPost(postModel);
        return new ResponseEntity<String>("Successfully sent", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postServiceOld.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postServiceOld.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId, @Valid @RequestBody PostModel postModel) {
         postServiceOld.updatePostById(postId, postModel);
         return new ResponseEntity<String>("Successfully updated!", HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        postServiceOld.deletePostById(postId);
        return new ResponseEntity<String>("Successfully deleted!", HttpStatus.OK);
    }

}
