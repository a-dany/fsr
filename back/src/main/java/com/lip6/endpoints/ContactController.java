package com.lip6.endpoints;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.PostMapping;
import com.lip6.dtos.Contact;
import com.lip6.dtos.PhoneNumber;
import com.lip6.services.ContactService;

// @Controller
// @RestController @RequestMapping("/contacts")
@Path("/contacts")
public class ContactController {


    /***| INIT |***/
    
    // private final IContactService service;
    private ContactService service;
    
    // @Autowired
    public ContactController() {
        this.service = new ContactService();
    }

    
    /***| ENDPOINTS |***/
    
    @GET 
    @Produces({MediaType.APPLICATION_JSON})
    public List<Contact> getAll() {
        return this.service.getAll();   
    }

    @GET @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response get(@PathParam("id") Long id) {
        return this.service.get(id).map(Response::ok).orElse(Response.status(404)).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @PostMapping()
    public Response create(Contact contact) {
        return Response.status(
            this.service.save(contact) ? 204 : 500
        ).build();
    }

    @DELETE @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") Long id) {
        return Response.status(
            this.service.delete(id) ? 201 : 500
        ).build();
    }


    /***| PHONE NUMBERS |***/

    @POST @Path("/{id}/phone_numbers/add")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addPhoneNumber(@PathParam("id") Long id, PhoneNumber pn) {
        // this.contact.addPhoneNumber(id, pn);
        return Response.ok("Not implemented yet").build();
    }

    // TODO : UPDATE PHONE_NUMBERS { ADD + REMOVE }
    // TODO : UPDATE ADDRESS { CHANGE VALUES }
    
}
