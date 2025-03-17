package me.nettee;

import me.nettee.dto.BoardCommandDto.BoardUpdateCommand;
import me.nettee.dto.BoardCommandDto.BoardCreateCommand;
import me.nettee.dto.BoardCommandDto.BoardCommandResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import me.nettee.mapper.BoardDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import me.netttee.usecase.BoardCreateUseCase;
import me.netttee.usecase.BoardDeleteUseCase;
import me.netttee.usecase.BoardUpdateUseCase;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardCommandApi {

    private final BoardCreateUseCase boardCreateUseCase;
    private final BoardUpdateUseCase boardUpdateUseCase;
    private final BoardDeleteUseCase boardDeleteUseCase;

    private final BoardDtoMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardCommandResponse createBoard(@RequestBody @Valid BoardCreateCommand boardCreateCommand) {
        // Map to Domain
        var board = mapper.toDomain(boardCreateCommand);

        return BoardCommandResponse.builder()
                .board(boardCreateUseCase.createBoard(board))
                .build();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BoardCommandResponse updateBoard(
            @PathVariable("id") Long id,
            @Valid @RequestBody BoardUpdateCommand boardUpdateCommand
    ) {
        // Map to Domain
        var board = mapper.toDomain(id, boardUpdateCommand);

        return BoardCommandResponse.builder()
                .board(boardUpdateUseCase.updateBoard(board))
                .build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBoard(@PathVariable("id") Long id) {
        boardDeleteUseCase.deleteBoard(id);
    }
}
