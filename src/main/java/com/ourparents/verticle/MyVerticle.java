package com.ourparents.verticle;

import com.google.inject.Guice;
import com.ourparents.module.MyModule;
import com.ourparents.service.GeocodeService;
import com.ourparents.util.ConfigLoader;
import com.ourparents.util.JooqContext;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.dropwizard.DropwizardMetricsOptions;
import io.vertx.ext.dropwizard.Match;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;


/**
 * Created by ASales on 3/11/2016.
 */
public class MyVerticle extends AbstractVerticle {

    private static final Logger logger = LoggerFactory.getLogger(MyVerticle.class);


    public static final String AUTOCOMPLETE_URL = "/helloworld";

    @Inject
    private JooqContext jooqContext;

    @Inject
    private GeocodeService geocodeService;

    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setMetricsOptions(
                new DropwizardMetricsOptions().
                        setEnabled(true).
                        setJmxEnabled(true).
                        setJmxDomain("core").
                        setRegistryName("core").
                        addMonitoredHttpServerUri(
                                new Match().setValue(AUTOCOMPLETE_URL))
        ));
        vertx.deployVerticle(MyVerticle.class.getName());
    }

    @Override
    public void start() throws Exception {
        logger.info("Starting application..");
        Guice.createInjector(new MyModule(vertx)).injectMembers(this);

        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        router.get(AUTOCOMPLETE_URL).handler(this::handleHelloWorld);

        vertx.createHttpServer().requestHandler(router::accept).listen(ConfigLoader.port);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
//        jooqContext.destroy();
    }

    public void handleHelloWorld(RoutingContext routingContext) {
        routingContext.response().putHeader("content-type", "plain/text").end("HELLOWORLD!!");
    }

}
