package com.mephisto.Services;

import com.mephisto.Entities.UserInfo;
import com.mephisto.Mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by world on 2017/7/10.
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    /**
     * transfer user coin
     * @param fromUser transaction from which user
     * @param toUser tansaction to which user
     * @param coin transaction amount
     * @return true
     */
    @Transactional
    public boolean transferCoin(int fromUser, int toUser, int coin)
    {
        if(userMapper.updateUserCoin(fromUser,coin)==1)
        {
            if(userMapper.updateUserCoin(toUser, -coin)!=1)
            {
                throw new RuntimeException("second step failed");
            }
            return true;
        }
        else
        {
            return false;
        }

    }



    public UserInfo getUserInfo(int userID)
    {
        return userMapper.getUserById(userID);
    }
}
