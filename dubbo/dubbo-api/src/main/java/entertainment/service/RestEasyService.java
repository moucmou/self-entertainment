package entertainment.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @author AmazingZ
 * @date 2019/5/24 17:11
 */
@Path("resteasy")
public interface RestEasyService {
    @POST
    @Path("echo")
    @Consumes({MediaType.APPLICATION_JSON})
    String echo(String repeat);
}
