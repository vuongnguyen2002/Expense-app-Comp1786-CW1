package com.example.myappfirst;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database_expense extends SQLiteOpenHelper {


    public static final String EXPENSE_TABLE = "EXPENSE_TABLE";
    public static final String EXPENSE_ID = "ID";
    public static final String EXPENSE_TEXTCATEGORY = "Textcategory";
    public static final String EXPENSE_MONEYCASH = "Moneycash";
    public static final String EXPENSE_COMMENT_TEXT = "CommentText";

    public Database_expense(@Nullable Context context) {
        super(context, "expenseMoney.db", null,21);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + EXPENSE_TABLE + "(" + EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT  ," + EXPENSE_TEXTCATEGORY + " TEXT ," + EXPENSE_MONEYCASH + " INT ," + EXPENSE_COMMENT_TEXT + " TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EXPENSE_TABLE);
        onCreate(db);

    }
    public boolean buttonadd1(Expense list ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


            cv.put(EXPENSE_TEXTCATEGORY, list.getNamespense());
            cv.put(EXPENSE_MONEYCASH, list.getExpenseAmount());
            cv.put(EXPENSE_COMMENT_TEXT, list.getMessagetext());


            long insert2 = db.insert(EXPENSE_TABLE, null, cv);
            if (insert2 == -1) {
                return false;
            } else {
                return true;
            }

        }
    }
