package me.netttee.port;

import me.nettee.type.BoardStatus;
import me.nettee.Board;

import java.util.Optional;

public interface BoardCommandPort {
    
    Optional<Board> findById(Long id);

    Board create(Board board);

    Board update(Board board);

    void updateStatus(Long id, BoardStatus status);
}
