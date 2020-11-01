package gr.codehub.teamOne.resource.interfaces;

import gr.codehub.teamOne.exceptions.NotFoundException;
import org.restlet.resource.Get;

public interface PingServerResource {

    @Get("txt")
    String ping() throws NotFoundException;
}
