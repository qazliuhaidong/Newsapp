package zhuoxin.eduz.newsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

import zhuoxin.eduz.newsapp.R;
import zhuoxin.eduz.newsapp.entity.News;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private com.nostra13.universalimageloader.core.ImageLoader imageLoader;
    private Context context;
    private ArrayList<News> list=new ArrayList<>();
    private ImageLoaderConfiguration configuration;
    public ListAdapter(ArrayList<News> list,Context context) {
        this.context = context;
        this.list = list;
        imageLoader= com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        configuration=ImageLoaderConfiguration.createDefault(context);
        imageLoader.init(configuration);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;
        public ViewHolder(View itemView) {
            super(itemView);
            icon= (ImageView) itemView.findViewById(R.id.imageView_list);
            title= (TextView) itemView.findViewById(R.id.title_list);
        }
    }
//    public void addNews(ArrayList<News> list){
//        list.addAll(list);
//    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.icon.setImageResource(R.drawable.touxiang3);

        imageLoader.displayImage(list.get(position).getIcon(),holder.icon);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onItemCliclisten(position);
                }
            }
        });

    }
    public interface onItemcliclisten{

        void onItemCliclisten(int position);
    }
    onItemcliclisten listener;
    public void setOnItemCliclisten(onItemcliclisten listener){
        this.listener=listener;
    }



    @Override
    public int getItemCount() {
        return list.size();
    }


}

