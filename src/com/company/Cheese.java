package com.company;

public class Cheese extends Food{

    public void consume() {
        System.out.println(this + " съеден");
    }

    public Cheese(){
        super("Сыр");
    }

    @Override
    public int calculCalories() {
        return 300;
    }

    @Override
    public int Length(){
        return 6;
    }
}
