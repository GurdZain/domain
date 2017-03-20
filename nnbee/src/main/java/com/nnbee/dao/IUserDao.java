package com.nnbee.dao;

import com.nnbee.core.exception.DaoException;

/**
 * Created by Administrator on 2017/3/20.
 */
public interface IUserDao {
    int getUserCount(Long enterpriseId) throws DaoException;
}
