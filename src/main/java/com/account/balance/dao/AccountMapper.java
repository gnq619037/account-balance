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
    @Insert("insert into t_account (account_code, account_status, balance) " +
            "values (#{accountCode, jdbcType=VARCHAR}, #{accountStatus, jdbcType=INTEGER}, #{balance, jdbcType=DECIMAL})")
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

    /**
     * 修改余额
     * @param account
     * @return
     */
    @Update("update t_account set balance = #{balance, jdbcType=DECIMAL} where id = #{id, jdbcType=BIGINT}")
    public int updateAccountBalance(Account account);

    /**
     * 批量修改账户
     * @param accountList
     * @return
     */
    public int updateAccounts(List<Account> accountList);

    /**
     * 获取所有的账户
     * @return
     */
    @Select("select id, account_code as accountCode, account_status as accountStatus, balance from t_account")
    public List<Account> queryAllAccount();

    /**
     * 通过账户号获取账户信息
     * @param accountCode
     * @return
     */
    @Select("select id, account_code as accountCode, account_status as accountStatus, balance from t_account where account_code = #{accountCode, jdbcType=VARCHAR}")
    public Account getAccountByCode(String accountCode);
}
