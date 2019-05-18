package com.tjedit.baseballgame;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
