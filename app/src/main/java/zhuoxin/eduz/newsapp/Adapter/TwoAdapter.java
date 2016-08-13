package zhuoxin.eduz.newsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.zip.Inflater;

import zhuoxin.eduz.newsapp.R;
import zhuoxin.eduz.newsapp.entity.News;

/**
 * Created by Administrator on 2016/8/5.
 */
public class TwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private Context context;
    private com.nostra13.universalimageloader.core.ImageLoader imageLoader;
    private ArrayList<News>Datas=new ArrayList<>();
    private ImageLoaderConfiguration configuration;
    public TwoAdapter(Context context, ArrayList<News> datas) {
        this.context = context;
        Datas = datas;
       imageLoader= com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        configuration=ImageLoaderConfiguration.createDefault(context);
        imageLoader.init(configuration);
    }
//    public int getItemViewType(int position) {
//        return position;
//    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder1 extends RecyclerView.ViewHolder{
        private TextView tv1_Holder1;
        private ImageView iv1_Holder1;

        public ViewHolder1(View itemView) {
            super(itemView);
            tv1_Holder1= (TextView) itemView.findViewById(R.id.tv_viewHolder1);
            iv1_Holder1= (ImageView) itemView.findViewById(R.id.iv_viewHolder1);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{

        private ImageView iv;
        public ViewHolder2(View itemView) {
            super(itemView);
           iv= (ImageView) itemView.findViewById(R.id.iv2_Holder2);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v1= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two_viewholder1,null);
        View v2=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two_viewholder2,null);
        if(viewType==0){
            return new ViewHolder2(v2);
        }else{
         return new ViewHolder1(v1);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ViewHolder1){
            ((ViewHolder1) holder).tv1_Holder1.setText(Datas.get(position).getTitle());
            ((ViewHolder1) holder).iv1_Holder1.setImageResource(R.drawable.touxiang3);
            imageLoader.displayImage(Datas.get(position).getIcon(),((ViewHolder1) holder).iv1_Holder1);
            ((ViewHolder1) holder).iv1_Holder1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        listener.onItemClick(position);
                    }
                }
            });
        }
        if(holder instanceof ViewHolder2){
            ((ViewHolder2) holder).iv.setImageResource(R.drawable.touxiang3);
            imageLoader.displayImage(Datas.get(position).getIcon(),((ViewHolder2) holder).iv);
            ((ViewHolder2) holder).iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        listener.onItemClick(position);
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return Datas.size();
    }
    public interface onItemcliclisten{
        void onItemClick(int position);
    }
    private onItemcliclisten listener;
    public void  setOnItemClickListener(onItemcliclisten listener){
        this.listener=listener;

    }
}
