package gr.codehub.teamOne.router;

import gr.codehub.teamOne.resource.impl.MeasurementsResourceImpl;
import gr.codehub.teamOne.resource.impl.PatientResourceImpl;
import gr.codehub.teamOne.resource.impl.PingServerResourceImpl;
import org.restlet.Application;
import org.restlet.routing.Router;

public class PatientRouter {

    private Application application;

    public PatientRouter(Application application) {
        this.application = application;
    }

    public Router createApiRouter() {

        Router router = new Router(application.getContext());
        router.attach("/measurements", MeasurementsResourceImpl.class);
        router.attach("/patients", PatientResourceImpl.class);

        router.attach("/ping", PingServerResourceImpl.class);

        return router;
    }
}
