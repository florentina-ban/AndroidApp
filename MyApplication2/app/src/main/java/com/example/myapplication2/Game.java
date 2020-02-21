package com.example.myapplication2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game extends AppCompatActivity {
    public TextView question;
    private List<Question> allQ=new ArrayList<>();
    private List<Boolean> answered=new ArrayList<>();
    private int nrQ;
    private Question currentQuestion;
    private Integer noPoints=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        QRepo repo= null;
        try {
            repo = new QRepo(getBaseContext().getAssets().open("questions.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int nrQ=repo.allQuestions.size();
        for (int i=1; i<=nrQ; i++) {
            allQ.add(repo.allQuestions.get(i));
            answered.add(false);
        }

        question=findViewById(R.id.quest);
        question.setText(allQ.get(0).getText());
        currentQuestion=allQ.get(0);

        initButtons();
        setSendBtn();
        setDelBtn();
    }
    public void setAnswer(String s){
        TextView ans=findViewById(R.id.answer);
        String text=ans.getText().toString();
        text=text+s;
        ans.setText(text);
    }

    public void setDelBtn() {
        TextView ans = findViewById(R.id.answer);
        Button del = findViewById(R.id.btRemove);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = ans.getText();
                if (text.length() > 0) {
                    text = text.subSequence(0, text.length() - 1);
                    ans.setText(text);
                }
            }
        });
    }
    public void setSendBtn(){
        Button bt=findViewById(R.id.btSend);
        TextView ans=findViewById(R.id.answer);
        TextView po=findViewById(R.id.points);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestion.getAnswer().compareTo(ans.getText().toString())==0) {
                    int c = Color.parseColor("#a1f21d");
                    ans.setBackgroundColor(c);
                    noPoints+=currentQuestion.getPoints();
                    po.setText(noPoints.toString());
                }
                else{
                    int c = Color.parseColor("#ed7f5a");
                    ans.setBackgroundColor(c);
                }
            }
        });

    }
    public void initButtons(){
        List<Button> allBut=new ArrayList<>();
        Button b=findViewById(R.id.bt0);
        allBut.add(b);
        b=findViewById(R.id.bt1);
        allBut.add(b);
        b=findViewById(R.id.bt2);
        allBut.add(b);
        b=findViewById(R.id.bt3);
        allBut.add(b);
        b=findViewById(R.id.bt4);
        allBut.add(b);
        b=findViewById(R.id.bt5);
        allBut.add(b);
        b=findViewById(R.id.bt6);
        allBut.add(b);
        b=findViewById(R.id.bt7);
        allBut.add(b);
        b=findViewById(R.id.bt8);
        allBut.add(b);
        b=findViewById(R.id.bt9);
        allBut.add(b);
        b=findViewById(R.id.btPoint);
        allBut.add(b);

         allBut.forEach(x->{
            x.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setAnswer(x.getText().toString());
            }
            });
         });
        TextView po=findViewById(R.id.points);
        po.setText("0");
    }

}
