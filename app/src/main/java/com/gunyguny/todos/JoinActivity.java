package com.gunyguny.todos;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {

    EditText editTextJoinId, editTextJoinPw, editTextJoinPw2;
    Button buttonJoinJoin;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        editTextJoinId = (EditText) findViewById(R.id.editTextJoinId);
        editTextJoinPw = (EditText) findViewById(R.id.editTextJoinPw);
        editTextJoinPw2 = (EditText) findViewById(R.id.editTextJoinPw2);
        buttonJoinJoin = (Button)findViewById(R.id.buttonJoinJoin);

        sharedPreferences = this.getSharedPreferences("com.gunyguny.todos", Context.MODE_PRIVATE);

        buttonJoinJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidInput()){

                    SharedPreferences.Editor editor = sharedPreferences.edit();
   //                 editor.putString("id", editTextJoinId.getText().toString());
   //                 editor.putString("pw", editTextJoinPw.getText().toString());


            String id = editTextJoinId.getText().toString();
            String pw = editTextJoinPw.getText().toString();
                    editor.putString(id,pw);
                    editor.commit();
                    showToast("회원가입이 완료됨");
                    finish();
                }
            }
        });

                }
    void showToast(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }
    boolean isValidInput() {
        boolean isIdEdited = editTextJoinId.getText().toString().length() > 0;
        boolean isPwEdited = editTextJoinPw.getText().toString().length() > 0;
        boolean isPw2Edited = editTextJoinPw2.getText().toString().length() > 0;

        if (!isIdEdited || !isPwEdited || !isPw2Edited) {
            showToast("필수 입력 항목을 입력해주세요");
            return false;
        }

        String pw = editTextJoinPw.getText().toString();
        String pw2 = editTextJoinPw2.getText().toString();

        if (!pw.equals(pw2)){
           showToast("비밀번호 2개가 서로 다릅니다");
            return  false;
        }
        return true;
    }
}
