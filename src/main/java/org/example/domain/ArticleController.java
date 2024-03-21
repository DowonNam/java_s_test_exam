package org.example.domain;

import org.example.base.CommonUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    CommonUtil commonUtil = new CommonUtil();
    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();

    Scanner scan = commonUtil.getScan();
    int wrong_value = -1;

    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchedList = articleRepository.findBykeyword(keyword);
        articleView.printList(searchedList);
    }

    public void detail() {
        System.out.print("상세보기 할 번호를 입력해주세요 : ");
        int inputId = ParmByInt(scan.nextLine(), wrong_value);
        if (inputId == wrong_value) {
            return;
        }
        Article article = articleRepository.findByIndx(inputId);

        if (article == null) {
            System.out.println("없는 게시물입니다.");
            return;
        }
        article.increaseHit();
        articleView.printDetail(article);

    }

    public void delete() {
        System.out.print("삭제할 게시물 번호를 입력해주세요 : ");
        int inputId = ParmByInt(scan.nextLine(), wrong_value);
        if (inputId == wrong_value) {
            return;
        }
        Article article = articleRepository.findByIndx(inputId);

        if (article == null) {
            System.out.println("없는 게시물입니다.");
            return;
        }
        articleRepository.deleteArticle(article);
        System.out.println(inputId + "번 게시물이 삭제되었습니다.");
    }

    public void update() {
        System.out.print("수정할 게시물의 번호를 입력해주세요 : ");
        int inputId = ParmByInt(scan.nextLine(), wrong_value);
        if (inputId == wrong_value) {
            return;
        }
        Article article = articleRepository.findByIndx(inputId);

        if (article == null) {
            System.out.println("없는 게시물입니다.");
            return;
        }
        System.out.print("수정할 제목을 입력해주세요 : ");
        String NewTitle = scan.nextLine();
        System.out.print("수정할 내용을 입력해주세요 : ");
        String NewBody = scan.nextLine();
        articleRepository.updateArticle(article, NewTitle, NewBody);
        System.out.println(inputId + "번 게시물이 수정되었습니다.");
    }
    public void list(){
        ArrayList<Article> searched = articleRepository.findAll();
        articleView.printList(searched);
    }

    public void add(){
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();
        articleRepository.saveArticle(title,body);
        System.out.println("새로운 게시물이 성공적으로 등록되었습니다.");
    }


    private int ParmByInt(String param, int defaultValue) {
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return defaultValue;
        }
    }

}
