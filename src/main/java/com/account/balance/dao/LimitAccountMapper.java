package com.account.balance.dao;

import com.account.balance.bean.LimitAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LimitAccountMapper {

    /**
     * 维护额度策略和用户之间的关系
     * @param limitAccounts
     * @return
     */
    public int insertLimitAccount(List<LimitAccount> limitAccounts);

    /**
     * 通过额度id删除对应的记录
     * @param limitId
     * @return
     */
    @Delete("delete from t_limit_account where limit_id = #{limitId, jdbcType=BIGINT}")
    public int deleteLimitAccount(long limitId);

    /**
     * 通过账户id删除对应记录
     * @param accountId
     * @return
     */
    @Delete("delete from t_limit_account where account_id = #{accountId, jdbcType=BIGINT}")
    public int deleteLimitAccountByAccount(long accountId);

    /**
     * 批量修改关系表
     * @param limitAccounts
     * @return
     */
    public int updateLimitAccounts(List<LimitAccount> limitAccounts);

    /**
     * 通过账户id获取到对应的额度id
     * @param accountId
     * @return
     */
    @Select("select id, account_id as accountId, limit_id as limitId from t_limit_account where account_id = #{accountId, jdbcType=BIGINT}")
    public LimitAccount getLimitByAccount(long accountId);

    /**
     * 通过额度策略id找到关系
     * @param limitId
     * @return
     */
    @Select("select id, account_id as accountId, limit_id as limitId from t_limit_account where limit_id = #{limitId, jdbcType=BIGINT}")
    public List<LimitAccount> queryAccountByLimit(long limitId);
}
