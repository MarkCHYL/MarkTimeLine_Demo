package com.mark.marktimeline_demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_rv)
    RecyclerView idRv;

    private List<TimeLineBean> mList = new ArrayList<>();
    private Context mContext;
    private TimeLineAdapter mAdapter;

    private boolean isPause  = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        initView();

        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        // 模拟一些假的数据
        mList.add(new TimeLineBean("2016-05-25 17:48:00", "[沈阳市] [沈阳和平五部]的派件已签收 感谢使用中通快递,期待再次为您服务!"));
        mList.add(new TimeLineBean("2016-05-25 14:13:00", "[沈阳市] [沈阳和平五部]的东北大学代理点正在派件 电话:18040xxxxxx 请保持电话畅通、耐心等待"));
        mList.add(new TimeLineBean("2016-05-25 13:01:04", "[沈阳市] 快件到达 [沈阳和平五部]"));
        mList.add(new TimeLineBean("2016-05-25 12:19:47", "[沈阳市] 快件离开 [沈阳中转]已发往[沈阳和平五部]"));
        mList.add(new TimeLineBean("2016-05-25 11:12:44", "[沈阳市] 快件到达 [沈阳中转]"));
        mList.add(new TimeLineBean("2016-05-24 03:12:12", "[嘉兴市] 快件离开 [杭州中转部]已发往[沈阳中转]"));
        mList.add(new TimeLineBean("2016-05-23 21:06:46", "[杭州市] 快件到达 [杭州汽运部]"));
        mList.add(new TimeLineBean("2016-05-23 18:59:41", "[杭州市] 快件离开 [杭州乔司区]已发往[沈阳]"));
        mList.add(new TimeLineBean("2016-05-23 18:35:32", "[杭州市] [杭州乔司区]的市场部已收件 电话:18358xxxxxx"));

        mAdapter = new TimeLineAdapter(mContext,mList);
        idRv.setLayoutManager(new LinearLayoutManager(this));
        idRv.setAdapter(mAdapter);

        mAdapter.setItemClickListener(new TimeLineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               Toast.makeText(mContext,mList.get(position).toString(),Toast.LENGTH_SHORT).show();
               if (position%2==0){
                   mList.remove(position);
                   mAdapter.setmList(mList);
                   mAdapter.notifyDataSetChanged();
               }else {
                   mList.add(position,mList.get(position));
                   mAdapter.setmList(mList);
                   mAdapter.notifyDataSetChanged();
               }
            }
        });
    }

    //初始化控件性能
    private void initView() {

        idRv.setFocusable(true);

    }


    @Override
    protected void onResume() {
        super.onResume();

    }
}
