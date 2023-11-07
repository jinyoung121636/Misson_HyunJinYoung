package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner;
    int 명언번호;
    List<Quotation> 명언모음;

    App() {
        scanner = new Scanner(System.in);
        명언번호 = 1;
        명언모음 = new ArrayList<>();
    }

    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                등록실행();
            } else if (cmd.equals("목록")) {
                목록실행();
            } else if (cmd.startsWith("삭제?id=")) {
                삭제실행(cmd);

            }
        }
    }

    void 등록실행() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        System.out.printf("%d번 명언이 등록되었습니다\n", 명언번호);
        Quotation 명언 = new Quotation(명언번호, author, content);
        명언모음.add(명언);
        명언번호++;
    }

    void 목록실행() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = 명언모음.size() - 1; i >= 0; i--) {
            Quotation 명언 = 명언모음.get(i);

            System.out.printf("%d / %s / %s\n", 명언.명언번호, 명언.author, 명언.content);
        }
    }

    void 삭제실행(String cmd) {
        int 삭제번호 = Integer.parseInt(cmd.substring(6));
        if (명언모음.removeIf(명언 -> 명언.명언번호 == 삭제번호)){
            System.out.printf("%d번 명언이 삭제되었습니다.\n", 삭제번호);
        } else {
            System.out.printf("%d번 명언은 존재하지 않습니다\n", 삭제번호);
        }
    }
}
