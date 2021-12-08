package com.company;

public class Apple extends Food {

    private String size;

    @Override
    public void consume() {
        System.out.println(this + " съедено");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Apple(String size){
        super("Apple");
        this.size= size;
    }

    @Override
    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)) return false;
        if(!(obj instanceof Apple)) return false;
        return size.equals(((Apple)obj).size);
    }

    @Override
    public int calculCalories() {
        int calories = 0;
        if(size.equals("большое")) {
            calories+= 50;
        } else if(size.equals("маленькое")){
            calories+=5;
        }
        return calories;
    }

    @Override
    public int Length(){
        return 5 + size.length();
    }
}