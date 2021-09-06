package br.com.frwk.requests;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import javax.validation.constraints.NotEmpty;

@Data
public class UserAuthRequestBody {


    @NotEmpty(message = "the user e-mail is required")
    private String email;
    @NotEmpty(message = "the user password is required")
    private String password;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(this.email, this.password);
    }
}
