package br.com.frwk.mappers;

import br.com.frwk.models.Post;
import br.com.frwk.requests.PostRequestBody;
import br.com.frwk.responses.PostResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {Post.class})
public abstract class PostMapper {

    public static final PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "user", ignore = true)
    public abstract Post toPost(PostRequestBody postRequestBody);

    public abstract PostResponseBody toPostResponseBody(Post post);
}
