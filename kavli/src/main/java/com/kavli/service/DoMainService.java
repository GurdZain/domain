package com.kavli.service;

import com.kavli.core.exception.DaoException;
import com.kavli.core.utils.JdbcNameQuery;
import com.kavli.core.utils.PropertyUtil;
import com.kavli.dao.IDomainDao;
import com.kavli.dao.IEnterpriseDao;
import com.kavli.dao.impl.DomainDaoImpl;
import com.kavli.dao.impl.EnterpriseDaoImpl;
import com.kavli.main.IMainService;

/**
 * Created by Administrator on 2017/3/7.
 */
public class DoMainService implements IMainService{
    private IDomainDao domainDao;
    public void init(String[] conf) {
        domainDao = new DomainDaoImpl();
    }

    public void serve() {
        try {
            //http://cnz.co/domain-registration/domain.php?action=caajax&domain_name=dddddbasidu.com
            System.out.println(domainDao.getLastDomain(1L));
            /*System.out.println(PropertyUtil.get("ewf"));
            System.out.println(JdbcNameQuery.getQueryByName("INSERT_TRANSACTION_ORDER"));*/
            //System.out.println(enterpriseDao.insert());
            System.out.println(generateString("caab"));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private String generateString(String start){
        if (start == null) {
            return "aaaa";
        }
        char[] c = start.toCharArray();
        int result=0;
        for (int i=0;i<c.length;i++) {
            result=result*26*i+(c[i]-'a');
        }
        System.out.println(result);
        result+=1;
        StringBuilder s=new StringBuilder();
        while (result>=0) {
            char r= (char) ('a'+result%26);
            s.insert(0, r);
            result=result/26;
            if (result==0) {
                break;
            }
        }
        return s.toString();
    }
}
