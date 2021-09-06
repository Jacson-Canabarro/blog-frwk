package br.com.frwk.responses;

import br.com.frwk.requests.ImageRequestBody;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PostResponseBody {

    private UUID id;
    private String text;
    private String title;
    private String link;
    private UUID userId;
    private ImageRequestBody image;
    private List<CommentResponseBody> comments = new ArrayList<>();
}
