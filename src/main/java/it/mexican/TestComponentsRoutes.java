package it.mexican;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.cdi.Uri;

/**
 * Configures all our Camel routes, components, endpoints and beans
 */
@ContextName("test-components")
public class TestComponentsRoutes extends RouteBuilder {

    @Inject
    @Uri("timer:foo?period=5000")
    private Endpoint inputEndpoint;

    @Inject
    @Uri("log:output")
    private Endpoint resultEndpoint;

    @Override
    public void configure() {
        // you can configure the route rule with Java DSL here

        from(inputEndpoint)
                .id("test-components-route")
                .log(LoggingLevel.TRACE, "Dummy TRACE log")
                .log(LoggingLevel.DEBUG, "Dummy DEBUG log")
                .log(LoggingLevel.INFO, "Dummy INFO log")
                .log(LoggingLevel.WARN, "Dummy WARN log")
                .log(LoggingLevel.ERROR, "Dummy ERROR log")
                .stop();
    }

}
