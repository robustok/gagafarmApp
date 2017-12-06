package com.robustok.gagafarm.data.source;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.robustok.gagafarm.data.UserLogin;
import com.robustok.gagafarm.login.LoginContract;
import com.robustok.gagafarm.register.RegisterContract;

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

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Administrator on 2017/9/18.
 * 该类为实现了UserRepository接口的远程数据源
 */

public class RemoteUserDataSource implements UserDataSource {
    public static RemoteUserDataSource INSTANCE = null;
  //  public static RegisterFragment mFragment;//用于向RegisterActivity发送消息,但会打乱分层结构，不建议使用
    private RegisterContract.Presenter mRegisterPresenter;
    private LoginContract.Presenter mLoginPresenter;
    private SaveUserLoginCallback mSaveUserLoginCallback;
    private GetUserLoginCallback mGetUserLoginCallback;

    private RemoteUserDataSource(){
    }
    public static RemoteUserDataSource getInstance(@NonNull Context context){
         checkNotNull(context);
        if(INSTANCE == null){
            INSTANCE=new RemoteUserDataSource();
          //  mFragment = (RegisterFragment)fragment;
            return INSTANCE;
        }
        return INSTANCE;
    }

    //保存用户
    private class SaveUserLoginAsyncTask extends AsyncTask<UserLogin ,Integer ,String>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer...values){

        }

        @Override
        protected String doInBackground(UserLogin... params) {
            String result = saveUserLogin2Remote(params[0]);
            return result;
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
          //  mFragment.getProgressBar().setVisibility(View.GONE);
            if(Integer.parseInt(s) == 1){
                mSaveUserLoginCallback.onSaveOk();
            }
            else{
                mSaveUserLoginCallback.onSaveFailed();
            }
        }
    }

    @Override
    public void setLoginPresent(LoginContract.Presenter present) {
        this.mLoginPresenter = present;
    }

    @Override
    public void setRegisterPresenter(RegisterContract.Presenter presenter) {
            this.mRegisterPresenter = presenter;
    }

    @Override
    public void saveUserLogin(@NonNull UserLogin userLogin, SaveUserLoginCallback saveUserLoginCallback) {
        this.mSaveUserLoginCallback = saveUserLoginCallback;
        SaveUserLoginAsyncTask saveUserLoginAsynTask = new SaveUserLoginAsyncTask();
        saveUserLoginAsynTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,userLogin);

    }




    private String  saveUserLogin2Remote(UserLogin userLogin){
        String result = ""; // 声明一个代表显示内容的字符串
        String target = "http://10.200.192.148/gagafarm/forApp/userRegi.php";   //ip:10.200.192.148是本机动态获取的，每次开机不同，可用 ipconfig查看
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
                    + URLEncoder.encode(userLogin.getUserName().toString(), "utf-8")
                    + "&password="
                    + URLEncoder.encode
                    (userLogin.getPassword().toString(), "utf-8"); //连接要提交的数据
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



   private class GetUserLoginAsyncTast extends AsyncTask<UserLogin,Void,UserLogin>{

       @Override
       protected UserLogin doInBackground(UserLogin... params) {
           UserLogin userLogin = null;
           try{
               userLogin = getUserLoginFromRemote(params[0]);
           }
           catch(Exception ex){
               return null;
           }

           return userLogin;
       }
       @Override
       protected void onPostExecute(UserLogin userLogin) {
           super.onPostExecute(userLogin);
           mGetUserLoginCallback.onLoaded(userLogin);
       }
   }
      private UserLogin getUserLoginFromRemote(UserLogin login){
      String result = "";
      UserLogin userLogin = new UserLogin();
      String target = "http://10.200.192.148/gagafarm/forApp/login.php";
      URL url = null;
      JSONObject jsonObject = null;
      try{
          url = new URL(target);
          HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
          urlConnection.setRequestMethod("POST");
          urlConnection.setRequestMethod("POST"); // 指定使用POST请求方式
          urlConnection.setDoInput(true); // 向连接中写入数据
          urlConnection.setDoOutput(true); // 从连接中读取数据
          urlConnection.setUseCaches(false); // 禁止缓存
          urlConnection.setInstanceFollowRedirects
                  (true);   //自动执行HTTP重定向
          urlConnection.setRequestProperty
                  ("Content-Type","application/x-www-form-urlencoded"); // 设置内容类型
          DataOutputStream dos =new DataOutputStream(urlConnection.getOutputStream());
          String parameter = "userName="+URLEncoder.encode(login.getUserName(),"utf-8")+"&password="
                  +URLEncoder.encode(login.getPassword(),"utf-8");
          dos.writeBytes(parameter);
          dos.flush();
          dos.close();

          Integer i = urlConnection.getResponseCode();
          if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
              //获取字节流
              InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
              //获取字符流
              BufferedReader br = new BufferedReader(isr);
              String inputLines = null;
              while((inputLines=br.readLine()) != null){
                    result += inputLines + "\n";
              }
              isr.close();
              result = result.substring(2);
              jsonObject = new JSONObject(result);
             String userName = jsonObject.getString("userName");
              if(userName == "null")
                  return userLogin = null;
              userLogin.setUserName(userName);
              userLogin.setPassword(jsonObject.getString("password"));

          }
          urlConnection.disconnect();
          }
      catch(MalformedURLException ex)
      {
          ex.printStackTrace();
      }
      catch (IOException ex) {
          ex.printStackTrace();
      }
      catch(JSONException ex){
          ex.printStackTrace();
      }
      return userLogin;
  }



    @Override
    public void getUserLogin(@NonNull UserLogin userLogin, GetUserLoginCallback getUserLoginCallback) {
        mGetUserLoginCallback = getUserLoginCallback;
        GetUserLoginAsyncTast getUserAsyncTast = new GetUserLoginAsyncTast();
        getUserAsyncTast.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,userLogin);
    }

    @Override
    public void getAllUserLogin(GetUserLoginCallback getUserLoginCallback) {
        return ;
    }

    @Override
    public void deleteUserLogin(String userName, DeleteUserLoginCallback deleteUserLoginCallback) {
        return ;
    }

    @Override
    public void deleteAllUserLogin(DeleteUserLoginCallback deleteUserLoginCallback) {
        return ;
    }
}
