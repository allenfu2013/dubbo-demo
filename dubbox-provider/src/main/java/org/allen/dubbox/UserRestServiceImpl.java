package org.allen.dubbox;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.allen.dubbox.api.User;
import org.allen.dubbox.api.UserRestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("users")
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class UserRestServiceImpl implements UserRestService {

    @GET
    @Path("get")
    public User getUser(@QueryParam("id")Long id) {
        System.out.println("#### [/users/get] id: " + id);
        User user = new User(id, "username_" + id);
        return user;
    }
}
