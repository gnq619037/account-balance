package com.account.balance.dao;

import com.account.balance.bean.Balance;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BalanceMapper {

    /**
     *
     * @param balance
     * @return
     */
    @Insert("insert into t_balance (balance, limit_rate, account_id) values " +
            "(#{balance, jdbcType=DECIMAL}, #{limitRate, jdbcType=DECIMAL}, #{accountId, jdbcType=BIGINT})")
    public int insertBalance(Balance balance);

    @Delete("delete from t_balance where id = #{id, jdbcType=BIGINT}")
    public int deleteBalance(long id);

    @Delete("delete from t_balance where account_id = #{accountId, jdbcType=BIGINT}")
    public int deleteBalanceByAccountId(long accountId);

    @Update("update t_balance set balance = #{balance, jdbcType=DECIMAL}, limit_rate = #{limitRate, jdbcType=DECIMAL}, account_id = #{accountId, jdbcType=BIGINT}")
    public int updateBalance(Balance balance);

    @Select("select id, balance, limit_rate as limitRate, account_id as accountId from t_balance where id = #{id, jdbcType=BIGINT}")
    public Balance getBalanceById(long id);

    @Select("select id, balance, limit_rate as limitRate, account_id as accountId from t_balance where account_id = #{accountId, jdbcType=BIGINT}")
    public Balance getBalanceByAccountId(long accountId);
}
