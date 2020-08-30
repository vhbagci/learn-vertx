package com.github.vhbagci.learn_vertx;

import com.github.vhbagci.learn_vertx.util.VertxRunner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  private static final String DIRECTORY = "learn-vertx/src/main/java/" + MainVerticle.class.getName().replace(".", "/");

  // Convenience method so you can run it in your IDE
  public static void main(String[] args) {
    VertxRunner.run(DIRECTORY, MainVerticle.class.getName(), new VertxOptions().setClustered(false), null);
  }

  @Override
  public void start(Promise<Void> startPromise) {
    Router router = Router.router(vertx);
    router.route().handler(routingContext ->
            routingContext.response().putHeader("content-type", "text/html").end("Hello World!"));
    vertx.createHttpServer().requestHandler(router).listen(8888);
  }
}
