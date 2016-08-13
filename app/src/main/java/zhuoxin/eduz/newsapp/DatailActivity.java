package zhuoxin.eduz.newsapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import zhuoxin.eduz.newsapp.util.ShareUtil;

/**
 * Created by Administrator on 2016/7/28.
 */
public class DatailActivity extends Activity{
    private WebView wv_detail;
    private ProgressBar pb_detail;
    private FloatingActionButton ftaction;
    private ShareUtil util;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datail);
        wv_detail= (WebView) findViewById(R.id.wv_datail);
        pb_detail= (ProgressBar) findViewById(R.id.pb_datail);
        textView=(TextView)findViewById(R.id.tv_datil);
        util=ShareUtil.getInstance(this);

        final String url=getIntent().getStringExtra("url");
        ftaction= (FloatingActionButton) findViewById(R.id.flacton_datail);
        ftaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                Snackbar.make(wv_detail,"收藏成功",Snackbar.LENGTH_SHORT).show();
                util.setSPData(url);
                textView.setText(util.getSPData());
            }
        });
        wv_detail.setWebViewClient(new MyClient());//设置连接监听
        wv_detail.setWebChromeClient(new MyChrome());//设置进度监听
        WebSettings settings=wv_detail.getSettings();
        settings.setSupportZoom(true);//是否支持缩放
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(true);
        if(url!=null){
            wv_detail.loadUrl(url);
        }



    }
    private class MyClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }
    }
    private class MyChrome extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            // TODO Auto-generated method stub
            super.onProgressChanged(view, newProgress);
            if(newProgress<100){
                pb_detail.setProgress(newProgress);
                pb_detail.setVisibility(View.VISIBLE);
            }else{
                pb_detail.setVisibility(View.GONE);
            }

        }
    }
    @Override
    public void onBackPressed() {
        if(wv_detail.canGoBack()){
            wv_detail.goBack();
        }else{
            super.onBackPressed();
        }
    }

}
