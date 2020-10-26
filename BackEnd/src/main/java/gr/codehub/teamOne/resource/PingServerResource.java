package gr.codehub.teamOne.resource;

import gr.codehub.teamOne.exceptions.NotFoundException;
import org.restlet.resource.Get;

public interface PingServerResource {

    @Get("txt")
    public String ping() throws NotFoundException;
}
