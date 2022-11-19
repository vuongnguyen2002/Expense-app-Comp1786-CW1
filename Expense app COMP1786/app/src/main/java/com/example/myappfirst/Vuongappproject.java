package com.example.myappfirst;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vuongappproject extends Application {
    private static List<Listperson> personList = new ArrayList<>();
    public static int nextId;

    /*public Vuongappproject() {
        fillpersonlist();
    }*/

   /* private void fillpersonlist() {
        Listperson v0 =new Listperson(0,"Vuong",2022,"","GFDGFDGGDGGGGGGGGG ","TRETRE","RTREG");
        Listperson v1 =new Listperson(1,"",2023,"","","","");
        Listperson v2 =new Listperson(2,"",2222,"","","","");

        personList.addAll(Arrays.asList(v0,v1,v2));


    }*/



    public static List<Listperson> getPersonList() {
        return personList;
    }

    public static void setPersonList(List<Listperson> personList) {
        Vuongappproject.personList = personList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Vuongappproject.nextId = nextId;
    }
}
