package com.bagaiev.services;

import com.bagaiev.entities.Account;
import com.bagaiev.entities.Role;

import java.util.List;

/**
 * Created by Kostya on 13.08.2014.
 */
public interface CommonService {

    public Account login(String username, String password);


    List<Role> listAllRoles();
}
