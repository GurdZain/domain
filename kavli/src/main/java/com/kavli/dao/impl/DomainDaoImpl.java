package com.kavli.dao.impl;

import com.kavli.core.base.jdbc.impl.AbstractJdbcDaoImpl;
import com.kavli.core.exception.DaoException;
import com.kavli.core.utils.JdbcNameQuery;
import com.kavli.dao.IDomainDao;
import com.kavli.dao.IEnterpriseDao;
import com.kavli.domain.DomainResult;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/8.
 */
public class DomainDaoImpl extends AbstractJdbcDaoImpl implements IDomainDao {
    @Override
    public String getLastDomain(Long id) throws DaoException{
        String name= null;
        String sql = JdbcNameQuery.getQueryByName("GET_LAST_QUERY_BY_ID");

        Map<String, Object> paramMap = new HashedMap();
        StringBuilder conditions = new StringBuilder();
        paramMap.put("id", id);
        List<Map<String, Object>> resultList = executeJdbcQuery(sql, paramMap);
        if (resultList == null || resultList.isEmpty()) {
            return null;
        }
        for (Map<String, Object> map : resultList) {
            name = map.get("name") == null ? null : map.get("name").toString();
            break;
        }
        return name;
    }

    @Override
    public int insertNewDomain(DomainResult result) throws DaoException {
        String sqlStr = JdbcNameQuery.getQueryByName("INSERT_VALID_DOMAIN");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", result.getClassKey());
        paramMap.put("price", result.getPrice());
        paramMap.put("is_premium", result.getPremium());
        paramMap.put("create_time", result.getDate());
        return this.executeJdbcUpdate(sqlStr, paramMap);
    }

    @Override
    public int updateLastDomain(Long id, String name) throws DaoException {
        String sqlStr = JdbcNameQuery.getQueryByName("UPDATE_LAST_DOMAIN");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("name", name);
        return this.executeJdbcUpdate(sqlStr, paramMap);
    }

}
