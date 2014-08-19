package com.bagaiev.dao.impl.hibernate;

import com.bagaiev.dao.AccountDao;
import com.bagaiev.entities.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kostya on 12.08.2014.
 */
@Repository("hibernateAccountDao")
public class AccountDaoImpl extends AbstractEntityDao<Account> implements AccountDao {


    @Override
    protected Class<Account> getEntityClass() {
        return Account.class;
    }

    @Override
    public List<Account> listAccounts(int offset, int count) {
        return getSession().createCriteria(Account.class).setFirstResult(offset).setFetchSize(count).list();
    }

    @Override
    public Account findByLogin(String login) {
        String hql = "FROM Account a where a.login = :login";
        return (Account) getSession().createQuery(hql).setParameter("login", login).uniqueResult();
    }
}
