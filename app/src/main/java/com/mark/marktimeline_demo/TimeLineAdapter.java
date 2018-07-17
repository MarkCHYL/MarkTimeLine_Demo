package com.mark.marktimeline_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * $desc$
 *
 * @Author mark 2285581945@qq.com
 * @Date 2018/7/17
 */
public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder>
        implements View.OnClickListener {

    private List<TimeLineBean> mList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;
    private static final int TYPE_TOP = 0x0000;
    private static final int TYPE_NORMAL = 0x0001;
    private static final int TYPE_BOTTOM = 0x0002;

    public TimeLineAdapter(Context context, List<TimeLineBean> list) {
        this.mContext = context;
        this.mList = list;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mInflater.inflate(R.layout.item_time_line, parent, false);
        item.setOnClickListener(this);
        return new TimeLineViewHolder(item);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_TOP) {
            // 第一行头的竖线不显示
            holder.tvTopLine.setVisibility(View.INVISIBLE);
            // 字体颜色加深
            holder.tvAcceptTime.setTextColor(0xff555555);
            holder.tvAcceptStation.setTextColor(0xff555555);
            holder.tvletfAcceptStation.setTextColor(0xff555555);
            holder.tvleftAcceptTime.setTextColor(0xff555555);
            holder.tvDot.setBackgroundResource(R.drawable.timelline_dot_first);

        } else if (getItemViewType(position) == TYPE_BOTTOM) {
            //最后一条
            holder.tvTopLine.setVisibility(View.VISIBLE);
            holder.tvbottomLine.setVisibility(View.INVISIBLE);
            holder.tvAcceptTime.setTextColor(0xff999999);
            holder.tvAcceptStation.setTextColor(0xff999999);
            holder.tvDot.setBackgroundResource(R.drawable.timelline_dot_normal);
        } else {
            holder.tvTopLine.setVisibility(View.VISIBLE);
            holder.tvAcceptTime.setTextColor(0xff999999);
            holder.tvAcceptStation.setTextColor(0xff999999);
            holder.tvDot.setBackgroundResource(R.drawable.timelline_dot_normal);
        }

        if (position%2!=0){
            holder.llCenter.setVisibility(View.INVISIBLE);
            holder.rlCenter.setVisibility(View.VISIBLE);
            holder.tvAcceptTime.setText(mList.get(position).getAcceptTime());
            holder.tvAcceptStation.setText(mList.get(position).getAcceptStation());
        }else {
            holder.rlCenter.setVisibility(View.INVISIBLE);
            holder.llCenter.setVisibility(View.VISIBLE);
            holder.tvleftAcceptTime.setText(mList.get(position).getAcceptTime());
            holder.tvletfAcceptStation.setText(mList.get(position).getAcceptStation());
        }


        holder.itemView.setTag(position);
    }

    public List<TimeLineBean> getmList() {
        return mList;
    }

    public void setmList(List<TimeLineBean> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TOP;
        } else if (position == getItemCount() - 1) {
            return TYPE_BOTTOM;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public void onClick(View v) {
        if (itemClickListener != null) {
            //注意这里使用getTag方法获取position
            itemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    class TimeLineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTopLine)
        TextView tvTopLine;
        @BindView(R.id.tvDot)
        TextView tvDot;
        @BindView(R.id.tvbottomLine)
        TextView tvbottomLine;
        @BindView(R.id.tvAcceptTime)
        TextView tvAcceptTime;
        @BindView(R.id.tvAcceptStation)
        TextView tvAcceptStation;
        @BindView(R.id.tvleftAcceptTime)
        TextView tvleftAcceptTime;
        @BindView(R.id.tvletfAcceptStation)
        TextView tvletfAcceptStation;
        @BindView(R.id.llCenter)
        RelativeLayout llCenter;
        @BindView(R.id.rlCenter)
        RelativeLayout rlCenter;

        public TimeLineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private OnItemClickListener itemClickListener = null;

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
