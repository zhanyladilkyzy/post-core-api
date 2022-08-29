package kz.dar.backend.postcoreapi.service;

import kz.dar.backend.postcoreapi.model.PostRequest;
import kz.dar.backend.postcoreapi.model.PostResponse;
import kz.dar.backend.postcoreapi.repository.PostEntity;
import kz.dar.backend.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public PostResponse createPost(PostRequest postRequest) {
        postRequest.setPostId(UUID.randomUUID().toString());
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);
        postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        List<PostEntity> postEntities = new ArrayList<>();
        postRepository.findAll().forEach(postEntities::add);
        return postEntities.stream().map(post -> modelMapper.map(post, PostResponse.class)).collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostById(String postId) {
        return modelMapper.map(postRepository.getPostEntityByPostId(postId), PostResponse.class);
    }

    @Override
    public PostResponse updatePostById(String postId, PostRequest postRequest) {
        postRequest.setPostId(UUID.randomUUID().toString());
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);
        PostEntity dbEntity = postRepository.getPostEntityByPostId(postId);
        postEntity.setId(dbEntity.getId());
        postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public void deletePostById(String postId) {
        postRepository.deletePostEntityByPostId(postId);
    }
}
