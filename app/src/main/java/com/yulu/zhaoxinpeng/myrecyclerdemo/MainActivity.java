package com.yulu.zhaoxinpeng.myrecyclerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*RecyclerView的使用
1.依赖
2.布局文件中使用该控件
3.找到控件（findViewbyId）
4.数据（假数据）
5.设这布局管理器（layoutManager）
6.适配器适配数据展示*/
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        initData();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainAdapter myAdapter = new MainAdapter(mList);

        myAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "短按，第" + position + "条数据", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "长按，第" + position + "条数据", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(myAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mList.add("这是第" + i + "条数据");
        }
    }

    // 以内部类的形式实现 MyAdapter
    /*class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.tv_item, parent, false));

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.mTv.setText(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private final TextView mTv;

            public MyViewHolder(View itemView) {
                super(itemView);

                mTv = (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }*/
}
