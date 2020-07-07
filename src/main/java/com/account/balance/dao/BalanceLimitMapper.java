package com.account.balance.dao;

import com.account.balance.bean.BalanceLimit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BalanceLimitMapper {

    /**
     *
     * @param balanceLimit
     * @return
     */
    @Insert("insert into t_balance_limit (limit_rate) values (#{limitRate, jdbcType=DECIMAL})")
    public int insertBalanceLimit(BalanceLimit balanceLimit);

    @Delete("delete from t_balance_limit where id = #{id, jdbcType=BIGINT}")
    public int deleteBalanceLimit(long id);

    @Update("update t_balance_limit set limit_rate = #{limitRate, jdbcType=DECIMAL}")
    public int updateBalanceLimit(BalanceLimit balanceLimit);

    @Select("select id, limit_rate as limitRate from t_balance_limit where id = #{id, jdbcType=BIGINT}")
    public BalanceLimit getBalanceLimitById(long id);

    @Select("select id, limit_rate as limitRate from t_balance_limit bl left join t_balance_account ba " +
            "on bl.id = ba.balance_id where ba.account_id = #{accountId, jdbcType=BIGINT}")
    public BalanceLimit getBalanceByAccountId(long accountId);

    @Select("select id, limit_rate as limitRate from t_balance_limit")
    public List<BalanceLimit> queryAllLimit();
}
