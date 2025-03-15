package usecase;

import readmodel.BoardQueryModels.BoardDetail;

public interface BoardReadUseCase {

    BoardDetail getBoard(Long id);
}