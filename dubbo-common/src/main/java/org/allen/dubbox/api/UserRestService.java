package org.allen.dubbox.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("users")
public interface UserRestService {

    @GET
    @Path("{id : \\d+}")
    ApiResponseDTO getUser(@PathParam("id") Long id);
}
