package zhuoxin.eduz.newsapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import zhuoxin.eduz.newsapp.Adapter.tableandviewpageAdapter;
import zhuoxin.eduz.newsapp.AddActivity;
import zhuoxin.eduz.newsapp.Fragment.OneFragment.AndroidActivity;
import zhuoxin.eduz.newsapp.Fragment.OneFragment.InternetActivity;
import zhuoxin.eduz.newsapp.R;
import zhuoxin.eduz.newsapp.util.ShareUtil;

/**
 * Created by Administrator on 2016/7/27.
 */
public class One extends Fragment{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ArrayList<String>list;
    private ArrayList<Fragment> fragments;
    private ViewPager vp_one;
    private Button btn_one;
    private TabLayout tabLayout;
    private tableandviewpageAdapter adapter;
    InternetActivity internetActivity;
    AndroidActivity ad;
    private Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.layout_one,container,false);
        vp_one= (ViewPager) v.findViewById(R.id.vp_one);
        tabLayout= (TabLayout) v.findViewById(R.id.tb_one);
        btn_one= (Button) v.findViewById(R.id.btn_one);

        intitDate();
        adapter=new tableandviewpageAdapter(getChildFragmentManager(),fragments,list);
        vp_one.setAdapter(adapter);
        tabLayout.setTabsFromPagerAdapter(adapter);
        tabLayout.setupWithViewPager(vp_one);
        vp_one.setOffscreenPageLimit(2);
        return v;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//    }
    private void intitDate() {
        list=new ArrayList<>();
        fragments=new ArrayList<>();
        list.add("安卓");
        list.add("互联网");
        list.add("热点");
        list.add("四川");
        list.add("军事");
        list.add("娱乐");
        for (int i=0;i<list.size();i++){
            internetActivity=new InternetActivity();
            ad=new AndroidActivity();
            bundle=new Bundle();
//            bundle.putString("title",list.get(i));
            internetActivity.setArguments(bundle);
            ad.setArguments(bundle);
            fragments.add(internetActivity);
            fragments.add(ad);
        }

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddActivity.class);
                startActivityForResult(intent,110);
            }
        });
    }
    public void updataTitle(){
        String title= ShareUtil.getInstance(getContext()).getSPData();
        list.add(title);
        internetActivity=new InternetActivity();
        ad=new AndroidActivity();
        bundle=new Bundle();
        bundle.putString("title","123");
        fragments.add(internetActivity);
//        adapter=new tableandviewpageAdapter(getChildFragmentManager(),fragments,list);
//        Log.d("debug",title+"dsakfjasfkj");
//        vp_one.setAdapter(adapter);
//        internetActivity.setArguments(bundle);
//        tabLayout.setTabsFromPagerAdapter(adapter);
////        tabLayout.setupWithViewPager(vp_one);
//        vp_one.setOffscreenPageLimit(2);
         adapter.notifyDataSetChanged();
    }
public void downData(){
    String title= ShareUtil.getInstance(getContext()).getSPData();
    list.remove(title);
    internetActivity=new InternetActivity();
    fragments.remove(internetActivity);
    adapter.notifyDataSetChanged();

}


}
