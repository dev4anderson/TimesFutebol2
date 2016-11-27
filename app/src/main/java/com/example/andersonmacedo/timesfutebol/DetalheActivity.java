package com.example.andersonmacedo.timesfutebol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.andersonmacedo.timesfutebol.model.Time;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        if (getIntent() != null){
            Time time = getIntent().getParcelableExtra("Time");
            Toast.makeText(this, time.getNome(),Toast.LENGTH_SHORT).show();
        }

    }
}
