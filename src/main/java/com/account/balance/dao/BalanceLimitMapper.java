package com.account.balance.dao;

import com.account.balance.bean.BalanceLimit;
import com.account.balance.dto.BalanceLimitDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BalanceLimitMapper {

    /**
     * 保存额度配置
     * @param balanceLimit
     * @return
     */
    @Insert("insert into t_balance_limit (quota, limit_rate) values (#{quota, jdbcType=DECIMAL}, #{limitRate, jdbcType=INTEGER})")
    public int insertBalanceLimit(BalanceLimit balanceLimit);

    /**
     * 删除对应额度
     * @param id
     * @return
     */
    @Delete("delete from t_balance_limit where id = #{id, jdbcType=BIGINT}")
    public int deleteBalanceLimit(long id);

    /**
     * 更新额度配置信息
     * @param balanceLimit
     * @return
     */
    @Update("update t_balance_limit set limit_rate = #{limitRate, jdbcType=INTEGER}, quota = #{quota, jdbcType=DECIMAL}")
    public int updateBalanceLimit(BalanceLimit balanceLimit);

    /**
     * 通过id获取额度信息
     * @param id
     * @return
     */
    @Select("select id, quota, limit_rate as limitRate from t_balance_limit where id = #{id, jdbcType=BIGINT}")
    public BalanceLimit getBalanceLimitById(long id);

    /**
     * 通过账户id获取额度信息
     * @param accountId
     * @return
     */
    @Select("select bl.id, bl.quota, bl.limit_rate as limitRate from t_balance_limit bl left join t_limit_account ba " +
            "on bl.id = ba.limit_id where ba.account_id = #{accountId, jdbcType=BIGINT}")
    public BalanceLimit getBalanceByAccountId(long accountId);

    /**
     * 获取额度列表
     * @return
     */
    @Select("select id, quota, limit_rate as limitRate from t_balance_limit")
    public List<BalanceLimit> queryAllLimit();

    /**
     * 通过id获取额度分配的对应用户
     * @param id
     * @return
     */
    public BalanceLimitDto getBalanceAccountsById(long id);
}
