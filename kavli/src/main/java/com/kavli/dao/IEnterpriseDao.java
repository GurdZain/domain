package com.kavli.dao;

import com.kavli.core.exception.DaoException;

/**
 * Created by Administrator on 2017/3/8.
 */
public interface IEnterpriseDao {
    String getEnterpriseName(Long enterpriseId) throws DaoException;
    Long insert() throws DaoException;
}
