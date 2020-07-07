package com.account.balance.dao;

import com.account.balance.bean.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {
    /**
     * 新增账户
     * @param account
     * @return
     */
    @Insert("insert into t_account (account_code, account_status) " +
            "values (#{accountCode, jdbcType=VARCHAR}, #{accountStatus, jdbcType=INTEGER})")
    public int insertAccount(Account account);

    /**
     * 删除账户
     * @param id
     * @return
     */
    @Delete("delete from t_account where id = #{id, jdbcType=BIGINT}")
    public int deleteAccount(long id);

    /**
     * 修改账户
     * @param account
     * @return
     */
    @Update("update t_account set account_status = #{accountStatus, jdbcType=INTEGER} where id = #{id, jdbcType=BIGINT}")
    public int updateAccount(Account account);

    public int updateAccounts(List<Long> ids);

    /**
     * 获取所有的账户
     * @return
     */
    @Select("select id, account_code as accountCode, account_status as accountStatus from t_account")
    public List<Account> queryAllAccount();
}
