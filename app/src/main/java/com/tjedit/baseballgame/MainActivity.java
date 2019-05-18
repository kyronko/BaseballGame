package com.tjedit.baseballgame;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tjedit.baseballgame.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    ActivityMainBinding act;
    int[] computerExamArray = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setupValues();
    }

    @Override
    public void setupEvents() {
        act.inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkStrikeAndBalls();
            }
        });
    }
    void checkStrikeAndBalls(){
        int[] userinputArray = new int[3];
        int number = Integer.parseInt(act.userInputEdt.getText().toString()) ;
         userinputArray[0] = number/100;
        userinputArray[1] = number / 10 % 10;
        userinputArray[2] = number % 10;
         int strikeCount =0;
         int ballCount =0;
        for(int i=  0; i<3;i++){
            for(int j= 0 ; j<3; j++){
                if(userinputArray[i]==computerExamArray[j]){
                    if(i==j){
                        strikeCount++;
                    }
                    else{
                        ballCount++;
                    }
                }
            }
        }
        if(strikeCount==3){
            Toast.makeText(mContext, "정답입니다! 축하합니다!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(mContext, String.format("%d S , %d B입니다",strikeCount,ballCount), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setupValues() {
        makeExam();

    }

    void makeExam() {
        while (true) {
//        문제를 출제하는 부분
            int randomNumber = (int) Math.random() * 899 + 100;
//        각각의 자리수를 쪼개서 배열에 나눠 담아두기
            int[] tempNumber = new int[3];
            tempNumber[0] = randomNumber / 100; //100자리
            tempNumber[1] = randomNumber / 10 % 10; //10자리
            tempNumber[2] = randomNumber % 10;  //1자리

            boolean isDuplOk = true;
            if (tempNumber[0] == tempNumber[1] || tempNumber[1] == tempNumber[2] || tempNumber[0] == tempNumber[2]) {
//            같은숫자가 있을시 다시출제
                isDuplOk = false;
            }
            boolean isZeroOk = true;
            if (tempNumber[0] == 0 || tempNumber[1] == 1 || tempNumber[2] == 0) {
//        0이 들어있을시 다시 출제
                isZeroOk = false;
            }
            if (isDuplOk && isZeroOk) {
                computerExamArray[0] = tempNumber[0];
                computerExamArray[1] = tempNumber[1];
                computerExamArray[2] = tempNumber[2];

                Log.d("정답숫자",randomNumber+"입니다");
                break;
//                문제 없으면 while문 탈출
            }
        }

    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
