package spelling.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class SpellCheckerServerApplication extends Application {

    // this isn't needed when deploying within proper environment (Tomcat, etc), I'm just lazy
    private static final String BASE = "http://localhost:8182";

    public static void main(String[] args) throws Exception {
        Server server = new Server(Protocol.HTTP, 8182);
        server.setNext(new SpellCheckerServerApplication());
        server.start();
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach(BASE + "/spellchecker/{word}", WordManagerResource.class);

        return router;
    }

}
