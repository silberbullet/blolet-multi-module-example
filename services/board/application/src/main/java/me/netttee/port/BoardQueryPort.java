package me.netttee.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.nettee.BoardQueryModels.BoardDetail;
import me.nettee.BoardQueryModels.BoardSummary;
import me.nettee.type.BoardStatus;

import java.util.Optional;
import java.util.Set;

public interface BoardQueryPort {

    Optional<BoardDetail> findById(Long id);

    Page<BoardSummary> findAll(Pageable pageable);

    Page<BoardSummary> findByStatusesList(Set<BoardStatus> statuses, Pageable pageable);
}
    