package com.bagaiev.dao;

import com.bagaiev.entities.Account;

import java.util.List;

/**
 * Created by Kostya on 12.08.2014.
 */
public interface AccountDao extends IEntityDao<Account> {

    List<Account> listAccounts (int offset, int count);

    Account findByLogin(String email);
}
