package com.example.chicagoquizapp2022;

public class Question {

    String qText;
    boolean correctAnswer;

    public Question(String qText, boolean correctAnswer) {
        this.qText = qText;
        this.correctAnswer = correctAnswer;
    }

    public String getQText() {
        return qText;
    }

    public void setQText(String qText) {
        this.qText = qText;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qText='" + qText + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
