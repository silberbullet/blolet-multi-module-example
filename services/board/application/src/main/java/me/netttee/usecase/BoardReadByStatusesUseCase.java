package me.netttee.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.nettee.type.BoardStatus;

import java.util.Set;
import me.nettee.BoardQueryModels.BoardSummary;


public interface BoardReadByStatusesUseCase {

    Page<BoardSummary> findByStatuses(Set<BoardStatus> statuses, Pageable pageable);
}
