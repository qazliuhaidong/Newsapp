package zhuoxin.eduz.newsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import zhuoxin.eduz.newsapp.Adapter.GuideAdapter;
import zhuoxin.eduz.newsapp.util.ShareUtil;

/**
 * Created by Administrator on 2016/7/27.
 */
public class GuideActivity extends Activity {

    private ViewPager guide_vp;
    private ShareUtil util;
    private GuideAdapter adapter;
    private TextView guide_tv;
    private int time;
    private ArrayList<ImageView> img = new ArrayList<>();
    private int ImgID[] = {R.drawable.lead_1, R.drawable.lead_2, R.drawable.lead_3};
    private ImageView[] points = new ImageView[3];
    private int[] pointID = {R.id.guide_iv1, R.id.guide_iv2, R.id.guide_iv3};
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            guide_tv.setText(time + "秒后跳转");
            time--;
            if (time >= 0) {
                handler.sendEmptyMessageDelayed(0, 1000);
            } else {
                util.putFirstRun();
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        util=ShareUtil.getInstance(getBaseContext());
        if(util.getFirstRun()){
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_guide);
        initData();

    }

    private void initData() {
        guide_tv = (TextView) findViewById(R.id.guide_tv);
        guide_vp = (ViewPager) findViewById(R.id.guide_vp);
        for (int i = 0; i < 3; i++) {
            points[i] = (ImageView) findViewById(pointID[i]);
        }
        for (int i = 0; i < 3; i++) {
            ImageView iv = new ImageView(getBaseContext());
            iv.setImageResource(ImgID[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            img.add(iv);
        }
        adapter=new GuideAdapter(img);

        guide_vp.setAdapter(adapter);
        setImgAlpha(0);
        guide_vp.setOnPageChangeListener(pageChangeListener);

    }
    private void setImgAlpha(int pos){
        for (int i = 0; i <3; i++) {
            if(i==pos){
                points[i].setAlpha(1f);
            }else{
                points[i].setAlpha(0.2f);
            }
        }
    }
    private ViewPager.OnPageChangeListener pageChangeListener=new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0) {
            setImgAlpha(arg0);
            if(arg0==2){
                guide_tv.setVisibility(View.VISIBLE);
                time=3;
                handler.sendEmptyMessage(0);
            }else{
                guide_tv.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub


        }
    };

}