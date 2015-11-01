package com.skyfin.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyfin.recyclerview.bean.RecycleItemBean;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> implements View.OnClickListener
,View.OnLongClickListener{

    //数据
    List<RecycleItemBean> mData;
    Context mContext;
    LayoutInflater mLayoutInflater;
    ItemClickListener mItemClickListener;
    ItemLongClickListener mItemLongClickListener;
    public RecycleAdapter(List<RecycleItemBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //初始化Item
        View view = mLayoutInflater.inflate(R.layout.recycleitem, parent, false);
        //ViewHolder初始化
        MyViewHolder holder = new MyViewHolder(view);
        //设置View监听
        holder.itemView.setOnLongClickListener(this);
        //设置ViewItem上面的图片监听
        holder.mImageView.setOnClickListener(this);
        //设置ViewItem上文字监听
        holder.mText.setOnClickListener(this);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //绑定数据
        holder.mImageView.setImageResource(mData.get(position).getImageviewdrawable());
        holder.mText.setText(mData.get(position).getTitle());
        //设置View的Tag的数据，用于监听事件获得数据
        holder.itemView.setTag(mData.get(position).toString());
        holder.mImageView.setTag("Image" + position);
        holder.mText.setTag(mData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    //  删除指定的Item
    public void removeData(int position)
    {
        mData.remove(position);
        //  通知RecyclerView控件某个Item已经被删除
        notifyItemRemoved(position);

    }
    //  在指定位置添加一个新的Item
    public void addItem(RecycleItemBean model,int positionToAdd)
    {
        mData.add(model);
        //  通知RecyclerView控件插入了某个Item
        notifyItemInserted(positionToAdd);
    }
    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.OnClick(v);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (mItemLongClickListener != null) {
            mItemLongClickListener.OnLongClick(v);
        }
        return true;
    }
    //ItemView上面控件的初始化
    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mText;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mText = (TextView) itemView.findViewById(R.id.title);
        }
    }

    //单击的回调接口
    public  interface ItemClickListener {
        void OnClick(View v);
    }

    //长按的回调接口
    public interface ItemLongClickListener{
        void OnLongClick(View v);
    }
    //设置单击的事件监听
    public void setOnCLickListener(ItemClickListener listener) {
        if (listener != null) {
            this.mItemClickListener = listener;
        }
    }
    //设置长按的事件监听
    public void setOnLongClickListener(ItemLongClickListener listener){
        if (listener != null) {
            this.mItemLongClickListener = listener;
        }
    }

}
