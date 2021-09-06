package br.com.frwk.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class CommentRequestBody {

    @NotNull(message = "the post id is required")
    private UUID postId;
    @NotEmpty(message = "the text is required")
    private String text;
    @NotNull(message = "the post creator id is required")
    private UUID userId;
}
