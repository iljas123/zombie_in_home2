package com.example.myapplication5;

import static com.example.myapplication5.memry.*;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(MainActivity.this);
        intent = new Intent(this, MainActivity2.class);
        helloTextView = (TextView) findViewById(R.id.textView);
        // начальная инициализация списка
        move_scrin(0);
        setInitialData();
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(layoutManager);
        GridLayoutManager glm = new GridLayoutManager(this, columns);
        recyclerView.setLayoutManager(glm);
        recyclerView.setHasFixedSize(true);
        // устанавливаем для списка адаптер (создаем адаптер)
        recyclerView.setAdapter(new StateAdapter(this));
        for(int x = 0;x < columns;x++){
            invents.add(new State(R.drawable.invent,1));
        }
        for(int x = 0;x < hp_p_int;x++){
            hp_p.add(new State(R.drawable.hp,1));
        }
        GridLayoutManager glm1 = new GridLayoutManager(this, columns);
        recyclerView_invents = (RecyclerView) findViewById(R.id.list_itom);
        recyclerView_invents.setLayoutManager(layoutManager);
        recyclerView_invents.setLayoutManager(glm1);
        recyclerView_invents.setHasFixedSize(true);
        recyclerView_invents.setAdapter(new invent(this));
        helloTextView.setTextColor(Color.RED);
        hp_View = (RecyclerView) findViewById(R.id.list_hp);
        hp_View.setLayoutManager(layoutManager);
        GridLayoutManager glm2 = new GridLayoutManager(this, hp_p_int);
        hp_View.setLayoutManager(glm2);
        hp_View.setHasFixedSize(true);
        // устанавливаем для списка адаптер (создаем адаптер)
        hp_View.setAdapter(new hp(this));
        itom_mob.itom_gif();
        itom_mob.mob_gif();
        itom_mob.random_bag();
        Dialog = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Переход
                startActivity(intent);
            }
        };
        Dialog_dead = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Переход
                finish();
            }
        };
        Dialog_run = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        };
        Dialog_invent = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
                invents.remove(0);
                invents.add(0,find);
            }
        };
        Dialog_invent1 = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
                invents.remove(1);
                invents.add(0,find);
            }
        };
        Dialog_invent2 = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
                invents.remove(2);
                invents.add(0,find);
            }
        };
        Dialog_invent3 = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
                invents.remove(3);
                invents.add(0,find);
            }
        };
        Dialog_invent4 = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
                invents.remove(4);
                invents.add(0,find);
            }
        };
        Dialog_invent5 = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
                invents.remove(5);
                invents.add(0,find);
            }
        };
        Dialog_invent6 = new DialogInterface.OnClickListener() { // Переход на оценку приложения
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        };
    }
    public void onMyButtonClick(View view) {
        if(rand_g<=0) {
            r.random(view);
            helloTextView.setText("ходов осталось-" + rand_g);
        }
        if (hp_p_int <=0){
            finish();
        }
    }


    public void onMyButtonClick_batlle(View view) {
        startActivity(intent);
    }

}
//            InputStream is1 = getAssets().open("persons.txt");
//            int size1 = is1.available();
//            beffer = new byte[size];
//            is1.read(beffer);
//            is1.close();
//            String[] list = new String(beffer).split("\t");



