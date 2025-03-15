package mapper;

import dto.BoardCommandDto.BoardCreateCommand;
import dto.BoardCommandDto.BoardUpdateCommand;
import dto.BoardQueryDto.BoardDetailResponse;
import domain.Board;
import readmodel.BoardQueryModels.BoardDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardDtoMapper {

    Board toDomain(BoardCreateCommand command);

    Board toDomain(Long id, BoardUpdateCommand command);

    BoardDetailResponse toDtoDetail(BoardDetail board);
}
