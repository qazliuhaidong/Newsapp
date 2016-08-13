package zhuoxin.eduz.newsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import zhuoxin.eduz.newsapp.util.ShareUtil;

/**
 * Created by Administrator on 2016/7/29.
 */
public class AddActivity extends Activity{
    private Button btn_add_disport,btn_add_focus,btn_add_sichuan,btn_add_war,btn_add_internet,btn_add_android;
    private TextView tv_add_android,tv_add_disport,tv_add_focus,tv_add_internet,tv_add_sichuan,tv_add_war;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btn_add_disport= (Button) findViewById(R.id.btn_add_disport);
        btn_add_focus= (Button) findViewById(R.id.btn_add_focus);
        btn_add_sichuan= (Button) findViewById(R.id.btn_add_sichuan);
        btn_add_war= (Button) findViewById(R.id.btn_add_war);
        btn_add_internet= (Button) findViewById(R.id.btn_add_internet);
        btn_add_android= (Button) findViewById(R.id.btn_add_android);

        tv_add_disport= (TextView) findViewById(R.id.tv_add_disport);
        tv_add_focus= (TextView) findViewById(R.id.tv_add_focus);
        tv_add_internet= (TextView) findViewById(R.id.tv_add_internet);
        tv_add_sichuan= (TextView) findViewById(R.id.tv_add_sichuan);
        tv_add_war= (TextView) findViewById(R.id.tv_add_war);
        tv_add_android= (TextView) findViewById(R.id.tv_add_android);
//        onClick(View v);
    }

    public void onClick(View v){
        switch (v.getId()){
           case  R.id.btn_add_android:
               btn_add_android.setVisibility(View.GONE);
               String t1="安卓";
               ShareUtil.getInstance(AddActivity.this).setSPData(t1);
               setResult(220,getIntent());
               finish();
              break;
            case R.id.btn_add_disport:
                String t2="娱乐";
                ShareUtil.getInstance(AddActivity.this).setSPData(t2);
                setResult(220,getIntent());
                finish();
                btn_add_disport.setVisibility(View.GONE);
                break;
            case R.id.btn_add_focus:
                btn_add_focus.setVisibility(View.GONE);
                String t3="热点";
                ShareUtil.getInstance(AddActivity.this).setSPData(t3);
                setResult(220,getIntent());
                finish();
                break;
            case R.id.btn_add_sichuan:
                btn_add_sichuan.setVisibility(View.GONE);
                String t4="四川";
                ShareUtil.getInstance(AddActivity.this).setSPData(t4);
                setResult(220,getIntent());
                finish();
                break;
            case R.id.btn_add_internet:
                btn_add_internet.setVisibility(View.GONE);
                String t5="互联网";
                ShareUtil.getInstance(AddActivity.this).setSPData(t5);
                setResult(220,getIntent());
                finish();
                break;
            case R.id.btn_add_war:
                btn_add_war.setVisibility(View.GONE);
                String t6="军事";
                ShareUtil.getInstance(AddActivity.this).setSPData(t6);
                setResult(220,getIntent());
                finish();
                break;
            case R.id.tv_add_android:
                btn_add_android.setVisibility(View.VISIBLE);
                String title1="安卓";
//               Intent intent=new Intent();
//               intent.putExtra("title",title);
                ShareUtil.getInstance(AddActivity.this).setSPData(title1);
                setResult(210,getIntent());
                 finish();
                break;
            case R.id.tv_add_disport:
                btn_add_disport.setVisibility(View.VISIBLE);
                String title2="娱乐";
                ShareUtil.getInstance(AddActivity.this).setSPData(title2);
                setResult(210,getIntent());
                finish();
                break;
            case R.id.tv_add_focus:
                btn_add_focus.setVisibility(View.VISIBLE);
                String title3="热点";
                ShareUtil.getInstance(AddActivity.this).setSPData(title3);
                setResult(210,getIntent());
                finish();
                break;
            case R.id.tv_add_internet:
                btn_add_internet.setVisibility(View.VISIBLE);
                String title4="互联网";
                ShareUtil.getInstance(AddActivity.this).setSPData(title4);
                setResult(210,getIntent());
                finish();
                break;
            case R.id.tv_add_sichuan:
                btn_add_sichuan.setVisibility(View.VISIBLE);
                String title5="四川 ";
                ShareUtil.getInstance(AddActivity.this).setSPData(title5);
                setResult(210,getIntent());
                finish();
                break;
            case R.id.tv_add_war:
                btn_add_war.setVisibility(View.VISIBLE);
                String title6="军事";
                ShareUtil.getInstance(AddActivity.this).setSPData(title6);
                setResult(210,getIntent());
                finish();
                break;
        }

    }

}
