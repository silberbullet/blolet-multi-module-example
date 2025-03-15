package usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import type.BoardStatus;

import java.util.Set;
import readmodel.BoardQueryModels.BoardSummary;


public interface BoardReadByStatusesUseCase {

    Page<BoardSummary> findByStatuses(Set<BoardStatus> statuses, Pageable pageable);
}
