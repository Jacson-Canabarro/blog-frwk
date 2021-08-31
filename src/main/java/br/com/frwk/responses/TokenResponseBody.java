package br.com.frwk.responses;

import lombok.Data;

@Data
public class TokenResponseBody {

    private String token;
    private String type;

    public TokenResponseBody(String token, String type) {
        this.token = token;
        this.type = type;

    }
}
