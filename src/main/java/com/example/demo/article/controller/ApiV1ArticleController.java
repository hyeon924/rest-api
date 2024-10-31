package com.example.demo.article.controller;

import com.example.demo.RsData.RsData;
import com.example.demo.article.dto.ArticleDTO;
import com.example.demo.article.entity.Article;
import com.example.demo.article.request.ArticleCreateRequest;
import com.example.demo.article.request.ArticleModifyRequest;
import com.example.demo.article.response.ArticleResponse;
import com.example.demo.article.response.ArticlesResponse;
import com.example.demo.article.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/articles")
public class ApiV1ArticleController {
  private final ArticleService articleService;


  @GetMapping("")
  public RsData<ArticlesResponse> list() {

    List<ArticleDTO> articleList = new ArrayList<>();

    Article article1 = new Article("title01", "content01");
    articleList.add(new ArticleDTO(article1));

    Article article2 = new Article("title01", "content01");
    articleList.add(new ArticleDTO(article2));

    Article article3 = new Article("title01", "content01");
    articleList.add(new ArticleDTO(article3));

    return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
  }


  @GetMapping("/{id}")
  public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
    Article article = new Article("title", "content");

    ArticleDTO articleDTO = new ArticleDTO(article);

    return RsData.of("200", " 단건 조회 성공", new ArticleResponse(articleDTO));
  }

  @PostMapping("")
  public String create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
    System.out.println(articleCreateRequest.getSubject());
    System.out.println(articleCreateRequest.getContent());
    return "등록완료";
  }

  @PatchMapping("/{id}")
  public String modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
    System.out.println(id);
    System.out.println(articleModifyRequest.getSubject());
    System.out.println(articleModifyRequest.getContent());
    return "수정완료";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") Long id) {
    System.out.println(id);
    return "삭제완료";
  }

}
