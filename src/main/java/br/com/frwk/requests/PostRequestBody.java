package br.com.frwk.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PostRequestBody {


    @NotNull(message = "the post creator id is required")
    private UUID userId;

    @NotEmpty(message = "the post title is required")
    private String title;

    @NotEmpty(message = "the post text is required")
    private String text;

    @NotEmpty(message = "the post link is required")
    private String link;


    @NotNull(message = "the image is required")
    private ImageRequestBody image;

    private UUID postId;


}
