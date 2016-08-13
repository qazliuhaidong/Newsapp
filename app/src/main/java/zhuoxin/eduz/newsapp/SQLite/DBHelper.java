package zhuoxin.eduz.newsapp.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/8/4.
 */
public class DBHelper extends SQLiteOpenHelper{
    public static final String DB_NAME="news_db";
    public static final String TABLE_NAME="table_news";
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+TABLE_NAME+" (summary varchar(255),icon varchar(255),stamp varchar(255),"
                +"title varchar(255),nid int,link varchar(255),type int)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}
