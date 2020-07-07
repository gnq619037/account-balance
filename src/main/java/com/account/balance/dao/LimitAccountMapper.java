package com.account.balance.dao;

import com.account.balance.bean.LimitAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LimitAccountMapper {


    public int insertLimitAccount(List<LimitAccount> limitAccounts);

    @Delete("delete from t_limit_account where limit_id = #{limitId, jdbcType=BIGINT}")
    public int deleteLimitAccount(long limitId);

    @Select("select id, account_id as accountId, limit_id as limitId from t_limit_account from t_limit_account")
    public List<LimitAccount> queryAccountByLimit(long limitId);
}
