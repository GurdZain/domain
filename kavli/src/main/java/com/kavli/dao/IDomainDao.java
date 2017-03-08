package com.kavli.dao;

import com.kavli.core.exception.DaoException;
import com.kavli.domain.DomainResult;

/**
 * Created by Administrator on 2017/3/8.
 */
public interface IDomainDao {
    String getLastDomain(Long id) throws DaoException;
    int insertNewDomain(DomainResult result) throws DaoException;
    int updateLastDomain(Long id, String name) throws DaoException;
}
