package br.com.frwk.responses;

import lombok.Data;

import java.util.UUID;

@Data
public class CommentResponseBody {
    private String text;
    private UUID userID;
    private String userName;
}
