package com.ourparents.util;

import com.google.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ASales on 3/14/2016.
 */
public class JooqContext {

    private static final Logger logger = LoggerFactory.getLogger(JooqContext.class);

    private Connection conn;
    private DSLContext dslContext;



    @Inject
    public JooqContext() {
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try {
            logger.info("JooqContext database connecting to [{}]", ConfigLoader.url);
            logger.info("JooqContext db dialect [{}]", ConfigLoader.dialect);
            logger.info("JooqContext db username [{}]", ConfigLoader.user);
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(ConfigLoader.url, ConfigLoader.user, ConfigLoader.password);
            dslContext = DSL.using(conn, SQLDialect.valueOf(ConfigLoader.dialect));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JooqContext(Connection connection) {
        this.conn = connection;
        dslContext = DSL.using(connection, SQLDialect.MYSQL);
    }

    public void destroy() throws SQLException {
        conn.close();
        logger.info("Connection to the database was closed.");
    }

    public DSLContext getDsl() {
        return dslContext;
    }
}
