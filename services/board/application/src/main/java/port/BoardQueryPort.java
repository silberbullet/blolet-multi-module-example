package port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import readmodel.BoardQueryModels.BoardDetail;
import readmodel.BoardQueryModels.BoardSummary;
import type.BoardStatus;

import java.util.Optional;
import java.util.Set;

public interface BoardQueryPort {

    Optional<BoardDetail> findById(Long id);

    Page<BoardSummary> findAll(Pageable pageable);

    Page<BoardSummary> findByStatusesList(Set<BoardStatus> statuses, Pageable pageable);
}
    