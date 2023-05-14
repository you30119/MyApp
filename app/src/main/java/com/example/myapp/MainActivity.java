package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView login_image;
    EditText user_id, user_pw;
    Button login_button;
    String m_id = "user", m_pw = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         // R == res

        // xml과 변수를 연결
        login_image = findViewById(R.id.login_image);
        user_id = findViewById(R.id.user_id);
        user_pw = findViewById(R.id.user_pw);
        login_button = findViewById(R.id.login_button);

        // 버튼은 setOnClick -> new View.
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인 버튼이 눌리면 동작할 코드
                String id = user_id.getText().toString();
                String pw = user_pw.getText().toString();
                if(id.equals(m_id) && pw.equals(m_pw)){
                    Toast.makeText(getApplicationContext(),"로그인 성공!", Toast.LENGTH_LONG).show();
                    // 화면을 product페이지로 이동시킨다
                    Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                    intent.putExtra("main_id", id);     // main_id 라는 공간명으로 id를 다음 화면으로 넘김
                    startActivity(intent);
                    // 기존화면은 종료
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"아이디 또는 비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }           // onCreate
}