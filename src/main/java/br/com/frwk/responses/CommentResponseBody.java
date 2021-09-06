package br.com.frwk.responses;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class CommentResponseBody {
    private String text;
    private UUID userID;
}
