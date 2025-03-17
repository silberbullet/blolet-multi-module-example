package me.netttee.usecase;

import me.nettee.BoardQueryModels.BoardDetail;

public interface BoardReadUseCase {

    BoardDetail getBoard(Long id);
}