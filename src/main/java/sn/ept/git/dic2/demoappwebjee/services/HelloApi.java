package sn.ept.git.dic2.demoappwebjee.services;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.*;

@Path("/hello")
public class HelloApi {
    @GET
    @Produces({
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_JSON
    })
    @Consumes({
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_JSON
    })
    public Salutation salut(){
        return Salutation.builder()
                .langue("Francais")
                .msg("Bonjour")
                .build();
    }
}