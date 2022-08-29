package kz.dar.backend.postcoreapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="post_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String postId;

    @NotNull
    @Column(nullable = false)
    private String clientId;

    @NotNull
    @Column(nullable = false)
    private String postRecipientId;

    @Column(nullable = false)
    private String status;

}
