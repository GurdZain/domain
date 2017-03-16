package com.kavli.service;

import com.kavli.core.exception.DaoException;
import com.kavli.core.utils.DateUtil;
import com.kavli.dao.IDomainDao;
import com.kavli.dao.impl.DomainDaoImpl;
import com.kavli.domain.DomainResult;
import com.kavli.main.IMainService;
import com.kavli.tools.HttpUtils;
import net.sf.json.JSONObject;

import java.util.Date;

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
            String last = domainDao.getLastDomain(1L);
            if (last == null) {
                last = "aaaa";
            }
            int index=0;
            while (index++ < 10000) {
                System.out.println(index+" "+ DateUtil.parseDateToString(new Date(), DateUtil.sdf_bidStatus)+":skip host:"+last+".com");
                //JSONObject result = HttpUtils.getJsonHtml("http://cnz.co/domain-registration/domain.php?action=caajax&domain_name="+last+".com");
                HttpUtils.HttpUtilsResult htmlResult = HttpUtils.getHtml("http://cnz.co/domain-registration/domain.php?action=caajax&domain_name="+last+".com");
                if (htmlResult.errorCode == HttpUtils.HttpUtilsResult.ERR_NONE) {
                    JSONObject result = JSONObject.fromObject(htmlResult.htmlBody);

                    if (result != null  ) {
                        if (result.get("status").equals("available")) {
                            DomainResult newDomain = new DomainResult();
                            newDomain.setDate(new Date());
                            newDomain.setClassKey(last);
                            if (result.getString("price") != null) {
                                newDomain.setPrice(Double.valueOf(result.getString("price")));
                            }
                            if (result.getString("is_premium") != null) {
                                newDomain.setPremium(result.getString("is_premium").equalsIgnoreCase("true") ? 1 : 0);
                            }
                            domainDao.insertNewDomain(newDomain);
                            System.out.println("    get available host:" + last + ".com, price=" + newDomain.getPrice() + ",is_premium:" + (newDomain.getPremium() == 1));
                        }
                    } else {
                        System.out.println(htmlResult.errorInfo);
                    }
                    last = generateString(last);
                    domainDao.updateLastDomain(1L, last);
                    Thread.sleep(2000L);
                } else {
                    System.out.println(htmlResult.errorInfo);
                }
            }
            //http://cnz.co/domain-registration/domain.php?action=caajax&domain_name=dddddbasidu.com
            /*System.out.println(PropertyUtil.get("ewf"));
            System.out.println(JdbcNameQuery.getQueryByName("INSERT_TRANSACTION_ORDER"));*/
            //System.out.println(enterpriseDao.insert());
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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
            result=result*26+(c[i]-'a');
            //System.out.println(result);
        }
        //System.out.println(result);
        result+=1;
        StringBuilder s=new StringBuilder();
        while (result>=0) {
            char r= (char) ('a'+result%26);
            s.insert(0, r);
            result=result/26;
            if (result==0 && s.length()>=c.length) {
                break;
            }
        }
        return s.toString();
    }
}
