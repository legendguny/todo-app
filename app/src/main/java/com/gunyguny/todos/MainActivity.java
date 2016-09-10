package com.gunyguny.todos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextId, editTextPw;
    Button buttonLogin, buttonJoin;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextPw = (EditText) findViewById(R.id.editTextPw);
        buttonJoin = (Button) findViewById(R.id.buttonJoin);
        buttonLogin = (Button) findViewById(R.id.buttonLogin) ;
        sharedPreferences = this.getSharedPreferences("com.gunyguny.todos", Context.MODE_PRIVATE);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String savedId = sharedPreferences.getString("id","");
//                String savedPw = sharedPreferences.getString("pw","");
            String id = editTextId.getText().toString();
            String pw = editTextPw.getText().toString();

            String savedPw = sharedPreferences.getString(id,"");

                if (savedPw.equals("")){
                    Toast.makeText(MainActivity.this, "회원가입을 해주세요", Toast.LENGTH_SHORT).show();
                }else if ( !savedPw.equals(pw)){
                    Toast.makeText(MainActivity.this, "비밀번호가 다릅니다", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                   // 로그인 성공
                    //TODO: 투두리스트 화면으로 넘어간다.
                    Intent toTodoListIntent = new Intent(MainActivity.this,TodoListActivity.class);
                    toTodoListIntent.putExtra("id",id);
                    startActivity(toTodoListIntent);
                }

            }
        });

        buttonJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }
}
