package com.example.demo.article.controller;

import com.example.demo.RsData.RsData;
import com.example.demo.article.dto.ArticleDTO;
import com.example.demo.article.entity.Article;
import com.example.demo.article.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/articles")
public class ApiV1ArticleController {
  private final ArticleService articleService;

  @AllArgsConstructor
  @Getter
  public static class ArticlesResponse {
    private final List<ArticleDTO> articleList;
  }

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

  @Getter
  @AllArgsConstructor
  public static class ArticleResponse {
    private final ArticleDTO article;
  }

  @GetMapping("/{id}")
  public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
    Article article = new Article("title", "content");

    ArticleDTO articleDTO = new ArticleDTO(article);

    return RsData.of("200", " 단건 조회 성공", new ArticleResponse(articleDTO));
  }

  @PostMapping("")
  public String create(@RequestParam("subject") String subject, @RequestParam("content") String content) {
    System.out.println(subject);
    System.out.println(content);
    return "등록완료";
  }

  @PatchMapping("/{id}")
  public String modify(@PathVariable("id") Long id, @RequestParam("subject") String subject, @RequestParam("content") String content) {
    System.out.println(id);
    System.out.println(subject);
    System.out.println(content);
    return "수정완료";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") Long id) {
    System.out.println(id);
    return "삭제완료";
  }

}
