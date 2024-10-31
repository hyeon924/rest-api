package com.example.demo.article.dto;

import com.example.demo.article.entity.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDTO {
  private final Long id;

  private final String title;
  private final String content;

  private final LocalDateTime createdDate;

  private final LocalDateTime modifiedDate;

  public ArticleDTO(Article article) {
    this.id= article.getId();
    this.title= article.getTitle();
    this.content= article.getContent();
    this.createdDate=article.getCreatedDate();
    this.modifiedDate=article.getModifiedDate();
  }
}
