package com.bawei.yuekaoA;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 1 on 2017/3/29.
 */
public class Apdate  extends RecyclerView.Adapter<MyViewHode>
{
    private Context context;
    private List<Bean> list;

    public Apdate(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHode onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyViewHode mMyViewHode = new MyViewHode(view);

        return mMyViewHode;
    }


    @Override
    public void onBindViewHolder(MyViewHode holder, int position)
    {
        holder.diqu.setText(list.get(position).getDiqu());
        Glide.with(context).load(list.get(position).getImage()).into(holder.mImageView);
        holder.dizongjia.setText(list.get(position).getDizongjia());
        holder.jiage.setText(list.get(position).getJiage());
        holder.jieshao.setText(list.get(position).getJieshao());
        holder.fangzi.setText(list.get(position).getFangzi());
    }


    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
class MyViewHode extends RecyclerView.ViewHolder{
    ImageView mImageView;
    TextView jieshao,diqu,jiage,dizongjia,fangzi;
    public MyViewHode(View itemView) {
        super(itemView);
         mImageView = (ImageView) itemView.findViewById(R.id.ImageView);
        jieshao = (TextView) itemView.findViewById(R.id.TextView_jieshao);
        diqu = (TextView) itemView.findViewById(R.id.TextView_diqu);
        jiage = (TextView) itemView.findViewById(R.id.TextView_jiage);
        dizongjia = (TextView) itemView.findViewById(R.id.TextView_dizongjia);
        fangzi = (TextView) itemView.findViewById(R.id.TextView_fangzi);



    }
}
