package br.com.frwk.requests;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
public class DeletePostORCommentRequestBody {

    @NotNull(message = "the post creator id is required")
    private UUID userId;

    @NotNull(message = "the post id is required")
    private UUID postId;
}
