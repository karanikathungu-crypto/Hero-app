package models;

import java.net.HttpRetryException;
import java.util.List;
import java.util.ArrayList;

public class Squad {
//    private int size;
//    private String name;
    private String squadSize;
    private String squadName;
    private String cause;
    private Hero newMember;
    private ArrayList<Hero>  squadMembers = new ArrayList<>();
    private static ArrayList<Squad>mInstances = new ArrayList<>();


    public Squad( String name, String size,  String cause, ArrayList<Hero> members){
        squadName = name;
        squadSize = size;
        this.cause = cause;
        squadMembers = members;
//        this.size = size;
//        this.name = name;
//        this.cause = cause;
        mInstances.add(this);
    }
//    public int getSize(){
//        return size;
//    }
//    public String getName(){
//        return name;
//    }

//    public String getCause(){
//        return cause;
//    }
//    public static ArrayList<Squad> getAll(){
//        return mInstances;
//    }
public String getSquadName() {
        return squadName;
    }
    public String getSize() {
        return squadSize;
    }
    public String getCause() {
        return this.cause;
    }
    public static ArrayList<Squad> getInstances() {
        return mInstances;
    }
    public ArrayList<Hero> getSquadMembers(){
        return squadMembers;
    }
    public ArrayList<Hero> setSquadMembers(ArrayList<Hero> newMember) {
        return squadMembers = newMember;
    }

}
