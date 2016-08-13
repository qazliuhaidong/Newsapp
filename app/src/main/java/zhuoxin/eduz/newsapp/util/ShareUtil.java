package zhuoxin.eduz.newsapp.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/8/2.
 */
public class ShareUtil {

    private SharedPreferences sp;
    private final String FILE_NAME="title";
    private static  ShareUtil shareUtil;
    private ShareUtil(Context context){
     sp=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
    }
    public static  ShareUtil getInstance(Context context){
        if(shareUtil==null){
            shareUtil=new ShareUtil(context);
        }
        return shareUtil;
    }

    public void setSPData(String titles){
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("titles",titles);
        editor.commit();
    }
   public String getSPData(){
    return sp.getString("titles","");
    };

    public void putFirstRun(){
        sp.edit().putBoolean("First",true).commit();
    }
    public boolean getFirstRun(){
        return sp.getBoolean("First",false);
    }


}
