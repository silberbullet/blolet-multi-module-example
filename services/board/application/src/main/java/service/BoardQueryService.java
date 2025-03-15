package service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import port.BoardQueryPort;
import readmodel.BoardQueryModels.BoardDetail;
import readmodel.BoardQueryModels.BoardSummary;
import type.BoardStatus;
import usecase.BoardReadByStatusesUseCase;
import usecase.BoardReadUseCase;

import java.util.Set;

import static exception.BoardQueryErrorCode.BOARD_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BoardQueryService implements BoardReadUseCase, BoardReadByStatusesUseCase {

    private final BoardQueryPort boardQueryPort;

    @Override
    public BoardDetail getBoard(Long id) {
        return boardQueryPort.findById(id)
                .orElseThrow(BOARD_NOT_FOUND::exception);
    }

    @Override
    public Page<BoardSummary> findByStatuses(Set<BoardStatus> statuses, Pageable pageable) {
        return boardQueryPort.findByStatusesList(statuses, pageable);
    }
}
