package com.kavli.dao.impl;

import com.kavli.core.base.jdbc.impl.AbstractJdbcDaoImpl;
import com.kavli.core.exception.DaoException;
import com.kavli.dao.IEnterpriseDao;
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
public class EnterpriseDaoImpl extends AbstractJdbcDaoImpl implements IEnterpriseDao {
    @Override
    public String getEnterpriseName(Long enterpriseId) throws DaoException{
        String name= null;
        String sql = "select e.name from enterprise e where e.enterprise_id=:enterprise_id";

        Map<String, Object> paramMap = new HashedMap();
        StringBuilder conditions = new StringBuilder();
        /*if (StringUtil.isNotBlank(appId)) {
            conditions.append(" AND w.appid=:app_id ");
            paramMap.put("app_id", appId);
        }*/
        paramMap.put("enterprise_id", 1l);

        sql = sql.replace("[condition]", conditions.toString());
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
    public Long insert() throws DaoException{

        String sqlStr = "INSERT INTO comment (enterprise_id, customer_id, transaction_order_id, state, create_time, expired_time)\n" +
                "\t\t\t\t\t\tVALUES (:enterprise_id, :customer_id, :transaction_order_id, :state, :create_time, :expired_time)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("enterprise_id", 3);
        paramSource.addValue("customer_id", 243);
        paramSource.addValue("transaction_order_id", 122);
        paramSource.addValue("state", 0);
        paramSource.addValue("create_time", new Date());
        paramSource.addValue("expired_time", new Date());
        this.executeJdbcUpdate(sqlStr, paramSource, keyHolder);
        Long id = (Long) keyHolder.getKey();
        System.out.println("id="+id);
        return id;
    }
}
