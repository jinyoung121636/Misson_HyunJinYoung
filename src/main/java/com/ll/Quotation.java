package com.ll;

public class Quotation {
    int 명언번호;
    String author;
    String content;

    Quotation(int 명언번호, String author, String content){
        this.명언번호 = 명언번호;
        this.author = author;
        this.content = content;
    }

    public int get명언번호() {
        return 명언번호;
    }
}
