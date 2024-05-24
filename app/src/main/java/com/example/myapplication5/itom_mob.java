package com.example.myapplication5;

import static com.example.myapplication5.memry.*;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class itom_mob {

    static void itom_gif(){
        itom.clear();
        itom.add(new State(R.drawable.boom, "grenade","itom",  0, 0, false, false, false, 4));
        itom.add(new State(R.drawable.axe, "axe", "itom",1, 0, false, false, false, 1));
        itom.add(new State(R.drawable.knife, "knife", "itom",1, 0, false, false, false, 1));
        itom.add(new State(R.drawable.oil, "fuel", "itom",0, 0, false, false, false, 1));
        itom.add(new State(R.drawable.key, "keys", "itom",0, 0, false, false, false, 1));
        itom.add(new State(R.drawable.apteshka, "first_aid_kit", "itom",0, 0, false, true, false, 6));
        itom.add(new State(R.drawable.buriar, "barrier", "itom",0, 0, true, false, false, 8));
        itom.add(new State(R.drawable.pistole, "pistol", "itom",0, 1, false, false, false, 1));
        itom.add(new State(R.drawable.arbooy, "crossbow", "itom",0, 1, false, false, false, 1));
        itom.add(new State(R.drawable.ak, "ak_47", "itom",0, 1, false, false, false, 1));
        itom.add(new State(R.drawable.shotgan, "shotgun", "itom",0, 1, false, false, false, 1));
        itom.add(new State(R.drawable.basuka, "bazooka", "itom",0, 1, false, false, true, 1));
//        itom.add(new State(R.drawable.bread, "bread", "itom",1, 1, false, true, true, 0));
    }
    static void mob_gif(){
        mob.clear();
        mob.add(new State(R.drawable.zomd, "zomby","z", 2, 2, -1,false, 17,0));
        mob.add(new State(R.drawable.spider, "spider","z", 1, 3, 0,false, 5,0));
        mob.add(new State(R.drawable.wolf, "wolf","z", 3, 1, 1,false, 5,0));
        mob.add(new State(R.drawable.boss_zombi, "boss zomby", "z",4, 4, 0,true, 1,0));
    }
    static void random_bag(){
        bag.clear();
        if(itom.size() > 0) {
            for(int x = 0;x < 4;x++) {
                int rand_int1 = rand.nextInt(itom.size());
                bag.add(itom.get(rand_int1));
                Log.i("fffffffffff", String.valueOf(rand_int1));
                if (itom.get(rand_int1).getcolvo()>1) {
                    Log.i("fffffffffff", String.valueOf(itom.get(rand_int1).getcolvo()));
                    itom.get(rand_int1).find();
                    Log.i("fffffffffff", String.valueOf(itom.get(rand_int1).getcolvo()));
                }else{
                    itom.remove(rand_int1);
                }
            }
        }
        for(int x = 0;x < 3;x++) {
            if(mob.size() > 0) {
                int rand_int2 = rand.nextInt(mob.size());
                bag.add(mob.get(rand_int2));
                mob.get(rand_int2).find();
                if (mob.get(rand_int2).getcolvo() > 0) {
                    mob.get(rand_int2).find();
                } else {
                    mob.remove(rand_int2);
                }
            }else{
                bag.add(new State(R.drawable.zomd, "zomby","z", 2, 2, -1,false, 17,0));
            }
        }
        Collections.shuffle(bag);
    }
}
