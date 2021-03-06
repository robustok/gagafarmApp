package com.robustok.gagafarm.Utility;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;

import com.robustok.gagafarm.data.source.LocalUserDataSource;
import com.robustok.gagafarm.data.source.RemoteUserDataSource;
import com.robustok.gagafarm.data.source.UserDataSource;
import com.robustok.gagafarm.data.source.UserRepository;

import static com.google.common.base.Preconditions.checkNotNull;
//import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by Administrator on 2017/9/6.
 */

public class Injection {
    public static UserRepository provideUserRepository(@NonNull Context context){
        checkNotNull(context);
      //  checkNotNull(fragment);
        return UserRepository.getInstance(RemoteUserDataSource.getInstance(context),LocalUserDataSource.getInstance(context));
    }


}
