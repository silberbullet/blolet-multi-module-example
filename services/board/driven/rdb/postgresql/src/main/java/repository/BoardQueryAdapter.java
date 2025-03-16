package repository;

import static entity.QBoardEntity.boardEntity;

import entity.BoardEntity;
import entity.type.BoardEntityStatus;
import mapper.BoardEntityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import port.BoardQueryPort;
import readmodel.BoardQueryModels;
import type.BoardStatus;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class BoardQueryAdapter extends QuerydslRepositorySupport implements BoardQueryPort {
    private final BoardEntityMapper boardEntityMapper;
    private Map<Set<BoardStatus>, Set<BoardEntityStatus>> statusMap = new ConcurrentHashMap<>();

    public BoardQueryAdapter(
        BoardEntityMapper boardEntityMapper) {
        super(BoardEntity.class);
        this.boardEntityMapper = boardEntityMapper;
    }

    @Override
    public Optional<BoardQueryModels.BoardDetail> findById(Long id) {
        return boardEntityMapper.toOptionalBoardDetail(
                getQuerydsl().createQuery()
                        .select(boardEntity)
                        .from(boardEntity)
                        .where(boardEntity.id.eq(id)
                        ).fetchOne()
        );
    }

    @Override
    public Page<BoardQueryModels.BoardSummary> findAll(Pageable pageable) {
        // 기본 쿼리 생성
        var query = getQuerydsl().createQuery()
            .select(boardEntity)
            .from(boardEntity)
            .where();

        // pageable 정렬 조건 적용
        pageable.getSort().forEach(order -> {
            if (order.isAscending()) {
                query.orderBy(boardEntity.createdAt.asc()); // createdAt 필드를 기준으로 오름차순 정렬
            } else {
                query.orderBy(boardEntity.createdAt.desc()); // createdAt 필드를 기준으로 내림차순 정렬
            }
        });

        var result = query
                .offset(pageable.getOffset()) // 현재 페이지의 오프셋 설정
                .limit(pageable.getPageSize())// 페이지 크기 설정
                .fetch(); // 쿼리 실행

        var totalCount  = getQuerydsl().createQuery()
                .select(boardEntity.count())
                .from(boardEntity)
                .where();

        return PageableExecutionUtils.getPage(
                result.stream().map(boardEntityMapper::toBoardSummary).toList(),
                pageable,
                totalCount::fetchOne
        );
    }

    @Override
    public Page<BoardQueryModels.BoardSummary> findByStatusesList(Set<BoardStatus> statuses, Pageable pageable) {
        // 기본 쿼리 생성
        var boardEntityStatuses = statusMap.computeIfAbsent(
            statuses,
            (ignore) -> statuses.stream()
                    .map(BoardEntityStatus::valueOf)
                    .collect(Collectors.toSet())
        );

        var query = getQuerydsl().createQuery()
                .select(boardEntity)
                .from(boardEntity)
                .where(boardEntity.status.in(boardEntityStatuses));

        // pageable 정렬 조건 적용
        pageable.getSort().forEach(order ->
                query.orderBy(order.isAscending() ?
                    boardEntity.createdAt.asc() :
                    boardEntity.createdAt.desc())
        );

        var result = query
                .offset(pageable.getOffset()) // 현재 페이지의 오프셋 설정
                .limit(pageable.getPageSize()) // 페이지 크기 설정
                .fetch();

        var totalCount  = getQuerydsl().createQuery()
                .select(boardEntity.count())
                .from(boardEntity)
                .where(boardEntity.status.in(boardEntityStatuses));

        return PageableExecutionUtils.getPage(
                result.stream()
                    .map(boardEntityMapper::toBoardSummary)
                    .toList(),
                pageable,
                totalCount::fetchOne
        );
    }
}