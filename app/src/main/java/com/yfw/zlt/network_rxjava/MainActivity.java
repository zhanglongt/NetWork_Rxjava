package com.yfw.zlt.network_rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yfw.zlt.network_rxjava.http.BaseProtocol;
import com.yfw.zlt.network_rxjava.http.MyHttpClient;

import java.util.HashMap;

import rx.functions.Action1;

/**
 * 测试
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button get,post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get= (Button) findViewById(R.id.get);
        post= (Button) findViewById(R.id.post);
        get.setOnClickListener(this);
        post.setOnClickListener(this);
    }
    private void getGet(){
       String url="http://service.test.xgo.com.cn:8080/app/v1/demo/1";

        new BaseProtocol().createObservable(url, MyHttpClient.METHOD_GET,null)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("ii","ces11:"+s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.i("ii","ces12:"+throwable);
                    }
                });
    }
    private void getPost(){
        String url="http://service.test.xgo.com.cn:8080/app/v1/demo/";
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", "Zeus");
        new BaseProtocol().createObservable(url,MyHttpClient.METHOD_POST,params)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("ii", "ces21:" + s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.i("ii","ces22:"+throwable);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.get){
            getGet();
        }else if(v.getId()==R.id.post){
            getPost();
        }
    }
}
