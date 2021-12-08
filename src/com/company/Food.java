package com.company;

public abstract class Food implements Consumable, Nutritious, Length_of_obj {
    private String name = null;

    public Food(String name) {
        this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false;
        if (name==null || ((Food)arg0).name==null) return false;
        return name.equals(((Food)arg0).name);
    }

    @Override
    public String toString() {
        return name;
    }

    //@Override
    //public void consume() {
      //  System.out.println(this + " съедено");
    //}

    //@Override
    //public int Length(){
        //return 4;
    //}

    //@Override
   // public int calculCalories() {
    //    int calories = 100;
       // return calories;
    //}
}

