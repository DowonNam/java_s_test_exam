package org.example.base;

import org.example.domain.ArticleController;
import org.example.domain.ArticleRepository;

import java.util.Scanner;

public class BoardApp {
    ArticleController ArticleController = new ArticleController();
    Scanner scan = new Scanner(System.in);

    public void run() {

        while (true) {
            System.out.print("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (cmd) {
                case "add" -> ArticleController.add();
                case "update" -> ArticleController.update();
                case "list" -> ArticleController.list();
                case "delete" -> ArticleController.delete();
                case "detail" -> ArticleController.detail();
                case "search" -> ArticleController.search();
                default -> System.out.println("잘못된 명령어입니다.");
            }

        }
    }


}
