package com.airhacks.enhydrator;

import com.airhacks.enhydrator.in.Source;
import com.airhacks.enhydrator.out.JDBCSink;
import com.airhacks.enhydrator.out.Sink;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author airhacks.com
 */
public class CopyTableTest {

    Source source;
    Sink sink;

    @Before
    public void initialize() {
        Persistence.generateSchema("to", null);
        Persistence.generateSchema("from", null);
        this.source = new Source.Configuration().
                driver("org.apache.derby.jdbc.EmbeddedDriver").
                url("jdbc:derby:./coffees;create=true").
                newSource();
        this.sink = new JDBCSink.Configuration().
                driver("org.apache.derby.jdbc.EmbeddedDriver").
                url("jdbc:derby:./targetDB;create=true").
                targetTable("DEVELOPER_DRINK").
                newSink();

    }

    @Test
    public void plainCopy() {
        CoffeeTestFixture.insertCoffee("arabica", 2, "hawai", Roast.LIGHT, "nice", "whole");
        CoffeeTestFixture.insertCoffee("niceone", 3, "russia", Roast.MEDIUM, "awful", "java beans");
        new Driver.Drive().
                from(this.source).
                to(this.sink).
                go("select * from Coffee");
    }

    @After
    public void cleanupConnections() {

    }

}
