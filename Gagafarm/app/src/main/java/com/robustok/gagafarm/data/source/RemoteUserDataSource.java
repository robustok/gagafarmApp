package com.robustok.gagafarm.data.source;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.os.AsyncTaskCompat;

import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.register.RegisterActivity;

import org.json.JSONException;
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

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Administrator on 2017/9/18.
 * 该类为实现了UserRepository接口的远程数据源
 */

public class RemoteUserDataSource implements UserDataSource {
    public static RemoteUserDataSource INSTANCE = null;
    public static Context mContext;//用于向RegisterActivity发送消息
    private RemoteUserDataSource(){
    }
    public static RemoteUserDataSource getInstance(@NonNull Context activityContext){
         checkNotNull(activityContext);
        if(INSTANCE == null){
            INSTANCE=new RemoteUserDataSource();
            mContext = activityContext;
            return INSTANCE;
        }
        return INSTANCE;
    }

    //保存用户
    private class SaveUserAsyncTask extends AsyncTask<User ,String ,String>{


        @Override
        protected String doInBackground(User... params) {
            return saveUser2Remote(params[0]);
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            RegisterActivity ra = (RegisterActivity)mContext;

            if(Integer.parseInt(s) == 1){
                ra.onFragmentInteraction("注册成功啦！");
            }
            else{
                ra.onFragmentInteraction("对不起，注册失败");
            }
        }
    }

    @Override
    public void saveUser(User user) {
        SaveUserAsyncTask saveUserAsynTask = new SaveUserAsyncTask();
        saveUserAsynTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,user);

        //该UI线程代码不会等到上面的异步线程结束，故此处获取的状态值不准确。
       // boolean saveOk = saveUserAsynTask.getSaveOk();

    }
    private String  saveUser2Remote(User user){
        String result = ""; // 声明一个代表显示内容的字符串
        String target = "http://10.200.192.148/web_robustok/userRegi.php";   //ip:10.200.192.148是本机动态获取的，每次开机不同，可用 ipconfig查看
       // String target = "http://robustok.com/userRegi.php";   //要提交的目标地址
        URL url;
        JSONObject jsonObject;
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
                result = result.substring(2); //﻿﻿{"success":0,"message":"\u5bf9\u4e0d\u8d77\uff0c\u6ce8\u518c\u4e0d\u6210\u529f\u3002"}
                jsonObject = new JSONObject(result);
              //  int i = jsonObject.getInt("success");
                result = jsonObject.getString("success");
            }
            urlConn.disconnect();   //断开连接

        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }

        return result;
    }
    public interface OnRemoteUserDataSourceInteractionListener{
        void OnRemoteUserDataSourceInteraction(boolean saveOk);
    }


    //为获取AsyncTask人返回值
    User userReturn = null;
   private class getUserAsyncTast extends AsyncTask<String,Void,User>{

       @Override
       protected User doInBackground(String... params) {
           User user = null;
           try{
               user = getUserFromRemote(params[0]);
           }
           catch(Exception ex){
               return null;
           }

           return user;
       }
       @Override
       protected void onPostExecute(User user) {
           super.onPostExecute(user);
           userReturn = user;
       }
   }
  private User getUserFromRemote(String userName){
     //测试用user object
      User user = new User("testUserName","testPassword");
     return user;
  }


    public User getUser( String userName) {
        new getUserAsyncTast().execute(userName);
        return  this.userReturn;
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
