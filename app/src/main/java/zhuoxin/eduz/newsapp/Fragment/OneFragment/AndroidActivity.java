package zhuoxin.eduz.newsapp.Fragment.OneFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import zhuoxin.eduz.newsapp.Adapter.ListAdapter;
import zhuoxin.eduz.newsapp.DatailActivity;
import zhuoxin.eduz.newsapp.R;
import zhuoxin.eduz.newsapp.entity.NewsInfo;

/**
 * Created by Administrator on 2016/7/28.
 */
public class AndroidActivity extends Fragment{

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    RequestQueue mrequestQueue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_internet,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView= (RecyclerView) view.findViewById(R.id.rc_internet);
        mrequestQueue = Volley.newRequestQueue(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getStringResult();
        super.onViewCreated(view, savedInstanceState);
    }
    private void getStringResult() {
        String url = "http://118.244.212.82:9092/newsClient/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140322&cnt=20";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                final NewsInfo newsInfo=gson.fromJson(s,NewsInfo.class);
                Log.d("Debug",newsInfo.getData().get(0).getSummary());
                adapter=new ListAdapter(newsInfo.getData(),getContext());
                recyclerView.setAdapter(adapter);
                adapter.setOnItemCliclisten(new ListAdapter.onItemcliclisten() {
                    @Override
                    public void onItemCliclisten(int position) {
                        Intent intent=new Intent(getActivity(), DatailActivity.class);
                        intent.putExtra("url",newsInfo.getData().get(position).getLink());
                        startActivity(intent);

                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }
        );
        mrequestQueue.add(request);

    }

}
