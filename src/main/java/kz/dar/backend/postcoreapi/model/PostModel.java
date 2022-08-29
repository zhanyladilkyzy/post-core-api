package kz.dar.backend.postcoreapi.model;

import lombok.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {

    private String postId;

    @NotNull
    private String clientId;

    @NotNull
    private String postRecipientId;

    private PostStatus status;

}
