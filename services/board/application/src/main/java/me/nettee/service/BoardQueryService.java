package me.nettee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import me.nettee.port.BoardQueryPort;
import me.nettee.BoardQueryModels.BoardDetail;
import me.nettee.BoardQueryModels.BoardSummary;
import me.nettee.type.BoardStatus;
import me.nettee.usecase.BoardReadByStatusesUseCase;
import me.nettee.usecase.BoardReadUseCase;

import java.util.Set;

import static me.nettee.BoardQueryErrorCode.BOARD_NOT_FOUND;

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
