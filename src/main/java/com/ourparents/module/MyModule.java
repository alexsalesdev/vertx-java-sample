package com.ourparents.module;

import com.google.inject.AbstractModule;
import com.ourparents.service.GeocodeService;
import com.ourparents.util.JooqContext;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

/**
 * Created by ASales on 3/14/2016.
 */
public class MyModule extends AbstractModule {
    private static final Logger logger = LoggerFactory.getLogger(MyModule.class);

    private final Vertx vertx;
    private final Context context;

    public MyModule(Vertx vertx) {
        this.vertx = vertx;
        this.context = vertx.getOrCreateContext();
    }

    @Override
    protected void configure() {
        logger.info("configuring module {}", MyModule.class.getName());

        bind(JooqContext.class).in(Singleton.class);
        bind(GeocodeService.class).in(Singleton.class);
    }
}
