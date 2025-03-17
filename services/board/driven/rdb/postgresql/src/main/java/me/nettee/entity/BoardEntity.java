package me.nettee.entity;

import me.nettee.entity.type.BoardEntityStatus;
import me.nettee.entity.type.BoardEntityStatusConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import me.nettee.support.LongBaseTimeEntity;

import java.util.Objects;

@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "board")
public class BoardEntity extends LongBaseTimeEntity {
    private String title;
    private String content;

    @Convert(converter = BoardEntityStatusConverter.class)
    private BoardEntityStatus status;

    @Builder
    public BoardEntity(String title, String content, BoardEntityStatus status) {
        this.title = title;
        this.content = content;
        this.status = status;
    }

    @Builder(
            builderClassName = "UpdateBoardBuilder",
            builderMethodName = "prepareUpdate",
            buildMethodName = "update"
    )
    public void updateBoard(String title, String content, BoardEntityStatus status) {
        Objects.requireNonNull(title, "title cannot be null");
        Objects.requireNonNull(content, "content cannot be null");
        Objects.requireNonNull(status, "status cannot be null");

        this.title = title;
        this.content = content;
        this.status = status;
    }
    
    @Builder(
            builderClassName = "UpdateStatusBoardBuilder",
            builderMethodName = "prepareUpdateStatus",
            buildMethodName = "updateStatus"
    )
    public void updateStatus(BoardEntityStatus status) {
        Objects.requireNonNull(status, "status cannot be null");
        this.status = status;
    }
}