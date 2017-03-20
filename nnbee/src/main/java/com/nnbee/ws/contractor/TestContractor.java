package com.nnbee.ws.contractor;


import com.nnbee.core.base.ws.service.BaseRestService;
import com.nnbee.core.base.ws.vo.GenericResponseVO;
import com.nnbee.core.exception.ServiceException;
import com.nnbee.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by lzylz on 2017/3/19.
 */
@Named
@Path("/test")
@WebService
public class TestContractor extends BaseRestService {
    @Inject
    private IUserService userService;
    Logger logger = LoggerFactory.getLogger("main_logger");
    @Path("get_count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response test(@QueryParam("param") String msg){
        try {
            logger.info("msg="+msg);
            Integer count = userService.getUserCount(1L);
            logger.info("msg="+msg+count);
            return setResponseData(new GenericResponseVO("msg="+msg+count));
        } catch (ServiceException e) {
            return setErrorInfoResponse(e);
        }
    }
}
