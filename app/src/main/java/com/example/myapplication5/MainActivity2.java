package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.myapplication5.memry.*;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        helloTextView1 = (TextView) findViewById(R.id.textView2);
        helloTextView1.setTextColor(Color.RED);
        State i = mobs_true.get(mobs_true.size()-1);
        hp_mob.clear();
        for(int x = 0; x< i.getdef();x++){
            hp_mob.add(new State(R.drawable.hp,1));
        }

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager glm1 = new GridLayoutManager(this, i.getdef());
        recyclerView_hp = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView_hp.setLayoutManager(layoutManager);
        recyclerView_hp.setLayoutManager(glm1);
        recyclerView_hp.setHasFixedSize(true);
        recyclerView_hp.setAdapter(new hpm(this));
        hp_View_2 = (RecyclerView) findViewById(R.id.recyclerView_hp);
        hp_View_2.setLayoutManager(layoutManager);
        GridLayoutManager glm2 = new GridLayoutManager(this, hp_p_int);
        hp_View_2.setLayoutManager(glm2);
        hp_View_2.setHasFixedSize(true);
        // устанавливаем для списка адаптер (создаем адаптер)
        hp_View_2.setAdapter(new hp(this));

        recyclerView_invents_2 = (RecyclerView) findViewById(R.id.recyclerView_invent);
        recyclerView_invents_2.setLayoutManager(layoutManager);
        GridLayoutManager glm3 = new GridLayoutManager(this, invents.size());
        recyclerView_invents_2.setLayoutManager(glm3);
        recyclerView_invents_2.setHasFixedSize(true);
        // устанавливаем для списка адаптер (создаем адаптер)
        recyclerView_invents_2.setAdapter(new invent(this));
    }
    public void onMyButtonClick1(View view) {
        if(mobs_true.get(mobs_true.size()-1).getdef() !=0){
            r.random(view);
            if(rand_g == 1){
                Log.i("you run", String.valueOf(rand_g));
                helloTextView1.setText("you run");
                builder.setMessage("you run")
                        .setPositiveButton("OK", Dialog_run)
                        .show();
                finish();
            }else if(rand_g == 2){
                Log.i("bite", String.valueOf(rand_g));
                hp_p_int--;
                hp_p.remove(0);
                hp_View_2.getAdapter().notifyDataSetChanged();
                hp_View.getAdapter().notifyDataSetChanged();
                helloTextView1.setText("по вам попали");
                if (hp_p_int <=0){
                    rand_g = 0;
                    finish();
                    builder.setMessage("вы убиты")
                            .setPositiveButton("OK", Dialog_dead)
                            .show();
                }
            }else if(rand_g == 3){
                for(int x = 0; x < invents.size();x++){
                    if (invents.get(x).getatc_cold() >0){
                        Log.i("hot_atack", String.valueOf(invents.get(x).getname()));
                        Log.i("cold_atack", String.valueOf(rand_g));
                        mobs_true.get(mobs_true.size()-1).def_v();
                        hp_mob.remove(0);
                        helloTextView1.setText("вы ударили "+ invents.get(x).getname());
                        recyclerView_hp.getAdapter().notifyDataSetChanged();
                        break;
                    }
                }
            }else{
                for(int x = 0; x < invents.size();x++){
                    if (invents.get(x).getatc_hot() >0){
                        Log.i("hot_atack", String.valueOf(invents.get(x).getname()));
                        Log.i("hot_atack", String.valueOf(rand_g));
                        mobs_true.get(mobs_true.size()-1).def_v();
                        hp_mob.remove(0);
                        helloTextView1.setText("вы выстрелили "+ invents.get(x).getname());
                        recyclerView_hp.getAdapter().notifyDataSetChanged();
                        break;
                    }
                }
            }
            if(mobs_true.get(mobs_true.size()-1).getdef() <= 0){
                mobs_true.remove(mobs_true.size()-1);
                mobs_p.remove(mobs_p.size()-1);
                helloTextView1.setText("вы убили его");
                setInitialData();
                recyclerView.getAdapter().notifyDataSetChanged();
                finish();
            }
        }else{
            finish();
        }
    }
}