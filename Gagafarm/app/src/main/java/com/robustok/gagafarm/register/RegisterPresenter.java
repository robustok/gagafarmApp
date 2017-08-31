package com.robustok.gagafarm.register;

import com.robustok.gagafarm.data.User;

/**
 * Created by Administrator on 2017/6/29.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    @Override
    public int userNameIsAvailable(String userName) {
        return 0;
    }

    @Override
    public void saveUser(User user) {

    }
}
