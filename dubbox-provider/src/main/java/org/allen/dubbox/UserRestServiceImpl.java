package org.allen.dubbox;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.allen.dubbox.api.ApiResponseDTO;
import org.allen.dubbox.api.User;
import org.allen.dubbox.api.UserRestService;

import javax.ws.rs.*;

@Path("users")
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class UserRestServiceImpl implements UserRestService {

    @GET
    @Path("{id : \\d+}")
    public ApiResponseDTO getUser(@PathParam("id") Long id) {
        System.out.println("#### [/users/get] id: " + id);
        User user = new User(id, "username_" + id);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO().setRetCode("00").setRetMsg("Success").setData(user);
        return apiResponseDTO;
    }
}
