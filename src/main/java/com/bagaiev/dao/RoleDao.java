package com.bagaiev.dao;

import com.bagaiev.entities.Role;

/**
 * Created by Kostya on 13.08.2014.
 */
public interface RoleDao extends IEntityDao<Role> {
    Role getStudentRole();
}
