package dto;

import lombok.Builder;
import readmodel.BoardQueryModels.BoardDetail;

public final class BoardQueryDto {
    private BoardQueryDto() {}

    @Builder
    public record BoardDetailResponse(
            BoardDetail board
    ){}
}
