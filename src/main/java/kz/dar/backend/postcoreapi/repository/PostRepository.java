package kz.dar.backend.postcoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, String> {
    PostEntity getPostEntityByPostId(String postId);

    @Transactional
    void deletePostEntityByPostId(String postId);
}
