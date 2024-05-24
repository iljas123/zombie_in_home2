package com.example.myapplication5;


import static com.example.myapplication5.memry.*;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import java.util.List;
public class roulette {
    void random(View view){
        view.setRotation(0);
        float rand1 = rand.nextFloat() * 10;
        if (rand1 >= 7) {
            rand_g = 1;
            view.setRotation(90);
        } else if (rand1 >= 4) {
            rand_g = 2;
            view.setRotation(180);
        } else if (rand1 >= 1.6) {
            rand_g = 3;
            view.setRotation(270);
        } else {
            rand_g = 4;
        }
        RELATIVE_0(view, 360*4);
        Log.i("r", String.valueOf(rand_g));
//            for(int x  = 0 ; x <mobs_p.size()&& mobs_p.size() >0;x++){
//                Log.i("eror tyt", String.valueOf(mobs_p.get(x)));
//                path = getPath(mobs_p.get(x)%h, mobs_p.get(x)/h, Position_person_vertual%h, Position_person_vertual/h, lists);
//                Node n =  (Node) path.elementAt(0);
//                Log.i("eror tyt", String.valueOf(n.y*h+n.x));
//                int p = mobs_p.get(x)+n.y*h+n.x;
//                Log.i("eror tyt", String.valueOf(p));
//                mobs_p.remove(x);
//                mobs_p.add(x,p);
//            }
    }
    public void RELATIVE_0(View view, int degrees){
        rotate = new RotateAnimation(0, degrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        rotate.setInterpolator(new LinearInterpolator());
        view.startAnimation(rotate);
    }
    void agein(int p){
        Log.i("pp1", String.valueOf(Position_person1));
        Log.i("p", String.valueOf(p));
        y = p/columns;
        x = p%columns;
        py = Position_person1/columns;
        px = Position_person1%columns;
    }
    boolean move_true(){
        return (py-y >=0?py-y:y-py)+(px-x >=0?px-x:x-px) ==1;
    }
    List<State> State_on(int p) {
        State person = states.get(Position_person1);
        int object = states.get(p).getFlagResource();
        int s = states.get(chec).getFlagResource();
        if(wall1 == object){
            if(s == wall1_chec){
                states.remove(chec);
                states.add(chec, wall_1);
            }
            wall1_chec1.reName(p);
            states.remove(p);
            states.add(p, wall1_chec1);
            chec = p;
        }else if(wall2 == object){
            if(s == wall2_chec){
                states.remove(chec);
                states.add(chec, wall_2);
            }
            wall2_chec1.reName(p);
            states.remove(p);
            states.add(p, wall2_chec1);
            chec = p;
            //&& re && rand_g !=0
        }else if(object == wall2_chec){
            states.remove(p);
            states.add(p, person);
            states.remove(Position_person1);
            states.add(Position_person1, wall_2);
            Position_person1 = p;
            rand_g--;
            helloTextView.setText("ходов осталось-"+rand_g);

            you_find();
            move_scrin(((Position_person1 / columns) * h) + (Position_person1 % columns));
            setInitialData();
        }
        hp_View.getAdapter().notifyDataSetChanged();
        recyclerView.getAdapter().notifyDataSetChanged();
        return states;
    }
    void you_find(){
        if(bag.size() == 0){
            itom_mob.random_bag();
        }
        find = bag.get(0);
        bag.remove(0);
        if(find.gettip().equals("itom") && invents.size() <= columns){
            if(invents.get(invents.size()-1).getFlagResource() == R.drawable.invent){
                invents.add(0,find);
                invents.remove(invents.size()-1);
            }else{
                final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};
                builder.setMessage("ваш  инвентарь полон чтобы подобрать "+find.getname()+"выберете что выкинуть")
                        .setPositiveButton(invents.get(0).getname(), Dialog_invent)
                        .setNeutralButton(invents.get(1).getname(), Dialog_invent1)
                        .setNeutralButton(invents.get(2).getname(), Dialog_invent2)
                        .setNeutralButton(invents.get(3).getname(), Dialog_invent3)
                        .setNeutralButton(invents.get(4).getname(), Dialog_invent4)
                        .setNeutralButton(invents.get(5).getname(), Dialog_invent5)
                        .setNeutralButton("выкенуть найденый предмет", Dialog_invent6)
                        .show();
            }
        }else if(find.gettip().equals("z")){
            int f = (((Position_person1 / columns) * h) + (Position_person1 % columns))+x_Position+(y_Position*h);
            mobs_p.add(f);
            find.reName(f);
            mobs_true.add(mobs_true.size(),find);
            Log.i("ff", String.valueOf(f));
            // Создание и отображение всплывающего окна
            builder.setMessage("вы нашли монстра")
                    .setPositiveButton("OK", Dialog)
                    .show();
        }
        recyclerView_invents.getAdapter().notifyDataSetChanged();
    }
}
