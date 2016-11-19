package com.example.eunbee.help_dormitory;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Eun bee on 2016-11-02.
 */

public class DialogActivity extends AppCompatActivity implements View.OnClickListener{
    TextView text;
    String str="";
    int year, month, day;
    ImageView add_btn;
    public void onCreate(Bundle savedInstanceState){
        add_btn = (ImageView)findViewById(R.id.add);
        add_btn.setOnClickListener(this);
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ok:
                LayoutInflater inflater=getLayoutInflater();
                final View dialogView= inflater.inflate(R.layout.activity_dialog, null);
                AlertDialog.Builder buider= new AlertDialog.Builder(this);
                buider.setTitle("할일 추가");
//buider.setIcon(android.R.drawable.ic_menu_add); //제목옆의 아이콘 이미지(원하는 이미지 설정)
                buider.setView(dialogView);
                buider.setPositiveButton("Complite", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edit_work= (EditText)dialogView.findViewById(R.id.dialog_work);
                        String work = edit_work.getText().toString();
                        Toast.makeText(DialogActivity.this, "새로운 일정을 추가했습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                buider.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    //Dialog에 "Cancel"이라는 타이틀의 버튼을 설정
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
//멤버 정보의 입력을 취소하고 Dialog를 종료하는 작업
//취소하였기에 특별한 작업은 없고 '취소'했다는 메세지만 Toast로 출력
                        Toast.makeText(DialogActivity.this, "일정 추가를 취소합니다", Toast.LENGTH_SHORT).show();
                    }
                });
//설정한 값으로 AlertDialog 객체 생성
                AlertDialog dialog=buider.create();
//Dialog의 바깥쪽을 터치했을 때 Dialog를 없앨지 설정
                dialog.setCanceledOnTouchOutside(false);//없어지지 않도록 설정
//Dialog 보이기
                dialog.show();
                break;
        }
    }
}

