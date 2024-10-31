package com.example.demo.article.controller;

import com.example.demo.article.dto.ArticleDTO;
import com.example.demo.article.entity.Article;
import com.example.demo.article.service.ArticleService;
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
  public List<ArticleDTO> list() {

    List<ArticleDTO> articleList = new ArrayList<>();

    Article article1 = new Article("title01", "content01");
    articleList.add(new ArticleDTO(article1));

    Article article2 = new Article("title01", "content01");
    articleList.add(new ArticleDTO(article2));

    Article article3 = new Article("title01", "content01");
    articleList.add(new ArticleDTO(article3));

    return articleList;
  }

  @GetMapping("/{id}")
  public List<ArticleDTO> getArticle() {
       List<ArticleDTO> articleList = new ArrayList<>();

    Article article1 = new Article("title01", "content01");
    articleList.add(new ArticleDTO(article1));

    return articleList;
  }

  @PostMapping("")
  public String create() {
    return "등록";
  }

  @PatchMapping("/{id}")
  public String modify() {
    return "수정";
  }

  @DeleteMapping("/{id}")
  public String delete() {
    return "삭제";
  }

}
