package com.mephisto.Mappers;

import com.mephisto.Entities.UserInfo;
import com.mephisto.Util.DbHelper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by world on 2017/6/21.
 */
@Mapper
public interface UserMapper {
    @Select("select user_id,user_name,user_pass from user where user_id =#{uid}")
    public UserInfo getUserById(@Param("uid") int userID);

    @Select("select user_id,user_name,user_pass from user")
    public List<UserInfo> getAllUsers();


   @InsertProvider(type = DbHelper.class, method = "insert_users")
    @SelectKey(keyProperty = "user_id", before = false, resultType = int.class, statement = "select LAST_INSERT_ID()")
    public int addUser(UserInfo userInfo);

   @UpdateProvider(type = DbHelper.class, method = "update_users_coin")
    public int updateUserCoin(@Param("user_id") int userId, @Param("coin_value") int coinValue);

}
