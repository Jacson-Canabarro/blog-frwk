package br.com.frwk.responses;

import lombok.Data;

import java.util.UUID;

@Data
public class PostResponseBody {

    private UUID id;
    private String text;
    private UUID userId;
}
