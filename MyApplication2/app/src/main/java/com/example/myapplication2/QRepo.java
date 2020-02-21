package com.example.myapplication2;
import android.content.res.AssetManager;
import android.support.v4.app.INotificationSideChannel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QRepo {
    private InputStream fileName;
    //AssetManager assetManager=getAssets();
    public Map<Integer,Question> allQuestions=new HashMap<>();

    public QRepo(InputStream f) {
        this.fileName=f;
        this.loadFromFile();
    }
    private void loadFromFile(){
         Scanner scanner = new Scanner(fileName);
            while (scanner.hasNext()){
                String line=scanner.nextLine();
                if (line.length()>5) {
                    String[] parts = line.split(":");
                    Question q = new Question(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]));
                    allQuestions.put(Integer.parseInt(parts[0]), q);
                }
            }


    }

}
