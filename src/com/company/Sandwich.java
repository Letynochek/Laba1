package com.company;

import java.util.Locale;

public class Sandwich extends Food {

    private String filling1;
    private String filling2;

    public void consume() {
        System.out.println(this + " съеден");
    }

    public Sandwich(String filling1, String filling2) {
        super("Сендвич");
        this.filling1 = filling1;
        this.filling2 = filling2;
    }

    @Override
    public boolean equals(Object arg0) {
        if (!super.equals(arg0)) return false;
        if (!(arg0 instanceof Sandwich)) return false;
        return (filling2.equals(((Sandwich) arg0).filling2)) && (filling1.equals(((Sandwich) arg0).filling1));
    }

    public String toString() {
        return super.toString() + " c '" + filling1.toUpperCase() + "'" + " и '" + filling2.toUpperCase() + "'";
    }

    @Override
    public int calculCalories() {
        int calories = 0;
        if (filling1.equals("бекон")) {
            calories += 500;
        } else if (filling1.equals("ветчина")) {
            calories += 300;
        }else if(filling1.equals("колбаска")){
            calories+=200;
        }
        if (filling2.equals("сыр")) {
            calories += 100;
        } else if (filling2.equals("масло")) {
            calories += 150;
        }else if(filling2.equals("кетчуп")){
            calories+=70;
        }
        return calories;
    }

    @Override
    public int Length(){

        return 8 + filling1.length() + filling2.length();
    }
}
