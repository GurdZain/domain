package com.nnbee.dao.impl;

import com.nnbee.core.base.das.jdbc.impl.AbstractJdbcDaoImpl;
import com.nnbee.core.exception.DaoException;
import com.nnbee.core.exception.UtilityException;
import com.nnbee.core.util.QueryDefinitionBean;
import com.nnbee.dao.IUserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzylz on 2017/3/19.
 */
public class UserDaoImpl extends AbstractJdbcDaoImpl implements IUserDao{
    private QueryDefinitionBean namedQueryBean;
    public QueryDefinitionBean getNamedQueryBean() {
        return namedQueryBean;
    }

    public void setNamedQueryBean(QueryDefinitionBean namedQueryBean) {
        this.namedQueryBean = namedQueryBean;
    }

    @Override
    public int getUserCount(Long enterpriseId) throws DaoException {
        int count = 0;
        String sql = null;
        try {
            sql = namedQueryBean.getQueryByName("GET_FAILED_PRINTER_CONTENT");
        } catch (UtilityException e) {
            throw new DaoException(e.getExceptionType(), e.getErrorVO());
        }
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("enterprise_id", enterpriseId);
        /*StringBuilder conditions = new StringBuilder();

        if (StringUtil.isNotBlank(openId)) {
            conditions.append(" AND c.identifier = :identifier ");
            paramMap.put("identifier", openId);
        }

        sql = sql.replace("[condition]", conditions.toString());*/
        List<Map<String, Object>> resultList = executeJdbcQuery(sql, paramMap);
        if (resultList == null || resultList.isEmpty()) {
            return count;
        }
        for (Map<String, Object> map : resultList) {
            count = map.get("count") == null ? 0 : Integer.valueOf(map.get("count").toString());
            break;
        }
        return count;
    }
}
