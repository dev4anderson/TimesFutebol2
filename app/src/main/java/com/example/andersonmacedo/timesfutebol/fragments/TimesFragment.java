package com.example.andersonmacedo.timesfutebol.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.andersonmacedo.timesfutebol.DetalheActivity;
import com.example.andersonmacedo.timesfutebol.R;
import com.example.andersonmacedo.timesfutebol.adapter.TimeListAdapter;
import com.example.andersonmacedo.timesfutebol.api.TimeAPI;
import com.example.andersonmacedo.timesfutebol.listener.TimeOnClickListener;
import com.example.andersonmacedo.timesfutebol.model.Time;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimesFragment extends Fragment implements Callback<List<Time>> {

    private String tipo;
    private RecyclerView rvTime;
    private TimeListAdapter adapter;

    public TimesFragment() {

    }

    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        if (getArguments() != null){
            tipo = getArguments().getString("tipo");
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_times, container, false);

        rvTime = (RecyclerView)v.findViewById(R.id.recyclerView);
        rvTime.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTime.setItemAnimator(new DefaultItemAnimator());
        rvTime.setHasFixedSize(true);

        // Inflate the layout for this fragment
        return v;
    }

    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        loadTimes();
    }

    private void loadTimes(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TimeAPI api = retrofit.create(TimeAPI.class);
        Call<List<Time>> call = api.findBy(tipo);
        call.enqueue(this);
    }


    private TimeOnClickListener onClickListener(){
        return new TimeOnClickListener() {
            @Override
            public void onClick(View v, int position) {

                Intent i = new Intent(getContext(), DetalheActivity.class);
                i.putExtra("Time", adapter.getItem(position));
                startActivity(i);

            }
        };
    }

    @Override
    public void onResponse(Call<List<Time>> call, Response<List<Time>> response) {
        adapter = new TimeListAdapter(response.body(),getContext(),onClickListener());
        rvTime.setAdapter(adapter);
    }


    @Override
    public void onFailure(Call<List<Time>> call, Throwable t) {
        Toast.makeText(getContext(),
                t.getMessage(),
                Toast.LENGTH_SHORT).show();
    }
}
