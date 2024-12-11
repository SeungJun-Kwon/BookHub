package com.bookhub.domain.book.service;

import com.bookhub.domain.book.dto.SearchBookRequestDto;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class BookService {

    private final RestTemplate restTemplate;

    @Value("${naver.client.id}")
    private String clientId;
    private final String headerClientId = "X-Naver-Client-Id";

    @Value("${naver.client.secret}")
    private String clientSecret;
    private final String headerClientSecret = "X-Naver-Client-Secret";

    private final String baseUrl = "https://openapi.naver.com/";
    private final String path = "v1/search/book.json";

    public void searchBook(SearchBookRequestDto requestDto) {
        URI uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path(path)
            .queryParam("query", requestDto.getQuery())
            .queryParam("display", requestDto.getDisplay() == null ? 20 : requestDto.getDisplay())
            .queryParam("start", requestDto.getStart() == null ? 1 : requestDto.getStart())
            .queryParam("sort", requestDto.getSort() == null ? "date" : requestDto.getSort())
            .encode(StandardCharsets.UTF_8)
            .build().toUri();

        RequestEntity<Void> req = RequestEntity
            .get(uri)
            .header(headerClientId, clientId)
            .header(headerClientSecret, clientSecret)
            .build();

        ResponseEntity<String> exchange = restTemplate.exchange(req, String.class);

        System.out.println(exchange.getBody());
    }
}
