package com.example.myapplication2;

public class Question {
    private String text;
    private String answer;
    private int points;
    private int id;
    //private boolean wasAnswered;

    public Question(int id,String text, String answer, int p) {
        this.id=id;
        this.text = text;
        this.answer = answer;
        this.points=p;
        //this.wasAnswered=false;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }


}
