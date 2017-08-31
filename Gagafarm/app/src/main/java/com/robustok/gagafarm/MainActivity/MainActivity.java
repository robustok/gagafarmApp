package com.robustok.gagafarm.MainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.robustok.gagafarm.R;
import com.robustok.gagafarm.register.RegisterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnRegister).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                Intent intent = new Intent(this, RegisterActivity.class);
                this.startActivity(intent);

                break;
            default:
                break;


        }
    }
}
