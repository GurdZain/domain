package com.nnbee.service;

import com.nnbee.core.exception.ServiceException;

/**
 * Created by Administrator on 2017/3/20.
 */
public interface IUserService {
    int getUserCount(Long enterpriseId) throws ServiceException;
}
