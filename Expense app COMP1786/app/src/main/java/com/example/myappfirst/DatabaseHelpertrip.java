package com.example.myappfirst;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelpertrip extends SQLiteOpenHelper {

    public static final String PERSON_TABLE = "PERSON_TABLE";
    public static final String COLUMN_PERSON_NAME = "PERSON_NAME";
    public static final String COLUMN_PERSON_DATETIME = "PERSON_DATETIME";
    public static final String COLUMN_IMAGE_URL = "IMAGE_URL";
    public static final String COLUMN_NAMETRIP_LOCATION = "NAMETRIP_LOCATION";
    public static final String COLUMN_DESCRIPTION_TRIP = "DESCRIPTION_TRIP";
    public static final String COLUMN_TEAM_PARTNER = "TEAM_PARTNER";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ACTIVE_TRIP = "ACTIVETRIP";


    public DatabaseHelpertrip(@Nullable Context context) {
        super(context, "Tripexpensemanagement3.db", null, 21);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + PERSON_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PERSON_NAME + " TEXT ," + COLUMN_PERSON_DATETIME + " INT ," + COLUMN_IMAGE_URL + " STRING ," + COLUMN_NAMETRIP_LOCATION + " TEXT ," + COLUMN_DESCRIPTION_TRIP + " TEXT ," + COLUMN_TEAM_PARTNER + " TEXT," + COLUMN_ACTIVE_TRIP + " BOOL)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PERSON_TABLE);
        onCreate(db);

    }

    public boolean buttonadd(Listperson newPerson) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PERSON_NAME, newPerson.getName());
        cv.put(COLUMN_PERSON_DATETIME, newPerson.getDateofupload());
        cv.put(COLUMN_IMAGE_URL, newPerson.getImageurl());
        cv.put(COLUMN_NAMETRIP_LOCATION, newPerson.getNametriplocation());
        cv.put(COLUMN_DESCRIPTION_TRIP, newPerson.getDescriptiontrip());
        cv.put(COLUMN_TEAM_PARTNER, newPerson.getTeamatefriend());
        cv.put(COLUMN_ACTIVE_TRIP, newPerson.isSwitchActive());

        long insert = db.insert(PERSON_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }


    }

    public boolean buttonupdate(Listperson newupdatePerson) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, newupdatePerson.getId());

        cv.put(COLUMN_PERSON_NAME, newupdatePerson.getName());
        cv.put(COLUMN_PERSON_DATETIME, newupdatePerson.getDateofupload());
        cv.put(COLUMN_IMAGE_URL, newupdatePerson.getImageurl());
        cv.put(COLUMN_NAMETRIP_LOCATION, newupdatePerson.getNametriplocation());
        cv.put(COLUMN_DESCRIPTION_TRIP, newupdatePerson.getDescriptiontrip());
        cv.put(COLUMN_TEAM_PARTNER, newupdatePerson.getTeamatefriend());
        cv.put(COLUMN_ACTIVE_TRIP, newupdatePerson.isSwitchActive());
        Cursor cursor = db.rawQuery("SELECT * FROM PERSON_TABLE WHERE PERSON_NAME=?", new String[]{COLUMN_PERSON_NAME});
        if (cursor.getCount() > 0) {
            long result = db.update(PERSON_TABLE, cv, "PERSON_NAME = ?", new String[]{COLUMN_PERSON_NAME});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM " + PERSON_TABLE;
        db.execSQL(clearDBQuery);
    }

    public boolean buttondelete(Listperson newPerson) {
        SQLiteDatabase db = this.getWritableDatabase();
        String querystring = " DELETE FROM " + PERSON_TABLE + " WHERE " + COLUMN_ID + " = " + newPerson.getId();
        Cursor cursor = db.rawQuery(querystring, null);
        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }


    }

    public List<Listperson> geteveryone() {
        List<Listperson> returnlist = new ArrayList<>();
        String querystring = "SELECT * FROM " + PERSON_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(querystring,null);
        if (cursor.moveToFirst()) {
            do {
                int personID = cursor.getInt(0);
                String personname = cursor.getString(1);
                int Datetrip = cursor.getInt(2);
                String imagetrip =cursor.getString(3);
                String nametrip = cursor.getString(4);
                String namedescription = cursor.getString(5);
                String nameteamate = cursor.getString(6);
                boolean Active = cursor.getInt(6) == 1 ? true : false;
                Listperson newTripperson = new Listperson(personID,personname,Datetrip,imagetrip,nametrip,namedescription,nameteamate,Active);
                returnlist.add(newTripperson);
            } while (cursor.moveToNext());

        } else {

        }
        cursor.close();
        db.close();
        return returnlist;
    }






    /*public Integer delete(Integer id) {
        SQLiteDatabase db= this.getReadableDatabase();
        return db.delete("PERSON_TABLE", "ID", new String[]{id.toString()});

    }*/
}

