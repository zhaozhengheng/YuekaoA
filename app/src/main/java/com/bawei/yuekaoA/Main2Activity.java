package com.bawei.yuekaoA;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {

    private XRecyclerView mXRecyclerView;
    private List<Bean> list;
    int  time=3;
  Handler han=new Handler(){
      @Override
      public void handleMessage(Message msg) {
          super.handleMessage(msg);
          Apdate mApdate = new Apdate(Main2Activity.this,list);
          mXRecyclerView.setAdapter(mApdate);
          mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
              @Override
              public void onRefresh()
              {
                  list.clear();
                  initDate();
                  Apdate mApdate = new Apdate(Main2Activity.this,list);
                  mXRecyclerView.setAdapter(mApdate);
                  mApdate.notifyDataSetChanged();
                  mXRecyclerView.refreshComplete();

              }

              @Override
              public void onLoadMore()
              {
                  time+=10;
                  initDate();
                  Apdate mApdate = new Apdate(Main2Activity.this,list);
                  mXRecyclerView.setAdapter(mApdate);
                  mApdate.notifyDataSetChanged();
                  mXRecyclerView.loadMoreComplete();


              }
          });

      }
  };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initDate();
        list = new ArrayList<Bean>();
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void initDate()
    {

        OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
         Request request = new Request.Builder()
                .url("http://api.fang.anjuke.com/m/android/1.3/shouye/recInfosV3/?city_id=14&lat=40.04652&lng=116.306033&api_key=androidkey&sig=9317e9634b5fbc16078ab07abb6661c5&macid=45cd2478331b184ff0e15f29aaa89e3e&app=a-ajk&_pid=11738&o=PE-TL10-user+4.4.2+HuaweiPE-TL10+CHNC00B260+ota-rel-keys%2Crelease-keys&from" +
                        "=mobile&m=Android-PE-TL10&cv=9.5.1&cid=14&i=864601026706713" +
                        "&v=4.4.2&pm=b61&uuid=1848c59c-185d-48d9-b0e9-782016041109&_chat_" +
                        "id=0&qtime=2016041109160"+time)
                .build();
//new call
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e)
            {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                try {
                    JSONObject js=new JSONObject(string);
                    JSONObject result = js.optJSONObject("result");
                    JSONArray rows = result.optJSONArray("rows");
                    String[] arr=new String[rows.length()];
                    for(int i=0;i<arr.length;i++)
                    {
                        arr[i] =rows.optString(i);
                        JSONObject jj =new JSONObject(arr[i]);
                        JSONObject info = jj.optJSONObject("info");
                        String default_image = info.optString("default_image");
                        String loupan_name = info.optString("loupan_name");
                        String sale_title = info.optString("sale_title");
                        String new_price_value = info.optString("new_price_value");
                        String region_title = info.optString("region_title");
                        String tags = info.optString("tags");
                        Bean bean = new Bean();
                        bean.setDiqu(region_title);
                        bean.setDizongjia(tags);
                        bean.setFangzi(sale_title);
                        bean.setImage(default_image);
                        bean.setJiage(new_price_value);
                        bean.setJieshao(loupan_name);
                        list.add(bean);
                        han.sendEmptyMessage(0);

                    }



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void initView()
    {
        mXRecyclerView = (XRecyclerView) findViewById(R.id.XRecyclerView);

    }
}
