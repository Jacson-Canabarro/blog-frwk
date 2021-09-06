package br.com.frwk.mappers;


import br.com.frwk.models.Comment;
import br.com.frwk.requests.CommentRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {Comment.class})
public abstract class CommentMapper {
    public static final CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    public abstract Comment toComment(CommentRequestBody commentRequestBody);
}
