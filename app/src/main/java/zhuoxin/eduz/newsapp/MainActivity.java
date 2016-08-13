package zhuoxin.eduz.newsapp;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import zhuoxin.eduz.newsapp.Fragment.One;
import zhuoxin.eduz.newsapp.Fragment.Three;
import zhuoxin.eduz.newsapp.Fragment.Two;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout relative_main;
    TextView tv1,tv2,tv3;
     FragmentManager fm;
    FragmentTransaction ft;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Handler mHandler;



    One one;
    Two two;
    Three three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm=getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar_main);
        tv1= (TextView) findViewById(R.id.rl1_main);
        tv2= (TextView) findViewById(R.id.rl2_main);
        tv3= (TextView) findViewById(R.id.rl3_main);
        drawerLayout= (DrawerLayout) findViewById(R.id.drarlayout_main);
        navigationView= (NavigationView) findViewById(R.id.nv_main);
        one=new One();
        two=new Two();
        three=new Three();
        relative_main= (RelativeLayout) findViewById(R.id.relative_main);
        ft=fm.beginTransaction();
        ft.replace(R.id.relative_main,one);
        ft.commit();
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        mHandler = new MyHandler(this);
        mHandler.sendEmptyMessageDelayed(100, 500);



//        SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日      ");
//        Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
//        String    str    =    formatter.format(curDate);
//        toolbar.setTitle(str);//设置主标题
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name,R.string.app_name);
        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);



    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    private static class MyHandler extends Handler {
        private WeakReference mActivity;

        public MyHandler(MainActivity activity) {
            mActivity = new WeakReference(activity);
        }
        @Override
        public void handleMessage(Message msg) {
//            MainActivity activity = mActivity.get();
            MainActivity activity= (MainActivity) mActivity.get();
            switch (msg.what) {
                case 100:
                    activity.updateCurrentTime();
                    sendEmptyMessageDelayed(100, 500);
                    break;


                default:
                    break;
            }
        }
    }

    private void updateCurrentTime() {
/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
Date curDate = new Date(System.currentTimeMillis());
String time = simpleDateFormat.format(curDate);
tv_time.setText(time);*/

        Date now = new Date();
        DateFormat format = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
                DateFormat.MEDIUM, Locale.CHINA);
        String time = format.format(now);
        toolbar.setTitle(time);
    }

    @Override
    public void onClick(View v) {
        ft=fm.beginTransaction();
//        ft.add(R.id.relative_main,one).add(R.id.relative_main,two).add(R.id.relative_main,three);
       switch (v.getId()){
           case R.id.rl1_main:
//               ft.hide(three).hide(two);
//               ft.show(one);
               ft.replace(R.id.relative_main,one);
               break;
           case R.id.rl2_main:
               ft.replace(R.id.relative_main,two);
//               ft.hide(one).hide(three);
//               ft.hide(two);
               break;
           case R.id.rl3_main:
               ft.replace(R.id.relative_main,three);
//               ft.hide(one).hide(two);
//               ft.hide(three);
               break;
       }
        ft.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

if(resultCode==220){
    one.downData();
}

        if(resultCode==210){
          one.updataTitle();
                Log.d("debug","122354768435rrgfhhjk8");
    }
    }
}
