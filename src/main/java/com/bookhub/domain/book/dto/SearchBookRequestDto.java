package com.bookhub.domain.book.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchBookRequestDto {

    // 검색어
    private String query;
    // 한 번에 표시할 검색 결과 개수
    private Integer display;
    // 검색 시작 위치(기본 : 1, 최대 : 100)
    private Integer start;
    // 검색 결과 정렬 방법(sim : 정확도순 내림차순, date : 출간인순 내림차순)
    private String sort;
}
