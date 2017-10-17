package com.robustok.gagafarm.data.source;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;

import com.robustok.gagafarm.data.User;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18.
 * 该类为实现了UserRepository接口的远程数据源
 */

public class RemoteUserDataSource implements UserDataSource {
    public static RemoteUserDataSource INSTANCE = null;
    private RemoteUserDataSource(){
    }
    public static RemoteUserDataSource getInstance(){
        if(INSTANCE == null){
            INSTANCE=new RemoteUserDataSource();
            return INSTANCE;
        }
        return INSTANCE;
    }

    @Override
    public void saveUser(final User user) {

       new AsyncTask<String,String,String>(){

           @Override
           protected String doInBackground(String... params) {
               save2Mysql(user);
               return null;
           }
       }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
    private void save2Mysql(User user){
        String result = ""; // 声明一个代表显示内容的字符串
        String target = "http://robustok.com/userRegi.php";   //要提交的目标地址
        URL url;
        try {
            url = new URL(target);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection(); // 创建一个HTTP连接
            urlConn.setRequestMethod("POST"); // 指定使用POST请求方式
            urlConn.setDoInput(true); // 向连接中写入数据
            urlConn.setDoOutput(true); // 从连接中读取数据
            urlConn.setUseCaches(false); // 禁止缓存

            urlConn.setInstanceFollowRedirects
                    (true);   //自动执行HTTP重定向
            urlConn.setRequestProperty
                    ("Content-Type","application/x-www-form-urlencoded"); // 设置内容类型
            DataOutputStream out = new DataOutputStream(urlConn.getOutputStream());// 获取输出流
            String param = "userName="
                    + URLEncoder.encode(user.getUserName().toString(), "utf-8")
                    + "&password="
                    + URLEncoder.encode
                    (user.getPassword().toString(), "utf-8"); //连接要提交的数据
            out.writeBytes(param);//将要传递的数据写入数据输出流
            out.flush();    //输出缓存
            out.close();    //关闭数据输出流
            // 判断是否响应成功
            if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader in = new
                        InputStreamReader(urlConn.getInputStream());// 获得读取的内容
                BufferedReader buffer = new
                        BufferedReader(in); // 获取输入流对象
                String inputLine = null;
                while ((inputLine =
                        buffer.readLine()) != null) {
                    result += inputLine + "\n";
                }
                in.close(); //关闭字符输入流
            }
            urlConn.disconnect();   //断开连接
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public User getUser(String getUser) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(String deleteUser) {
        return false;
    }

    @Override
    public boolean deleteAllUsers() {
        return false;
    }
}
