package br.com.frwk.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
public class UserPostRequestBody {


    private UUID id;
    @NotEmpty(message = "the user Name is required")
    private String name;
    @NotEmpty(message = "the user lastname is required")
    private String lastName;
    @NotEmpty(message = "the user e-mail is required")
    private String email;
    @NotEmpty(message = "the user password is required")
    private String password;
}
