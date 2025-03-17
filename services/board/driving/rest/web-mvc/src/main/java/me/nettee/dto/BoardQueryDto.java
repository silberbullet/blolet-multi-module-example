package me.nettee.dto;

import lombok.Builder;
import me.nettee.BoardQueryModels.BoardDetail;

public final class BoardQueryDto {
    private BoardQueryDto() {}

    @Builder
    public record BoardDetailResponse(
            BoardDetail board
    ){}
}
