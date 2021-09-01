package br.com.frwk.mappers;

import br.com.frwk.models.User;
import br.com.frwk.requests.UserPostRequestBody;
import br.com.frwk.responses.UserReponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {User.class})
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "authorities", ignore = true)
    public abstract User toUser(UserPostRequestBody userPostRequestBody);

    @Mapping(target = "password", ignore = true)
    public abstract UserPostRequestBody toUserPostRequestBody(User user);


    public abstract UserReponseBody toUserResponseBody(User user);



}
