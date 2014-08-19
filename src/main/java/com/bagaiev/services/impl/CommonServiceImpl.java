package com.bagaiev.services.impl;

import com.bagaiev.dao.AccountDao;
import com.bagaiev.entities.Account;
import com.bagaiev.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Kostya on 13.08.2014.
 */

@Service("commonService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CommonServiceImpl implements CommonService {

    @Autowired
    private AccountDao accountDao;

    public Boolean login (String username, String password) {
        Account account = accountDao.findByLogin(username);
        if (account != null && account.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
