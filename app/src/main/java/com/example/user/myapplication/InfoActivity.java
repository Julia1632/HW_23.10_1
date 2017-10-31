package com.example.user.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 31.10.2017.
 */

public class InfoActivity extends AppCompatActivity {

    private EditText mEditText;
    private View mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        init();
    }

    public void init(){
        mEditText=findViewById(R.id.input_edittext);
        mButton=findViewById(R.id.btn_startservice);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PendingIntent pi=createPendingResult(Constant.SERVISE_RESULT,new Intent(),0);
                Intent intent=new Intent(InfoActivity.this,InfoIntentService.class);
                intent.putExtra(Constant.FIRST_KEY,mEditText.getText());
                intent.putExtra(Constant.PI_KEY,pi);
                startService(intent);
            }
        });

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (requestCode==Constant.SERVISE_RESULT){
            Toast.makeText(this,""+intent.getIntExtra(Constant.RESULT_KEY,0),Toast.LENGTH_SHORT).show();
        }
        super.startActivityForResult(intent,requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==Constant.SERVISE_RESULT){
            Toast.makeText(this,""+data.getIntExtra(Constant.RESULT_KEY,0),Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}

