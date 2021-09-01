package br.com.frwk.responses;

import lombok.Data;

import java.util.UUID;

@Data
public class UserReponseBody {

    private UUID id;
    private String name;
    private String lastName;
    private String email;
}
