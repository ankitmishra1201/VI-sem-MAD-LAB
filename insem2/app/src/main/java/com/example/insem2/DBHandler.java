package com.example.insem2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.

    private static final String DB_NAME = "coursedb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mycourses";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String SALARY_COL = "salary";
    private static final String COMISSION_COL = "comission";


    // below variable is for our course tracks column.
    // creating a constructor for our database handler.

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + SALARY_COL + " TEXT,"
                + COMISSION_COL + " TEXT)";

        db.execSQL(query);
    }


    // this method is use to add new course to our sqlite database.

    public void addNewCourse(String courseName, String courseDuration, String courseTracks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, courseName);
        values.put(SALARY_COL, courseDuration);
        values.put(COMISSION_COL, courseTracks);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    // we have created a new method for reading all the courses.

    public ArrayList<EmployeeModak> readCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<EmployeeModak> EmployeeModakArrayList = new ArrayList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                EmployeeModakArrayList.add(new EmployeeModak (cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(0)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return EmployeeModakArrayList;
    }


    // below is the method for updating our courses

    public void updateComission(String Comission) {


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ContentValues values = new ContentValues();
        values.put(COMISSION_COL, Comission);

        if (cursorCourses.moveToFirst()) {
            do {
                db.update(TABLE_NAME, values,null,null);

            } while (cursorCourses.moveToNext());
        }


//        db.update(TABLE_NAME, values, "name=?", new String[]{originalCourseName});
//        db.close();
    }

    public void deleteCourse(String courseName) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "name=?", new String[]{courseName});
        db.close();
    }


    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}