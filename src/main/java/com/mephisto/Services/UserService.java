package com.mephisto.Services;

import com.mephisto.Mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by world on 2017/7/10.
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    /**
     * transfer user coin
     * @param fromUser
     * @param toUser
     * @param coin
     * @return
     */
    public boolean transferCoin(int fromUser, int toUser, int coin)
    {
        userMapper.updateUserCoin(fromUser,coin);
        userMapper.updateUserCoin(toUser, -coin);
        return true;

    }
}
