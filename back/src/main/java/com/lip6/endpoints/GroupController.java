package com.lip6.endpoints;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.lip6.services.GroupService;

@Path("/groups")
public class GroupController {

    /***| INIT |***/

    private GroupService groups;
    public GroupController() { this.groups = new GroupService(); }


    /***| ENDPOINTS |***/

    @POST 
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response create(String name) {
        return Response.status(
            this.groups.save(name) ? 204 : 500
        ).build();
    }

    @GET @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response get(@PathParam("id") Long id) {
        return this.groups.get(id).map(Response::ok).orElse(Response.status(404)).build();
    }

    @DELETE @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") Long id) {
        return Response.status(
            this.groups.delete(id) ? 204 : 500
        )
        .build();
    }

    @PATCH @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})    
    public Response update(@PathParam("id") Long id, String name) {
        return Response.status(
            this.groups.update(id, name) ? 204 : 500
        )
        .build();
    }

    /***| ADD AND REMOVE CONTACTS |***/

    @POST @Path("/{id}/contacts/add")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addContacts(@PathParam("id") Long id, List<Long> ids) {
        return Response.status(
            this.groups.addContacts(id, ids) ? 204 : 500
        )
        .build();
    }

    @POST @Path("/{id}/contacts/remove")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response removeContacts(@PathParam("id") Long id, List<Long> ids) {
        return Response.status(
            this.groups.removeContacts(id, ids) ? 204 : 500
        )
        .build();
    }

}
