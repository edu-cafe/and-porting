package com.soo.cp1;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;

public class EWProvider extends ContentProvider {
    static final Uri CONTENT_URI = Uri.parse("content://com.soo.ew/word");
    static final int ALLWORD = 1;
    static final int ONEWORD = 2;

    static final UriMatcher Matcher;
    static {
        Matcher = new UriMatcher(UriMatcher.NO_MATCH);
        Matcher.addURI("com.soo.ew", "word", ALLWORD);
        Matcher.addURI("com.soo.ew", "word/*", ONEWORD);
    }

    SQLiteDatabase mDB;

    public EWProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;

        switch (Matcher.match(uri)) {
            case ALLWORD :
                count = mDB.delete("dic", selection, selectionArgs);
                break;
            case ONEWORD:
                String where;
                where = "eng = '" + uri.getPathSegments().get(1) + "'";
                if (TextUtils.isEmpty(selection) == false) {
                    where += " AND" + selection;
                }
                count = mDB.delete("dic", where, selectionArgs);
                break;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        if (Matcher.match(uri) == ALLWORD) {
            return "vnd.EnglishWord.soo.cursor.item/word";
        }
        if (Matcher.match(uri) == ONEWORD) {
            return "vnd.EnglishWord.soo.cursor.dir/word";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long row = mDB.insert("dic", null, values);
        if (row > 0) {
            Uri notiuri = ContentUris.withAppendedId(CONTENT_URI, row);
            getContext().getContentResolver().notifyChange(notiuri, null);
            return notiuri;
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        WordDBHelper helper = new WordDBHelper(getContext());
        mDB = helper.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String sql;

        // 전체에 대한 쿼리 명령
        sql = "SELECT eng, han FROM dic";

        // 단어 선택 where절 추가
        if (Matcher.match(uri) == ONEWORD) {
            sql += " where eng = '" + uri.getPathSegments().get(1) + "'";
        }

        Cursor cursor = mDB.rawQuery(sql, null);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;

        switch (Matcher.match(uri)) {
            case ALLWORD:
                count = mDB.update("dic", values, selection, selectionArgs);
                break;
            case ONEWORD:
                String where;
                where = "eng = '" + uri.getPathSegments().get(1) + "'";
                if (TextUtils.isEmpty(selection) == false) {
                    where += " AND " + selection;
                }
                count = mDB.update("dic", values, where, selectionArgs);
                break;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}

class WordDBHelper extends SQLiteOpenHelper {
    public WordDBHelper(Context context) {
        super(context, "EngWord.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE dic ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "eng TEXT, han TEXT);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS dic");
        onCreate(db);
    }
}
