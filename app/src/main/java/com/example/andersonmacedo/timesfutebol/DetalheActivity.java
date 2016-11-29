package com.example.andersonmacedo.timesfutebol;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andersonmacedo.timesfutebol.model.Time;
import com.squareup.picasso.Picasso;


public class DetalheActivity extends AppCompatActivity {

    TextView  tvNomeDet;
    TextView  tvEstadoDet;
    TextView  tvAnoFundacaoDet;
    ImageView ivEscudoDet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        if (getIntent() != null){
            Time time = getIntent().getParcelableExtra("Time");

            tvNomeDet = (TextView) findViewById(R.id.tvNomeDet);
            tvEstadoDet = (TextView) findViewById(R.id.tvEstadoDet);
            tvAnoFundacaoDet = (TextView) findViewById(R.id.tvAnoFundacaoDet);
            ivEscudoDet = (ImageView) findViewById(R.id.ivEscudoDet);

            tvNomeDet.setText(time.getNome().toString());
            tvEstadoDet.setText(time.getEstado().toString());
            tvAnoFundacaoDet.setText(time.getAnoFundacao().toString());

            Picasso.with(this)
                    .load(time.getEscudo().toString())
                    .into(ivEscudoDet);

        }

    }



}
