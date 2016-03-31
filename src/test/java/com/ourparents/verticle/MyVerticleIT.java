package com.ourparents.verticle;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ASales on 3/15/2016.
 */
@RunWith(VertxUnitRunner.class)
public class MyVerticleIT {
    private static final Logger logger = LoggerFactory.getLogger(MyVerticleIT.class);
    private Vertx vertx;

    private ObjectMapper om = new ObjectMapper();

    @Before
    public void before(TestContext context) {
        vertx = Vertx.vertx();
    }

    @After
    public void after(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void testAutocompleteUrl(TestContext context) {
        vertx.deployVerticle(MyVerticle.class.getName(), context.asyncAssertSuccess(deploymentID -> {
            HttpClient client = vertx.createHttpClient();
            Async async = context.async();
            client.getNow(8080, "localhost", "/helloworld", resp -> {
                resp.bodyHandler(body -> {
                    logger.info(body.toString());
                    context.assertEquals(body.toString(), "HELLOWORLD!!");
                    client.close();
                    async.complete();
                });
            });
        }));
    }
}
