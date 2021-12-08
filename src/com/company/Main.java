package com.company;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Food[] breakfast = new Food[20];
        boolean sort_needed = false;
        boolean calories_needed = false;

        int counter_breakfast = 0;

        for (int itemIndex = 0; itemIndex < args.length; itemIndex++) {
            if (args[itemIndex].equals("-calories")) {
                calories_needed = true;
            } else if(args[itemIndex].equals("-sort")) {
                sort_needed = true;
            } else{
                String[] parts = args[itemIndex].split("/");
                String[] param = new String[parts.length -1];
                for(int i = 0; i< parts.length-1; i++){
                    param[i] = parts[i+1];
                }
                //System.out.println(param.length);

                //обработка исключений
                try {
                    Class myClass = Class.forName("com.company." + parts[0]);
                    //System.out.println("количество параметров " + myClass.getConstructor(myClass.getConstructors()[0].getParameterTypes()).getParameterTypes().length);
                    //System.out.println("количество прарметров  в массиве " + param.length);
                    breakfast[counter_breakfast] = (Food) myClass.getConstructor(myClass.getConstructors()[0].getParameterTypes()).newInstance(param);
                    counter_breakfast++;
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException  ex) {
                    System.out.print(ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Введите существующий класс!");
                } catch(NoSuchMethodException ex){
                    System.out.println("Введите правильные параметры класса!");
                }
            }
        }
        for (int i = 0; i<breakfast.length; i++) {
            if (breakfast[i] == null) break;
            breakfast[i].consume();
        }
        int count = 0;
        Food[] breakfast_diff = new Food[counter_breakfast];
        for (int i = 0; i < counter_breakfast; i++) {
            count = 1;
            boolean to_continue = false;
            for (int j = 0; j< counter_breakfast; j++){
                if(breakfast_diff[j] == null) continue;
                if(breakfast_diff[j].equals(breakfast[i])){
                    to_continue=true;
                }
            }
            if(to_continue) continue;
            for (int j = i+1; j<counter_breakfast; j++) {
                if ((breakfast[j].equals(breakfast[i]))) {
                    count++;
                }
            }
            breakfast_diff[i] = breakfast[i];
            breakfast[i].consume();
            System.out.println(count + " раз(а)");
        }
        if (calories_needed){
            int calorii = 0;
            for (int i =0; i < counter_breakfast;i++) calorii += breakfast[i].calculCalories();
            System.out.println("калорийность: " + calorii);
        }
        if(sort_needed){
            Arrays.sort(breakfast, new Comparator(){
                public int compare(Object f1, Object f2){
                    if(f1==null) return -1;
                    if(f2==null) return 1;
                    if(((Food)f1).Length()>((Food)f2).Length()) return 1;
                    if(((Food)f1).Length()<((Food)f2).Length()) return -1;
                    return 0;
                }
            });
        }
        System.out.println("\nОтсортированные продукты:\n");
        for (int i = 0; i < breakfast.length; i++) {
            if (breakfast[i] == null) continue;
            System.out.println(breakfast[i].toString() + " " + breakfast[i].calculCalories());
            //breakfast[i].consume();
        }
        System.out.print("\nСъедено продуктов: " + counter_breakfast);
        System.out.print("\n\nВсего хорошего!");
    }
}
