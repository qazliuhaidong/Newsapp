package zhuoxin.eduz.newsapp.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import zhuoxin.eduz.newsapp.entity.News;

/**
 * Created by Administrator on 2016/8/4.
 */
public class NewsDBHelper {
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private static NewsDBHelper sInstance;
    private NewsDBHelper(Context context){
        dbHelper=new DBHelper(context);
        database=dbHelper.getWritableDatabase();
    }
    public static NewsDBHelper getsInstance(Context context){
        if(sInstance==null){
            synchronized(NewsDBHelper.class){
                if(sInstance==null){
                    sInstance=new NewsDBHelper(context);
                }
            }
        }
        return sInstance;
    }
    public void insertNews(News news){
        ContentValues values=new ContentValues();
        values.put("summary", news.getSummary());
        values.put("icon", news.getIcon());
        values.put("stamp", news.getStamp());
        values.put("title", news.getTitle());
        values.put("nid", news.getNid());
        values.put("link", news.getLink());
        values.put("type", news.getType());
        database.insert(dbHelper.TABLE_NAME,null, values);
    }
    public ArrayList<News> getNewsList(){
        ArrayList<News>list=new ArrayList<News>();
        Cursor cursor=database.query(dbHelper.TABLE_NAME, null, null, null, null, null, null);
        while(cursor.moveToNext()){
            String summary=cursor.getString(cursor.getColumnIndex("summary"));
            String icon=cursor.getString(cursor.getColumnIndex("icon"));
            String stamp=cursor.getString(cursor.getColumnIndex("stamp"));
            String title=cursor.getString(cursor.getColumnIndex("title"));
            String link=cursor.getString(cursor.getColumnIndex("link"));
            int nid=cursor.getInt(cursor.getColumnIndex("nid"));
            int type=cursor.getInt(cursor.getColumnIndex("type"));
            list.add(new News(summary, icon, stamp, title, nid, link, type));
        }
        return list;
    }


}
