package org.example.domain;

import org.example.base.CommonUtil;

import java.util.ArrayList;

public class ArticleRepository {
    CommonUtil commonUtil = new CommonUtil();
    ArrayList<Article> articlelist = new ArrayList<>();
    int latesId = 4;

    public ArticleRepository() {
        makedate();
    }

    public void makedate() {
        Article a1 = new Article(1, " 자바 제목1", "내용1", 0, commonUtil.getCurrentTime());
        Article a2 = new Article(2, "제목2", "내용2", 0, commonUtil.getCurrentTime());
        Article a3 = new Article(3, "자바 제목3", "내용3", 0, commonUtil.getCurrentTime());

        articlelist.add(a1);
        articlelist.add(a2);
        articlelist.add(a3);
    }

    public ArrayList<Article> findBykeyword(String Keyword) {
        ArrayList<Article> searchedList = new ArrayList<>();

        for (int i = 0; i < articlelist.size(); i++) {
            Article article = articlelist.get(i);
            if (article.getTitle().contains(Keyword)) {
                searchedList.add(article);
            }
        }
        return searchedList;
    }

    public Article findByIndx(int id) {
        for (int i = 0; i < articlelist.size(); i++) {
            Article article = articlelist.get(i);

            if (article.getId() == id) {
                return article;
            }
        }
        return null;

    }

    public void deleteArticle(Article article){
        articlelist.remove(article);
    }
    public void updateArticle(Article article, String newTitle, String newBody){
        article.setTitle(newTitle);
        article.setBody(newBody);
    }
    public ArrayList<Article> findAll(){return articlelist;}

    public Article saveArticle(String title, String body){
        Article article = new Article(latesId,  title, body, 0, commonUtil.getCurrentTime());
        latesId++;
        articlelist.add(article);

        return article;
    }


}
