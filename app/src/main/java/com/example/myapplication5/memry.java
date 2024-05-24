package com.example.myapplication5;

import static com.example.myapplication5.Pathfinder.getPath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class memry {
    static List<State> bag = new ArrayList<>();
    static Random rand = new Random();
    static AlertDialog.Builder builder;
    static DialogInterface.OnClickListener Dialog;
    static DialogInterface.OnClickListener Dialog_dead;
    static DialogInterface.OnClickListener Dialog_run;
    static DialogInterface.OnClickListener Dialog_invent;
    static DialogInterface.OnClickListener Dialog_invent1;
    static DialogInterface.OnClickListener Dialog_invent2;
    static DialogInterface.OnClickListener Dialog_invent3;
    static DialogInterface.OnClickListener Dialog_invent4;
    static DialogInterface.OnClickListener Dialog_invent5;
    static DialogInterface.OnClickListener Dialog_invent6;
    static State find;
    static Intent intent;
    static RecyclerView recyclerView;
    static RecyclerView hp_View;
    static RecyclerView hp_View_2;
    static RecyclerView recyclerView_hp;
    static RecyclerView recyclerView_invents_2;
    static RecyclerView recyclerView_invents;
    static List<State> invents = new ArrayList<>();
    static List<State> hp_p = new ArrayList<>();
    static List<State> hp_mob = new ArrayList<>();
    static int hp_p_int = 3;
    static boolean re = false;
    static roulette r = new roulette();
    static int rand_g = 0;
    static int click_pos = -1;
    static int x,y,py,px;
    static int x_prise = 6;
    static int y_prise = 10;
    static int h = 20;
    static int columns = 6;
    static int x_Position = 0;
    static int y_Position = 0;
    static List<State> itom = new ArrayList<>();
    static List<State> mob = new ArrayList<>();
    static int[] list= {
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,1,1,1,3,1,1,1,1,1,3,1,1,1,0,0,0,0,0,
            0,0,1,3,3,3,3,1,3,3,3,3,3,3,1,0,0,0,0,0,
            0,0,3,3,3,3,3,1,3,3,3,3,3,3,1,0,0,0,0,0,
            0,0,3,3,3,3,3,1,3,1,1,1,1,1,1,0,0,0,0,0,
            0,0,1,3,3,3,3,3,3,3,3,3,3,3,1,0,0,0,0,0,
            0,0,1,1,1,3,1,1,3,3,3,3,3,3,3,0,0,0,0,0,
            0,0,1,3,3,3,3,1,3,3,3,3,3,3,1,0,0,0,0,0,
            0,0,1,3,3,3,3,1,1,1,3,1,1,1,1,0,0,0,0,0,
            0,0,3,3,3,3,3,3,3,1,3,3,3,3,1,0,0,0,0,0,
            0,0,1,3,3,3,3,3,3,1,3,3,3,3,1,0,0,0,0,0,
            0,0,1,3,3,3,3,3,3,1,3,3,3,3,1,0,0,0,0,0,
            0,0,3,3,3,3,3,3,3,1,3,3,3,3,1,0,0,0,0,0,
            0,0,1,3,3,3,3,3,3,1,3,3,3,3,1,0,0,0,0,0,
            0,0,1,3,3,3,3,3,3,1,3,3,3,3,1,0,0,0,0,0,
            0,0,1,1,1,3,1,1,1,1,1,1,3,1,1,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    static int[][] lists = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,0,0,0,0},
            {0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,1,0,0,0,0,1,1,1,0,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    static int car = R.drawable.car1;
    static int wall1 = R.drawable.greas;
    static int wall2 = R.drawable.floars;
    static RotateAnimation rotate;
    static List<State> mobs_true = new ArrayList<>();
    static List<Integer> mobs_p = new ArrayList<Integer>();
    static int wall1_chec = R.drawable.gr_check;
    static State wall1_chec1 = new State(wall1_chec, 2);
    static State wall_1 = new State(wall1, 2);
    static int wall2_chec = R.drawable.gr_check;
    static State wall2_chec1 = new State(wall2_chec, 2);
    static State wall_2 = new State(wall2, 2);
    static int chec = 0;
    static TextView helloTextView;
    static TextView helloTextView1;
    static List<State> states = new ArrayList<>();
    static int Position_person1 = 0;
    static int Position_person_vertual;
    static Vector path;
    static void move_scrin(int Position_person) {
        Position_person_vertual = Position_person+x_Position+(y_Position*h);
        if(Position_person1 %columns ==1){
            Position_person1 +=(x_Position>0?1:0);
            x_Position -=(x_Position>0?1:0);
        }else if (Position_person1 % columns == columns-2 && Position_person_vertual % h < h-2) {
            x_Position ++;
            Position_person1 --;
        }
        if(Position_person1/columns == 1){
            Position_person1 +=(y_Position>0?columns:0);
            y_Position -= (y_Position>0?1:0);
        }else if (Position_person1 / columns == y_prise -2 && Position_person_vertual / h < h-2) {
            y_Position ++;
            Position_person1 -= columns;
        }
    }
    static void setInitialData() {

        states.clear();
        int e;
        for (int y = y_Position; y < y_prise + y_Position; y++) {
            for (int x = x_Position; x < x_prise + x_Position; x++) {
                e = (y * h) + x;
                if (e == Position_person_vertual) {
                    states.add(new State(R.drawable.plear, e));
                } else if (list[e] == 1) {
                    states.add(new State(R.drawable.wall_wall_w, e));
                } else if (list[e] == 0) {
                    states.add(new State(R.drawable.greas, e));
                }else if (list[e] == 3) {
                    states.add(new State(R.drawable.floars, e));
                }else if (list[e] == 2) {
                    states.add(new State(car, e));
                }
                for (int z = 0; z < mobs_p.size(); z++) {
                    if (e == mobs_p.get(z)) {
//                        path = getPath(x, y, Position_person_vertual%h, Position_person_vertual/h, lists);
//                        Node n =  (Node) path.elementAt(0);
//                        Log.i("ff", String.valueOf(n));
                        Log.i("ff", String.valueOf(mobs_true));
                        Log.i("ff", String.valueOf(mobs_p));
                        states.remove(states.size()-1);
                        states.add(mobs_true.get(z));
                    }
                }
            }
        }
    }
}
