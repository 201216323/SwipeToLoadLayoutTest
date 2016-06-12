package fithub.cc.swipetoloadlayouttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeToLoadLayout swipeToLoadLayout;
//    private SwipeRefreshHeaderLayout swipe_refresh_header;
    private RecyclerView swipe_target;
//    private SwipeLoadMoreFooterLayout swipe_load_more_footer;
    private List<String> list;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
        swipe_target = (RecyclerView) findViewById(R.id.swipe_target);
        swipe_target.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<String>();
        for (int i=0;i<10;i++){
            list.add("原始数据"+i);
        }
        myAdapter = new MyAdapter(list);
        //为recyclerView设置适配器
        swipe_target.setAdapter(myAdapter);
        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
//                list.clear();
                for (int i = 0; i < 1; i++) {
                    list.add(0,"刷新获得的数据"+i);
                }
                myAdapter.notifyDataSetChanged();
                //设置下拉刷新结束
                swipeToLoadLayout.setRefreshing(false);
            }
        });
        //为swipeToLoadLayout设置上拉加载更多监听者
        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                for (int i = 0; i < 2; i++) {
                    list.add("加载更多获得的数据"+i);
                }
                myAdapter.notifyDataSetChanged();
                //设置上拉加载更多结束
                swipeToLoadLayout.setLoadingMore(false);
            }
        });
    }
}
