package com.mephisto.Util;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by world on 2017/7/10.
 */
public class DbHelper {
    public String insert_users()
    {
        SQL sqlBuilder = new SQL();
        sqlBuilder.INSERT_INTO("user")
                .VALUES("user_name, user_pass","#{user_name}, #{user_pass}");
        return sqlBuilder.toString();
    }

    //update user coin table
    public String update_users_coin()
    {
        return new SQL()
        {
            {
                UPDATE("users_coin");
                SET("coin = coin-#{coin_value}");
                WHERE("user_id = #{user_id} and (coin - #{coin_value}>=0)");
            }
        }.toString();
    }
}
