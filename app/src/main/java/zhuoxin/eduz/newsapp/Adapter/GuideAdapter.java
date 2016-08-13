package zhuoxin.eduz.newsapp.Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/27.
 */
public class GuideAdapter extends PagerAdapter{

    private ArrayList<ImageView>imgList;

    public GuideAdapter(ArrayList<ImageView> imgList) {
        this.imgList = imgList;
    }

    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imgList.get(position));
        return imgList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(imgList.get(position));
    }


}
