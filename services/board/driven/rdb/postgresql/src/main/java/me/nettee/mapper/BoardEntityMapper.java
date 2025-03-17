package me.nettee.mapper;

import me.nettee.Board;
import me.nettee.entity.BoardEntity;
import org.mapstruct.Mapper;
import me.nettee.BoardQueryModels.BoardDetail;
import me.nettee.BoardQueryModels.BoardSummary;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BoardEntityMapper {

    Board toDomain(BoardEntity boardEntity);

    BoardEntity toEntity(Board board);

    BoardDetail toBoardDetail(BoardEntity boardEntity);

    BoardSummary toBoardSummary(BoardEntity boardEntity);

    default Optional<Board> toOptionalDomain(BoardEntity boardEntity) {
        return Optional.ofNullable(toDomain(boardEntity));
    }

    default Optional<BoardDetail> toOptionalBoardDetail(BoardEntity boardEntity) {
        return Optional.ofNullable(toBoardDetail(boardEntity));
    }
}
