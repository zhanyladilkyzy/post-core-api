package kz.dar.backend.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private String postId;

    @NotNull
    private String clientId;

    @NotNull
    private String postRecipientId;

    private String status;
}
