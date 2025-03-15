package port;

import type.BoardStatus;
import domain.Board;

import java.util.Optional;

public interface BoardCommandPort {
    
    Optional<Board> findById(Long id);

    Board create(Board board);

    Board update(Board board);

    void updateStatus(Long id, BoardStatus status);
}
