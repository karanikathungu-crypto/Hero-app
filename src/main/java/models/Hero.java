package models;
import javax.swing.text.html.HTMLWriter;
import java.lang.reflect.Array;
import java.util.Objects;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age; //changed to string
    private String power;
    private String weakness;
    private String id;
    private static ArrayList<Hero> mInstances = new ArrayList<>();


    public Hero(String name, int age, String power, String weakness){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        mInstances.add(this);
//        this.id = mInstances.size();//issue due to conversion
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Hero)) return false;
//        Hero hero = (Hero) o;
//        return getAllInstances() == hero.getAllInstances() &&
//                getId() == hero.getId() &&
//                Objects.equals(getAllInstances(), hero.getAllInstances());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getName(), getAge(), getId(),getPower(), getWeakness(), getId());
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setPower(String power) {
//        this.power = power;
//    }
//
//    public void setWeakness(String weakness) {
//        this.weakness = weakness;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getPower(){
        return this.power;
    }
    public String getWeakness(){
        return this.weakness;
    }
    public static ArrayList<Hero> getAllInstances()
    {
        return mInstances;
    }
    public String getId(){

        return id;
    }
//    public static Hero findById(String id) {
//
//        return mInstances.get();
//    }
    public static void clearAllHeroes(){
        mInstances.clear();
    }

}

