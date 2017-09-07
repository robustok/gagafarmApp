package com.robustok.gagafarm.Utility;

import android.content.Context;

import com.robustok.gagafarm.data.source.LocalUserDataSource;
import com.robustok.gagafarm.data.source.UserRepository;

/**
 * Created by Administrator on 2017/9/6.
 */

public class Injection {
    public static UserRepository provideUserRepository(Context context){
        return LocalUserDataSource.getInstance(context);
    }
}
