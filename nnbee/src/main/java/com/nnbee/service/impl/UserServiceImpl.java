package com.nnbee.service.impl;

import com.nnbee.core.exception.DaoException;
import com.nnbee.core.exception.ServiceException;
import com.nnbee.dao.IUserDao;
import com.nnbee.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2017/3/20.
 */
@Named
@Transactional(value= "transactionManager_jdbc", rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService{
    @Inject
    private IUserDao userDao;
    @Override
    public int getUserCount(Long enterpriseId) throws ServiceException {
        try {
            return userDao.getUserCount(enterpriseId);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException(e.getExceptionType(), e.getErrorVO());
        }
    }
}
