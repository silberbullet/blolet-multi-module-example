package service;

import domain.Board;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import port.BoardCommandPort;
import type.BoardStatus;
import usecase.BoardCreateUseCase;
import usecase.BoardDeleteUseCase;
import usecase.BoardUpdateUseCase;

import static exception.BoardCommandErrorCode.BOARD_NOT_FOUND;
import static exception.BoardCommandErrorCode.DEFAULT;

@Service
@RequiredArgsConstructor
public class BoardCommandService implements BoardCreateUseCase, BoardUpdateUseCase, BoardDeleteUseCase {

    private final BoardCommandPort boardCommandPort;

    public Board createBoard(Board board) {
        return boardCommandPort.create(board);
    }

    public Board updateBoard(Board board) {
        return boardCommandPort.update(board);
    }

    public void deleteBoard(Long id) {
        // softDelete 명을 가진 메서드가 생기면 변경
        // 현재 updateStatus로 REMOVE 상태로 변경
        boardCommandPort.updateStatus(id, BoardStatus.REMOVED);

        // Hard Delete 됬는지 확인 - 제외 할 가능성 있음
        Board board = boardCommandPort.findById(id)
                .orElseThrow(BOARD_NOT_FOUND::exception);

        assert board.getStatus() == BoardStatus.REMOVED : DEFAULT;

    }
}
