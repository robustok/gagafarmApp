package com.robustok.gagafarm.data.source;

import android.content.ContentValues;
import android.content.Context;

import com.robustok.gagafarm.Utility.UserPersistenceContract;
import com.robustok.gagafarm.data.GagafarmDbHelper;
import com.robustok.gagafarm.data.UserLogin;
import com.robustok.gagafarm.login.LoginContract;
import com.robustok.gagafarm.register.RegisterContract;

import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Administrator on 2017/6/29.
 * 用户注册数据源
 */

public class LocalUserDataSource implements UserDataSource {

   public static LocalUserDataSource INSTANCE ;
    private RegisterContract.Presenter mRegisterPresenter;
    private LoginContract.Presenter mLoginPresenter;
    //public static Fragment mFragment;
    private GagafarmDbHelper mGagafarmDbHelper;
    private LocalUserDataSource(@NonNull Context context){
      checkNotNull(context);
      mGagafarmDbHelper = new GagafarmDbHelper(context);
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
    public void saveUserLogin(@NonNull UserLogin userLogin, @NonNull SaveUserLoginCallback saveUserLoginCallback) {
        checkNotNull(userLogin);
        long i = 0L;
        try {
            SQLiteDatabase db = mGagafarmDbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(UserPersistenceContract.UserEntry.COLUMN_NAME_USERNAME, userLogin.getUserName());
            values.put(UserPersistenceContract.UserEntry.COLUMN_NAME_PASSWORD, userLogin.getPassword());
            //返回插入成功的行的id
            i = db.insert(UserPersistenceContract.UserEntry.TABLE_NAME, null, values);
            db.close();
        }
        catch(SQLiteCantOpenDatabaseException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }




    @Override
    public void getUserLogin(@NonNull UserLogin login, GetUserLoginCallback getUserLoginCallback) {
        return ;
    }

    @Override
    public void getAllUserLogin( GetUserLoginCallback getUserLoginCallback) {
     /*  List<UserLogin> userLogins =new ArrayList<UserLogin>();
       SQLiteDatabase db = mGagafarmDbHelper.getWritableDatabase();
        Cursor cursor;
        if(db.isOpen())
        {
            cursor = db.query(UserPersistenceContract.UserEntry.TABLE_NAME, new String[]{UserPersistenceContract.UserEntry.COLUMN_NAME_ID,UserPersistenceContract.UserEntry.COLUMN_NAME_USERNAME, UserPersistenceContract.UserEntry.COLUMN_NAME_PASSWORD}, null, null, null, null, null);
            while(cursor.moveToNext())
            {
                UserLogin userLogin = new UserLogin(cursor.getString(cursor.getColumnIndex(UserPersistenceContract.UserEntry.COLUMN_NAME_USERNAME)),cursor.getString(cursor.getColumnIndex(UserPersistenceContract.UserEntry.COLUMN_NAME_PASSWORD)));
                userLogins.add(userLogin);
            }
        }

        return userLogins;
        */
    }

    @Override
    public void deleteUserLogin(String userName, DeleteUserLoginCallback deleteUserLoginCallback) {
        return ;
    }

    @Override
    public void deleteAllUserLogin(DeleteUserLoginCallback deleteUserLoginCallback) {
        return ;
    }

    public static LocalUserDataSource getInstance(Context context){
      if(INSTANCE == null) {
        //  mFragment = (RegisterFragment)fragment;

          INSTANCE = new LocalUserDataSource(context);
      }
      return INSTANCE;
    }

}
