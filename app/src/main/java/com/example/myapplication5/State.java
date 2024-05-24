package com.example.myapplication5;

public class State {
    private String name;
    private int flagResource; // ресурс флага
    private int namber;
    private int atc_cold;
    private int atc_hot;
    private boolean border;
    private boolean hp;
    private boolean boss_atc;
    private int colvo;
    private int atc;
    private int def;
    private boolean boss;
    private int speed;
    private String tip;

    public State(int flag,int namber) {

        this.flagResource = flag;
        this.namber = namber;
    }
    public State(int flag,String name,String tip,int atc_cold,int atc_hot,boolean border,boolean hp,boolean boss_atc,int colvo) {
        this.flagResource = flag;
        this.name = name;
        this.tip = tip;
        this.atc_cold = atc_cold;
        this.atc_hot = atc_hot;
        this.border = border;
        this.hp = hp;
        this.boss_atc = boss_atc;
        this.colvo = colvo;
    }
    public State(int flag,String name,String tip,int atc, int def,int speed, boolean boss,int colvo,int namber) {
        this.flagResource = flag;
        this.name = name;
        this.tip = tip;
        this.atc = atc;
        this.def = def;
        this.boss = boss;
        this.speed = speed;
        this.colvo = colvo;
        this.namber = namber;
    }
    public void find(){
        this.colvo--;
    }
    public int getcolvo(){
        return this.colvo;
    }
    public int getspeed(){
        return this.speed;
    }
    public int getatc_cold(){
        return this.atc_cold;
    }
    public int getatc_hot() {
        return this.atc_hot;
    }
    public int getdef() {
        return this.def;
    }
    public String getname() {
        return this.name;
    }
    public void def_v() {
        def--;
    }
    public int getatc() {
        return this.atc;
    }
    public boolean getboss(){
        return this.boss;
    }
    public boolean getborder(){
        return this.border;
    }
    public boolean gethp(){
        return this.hp;
    }
    public boolean getboss_atc(){
        return this.boss_atc;
    }
    public String gettip(){
        return this.tip;
    }
    public void reName(int namber){
        this.namber = namber;
    }

    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }

    public int getName() {
        return namber;
    }
}