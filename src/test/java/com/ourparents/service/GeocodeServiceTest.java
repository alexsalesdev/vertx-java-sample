package com.ourparents.service;

import io.vertx.test.core.VertxTestBase;

/**
 * Created by ASales on 3/14/2016.
 */
public class GeocodeServiceTest extends VertxTestBase {
//    private GeocodeService classForTest;
//    private DSLContext dsl;
//    private JooqContext jooqContext;
//
//    private static String dbUrl;
//    private static String dbUser;
//    private static String dbPassword;
//    private static String sqlLocation;
//
//    ReportOptions consoleReport = new ReportOptions().
//            setTo("console");
//
//    @BeforeClass
//    public static void beforeClass() {
//        Config config = ConfigFactory.load("test.application.conf");
//        dbUrl = config.getString("db.url");
//        dbUser = config.getString("db.user");
//        dbPassword = config.getString("db.password");
//        sqlLocation = config.getString("db.sql.1");
//    }
//
//    @Test
//    public void testAutoCompleteTerm() {
//        TestSuite suite = TestSuite.create("GeocodeService simple data test suite");
//
//        suite.before(context -> {
//            JdbcDataSource ds = new JdbcDataSource();
//            ds.setURL(dbUrl);
//            ds.setUser(dbUser);
//            ds.setPassword(dbPassword);
//
//            try {
//                Connection conn = ds.getConnection();
//                RunScript.execute(conn, new InputStreamReader(this.getClass().getResourceAsStream(sqlLocation)));
//                jooqContext = new JooqContext(conn);
//                classForTest = new GeocodeService(jooqContext);
//                dsl = jooqContext.getDsl();
//
//                GeocodesRecord geocodesRecord = dsl.newRecord(Geocodes.GEOCODES);
//                geocodesRecord.setNameKey("texas");
//                geocodesRecord.setLocation("Texas");
//                geocodesRecord.setPriority(10);
//                geocodesRecord.store();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }).test("autocomplete simple data test", context -> {
//            final List<com.ourparents.db.tables.pojos.Geocodes> geocodes = classForTest.autocompleteTerm("Te");
//
//            context.assertEquals(1, geocodes.size());
//            context.assertEquals("Texas", geocodes.get(0).getLocation());
//        }).test("autocomplete term did not match data", context -> {
//            final List<com.ourparents.db.tables.pojos.Geocodes> geocodes = classForTest.autocompleteTerm("Me");
//            context.assertEquals(0, geocodes.size());
//        }).after(context -> {
//            try {
//                jooqContext.destroy();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//        suite.run(new TestOptions().addReporter(consoleReport));
//
//    }
//
//    @Test
//    public void testAutoCompleteTermMultipleData() {
//        TestSuite suite = TestSuite.create("GeocodeService multiple data test suite");
//
//        suite.before(context -> {
//            JdbcDataSource ds = new JdbcDataSource();
//            ds.setURL(dbUrl);
//            ds.setUser(dbUser);
//            ds.setPassword(dbPassword);
//
//            try {
//                Connection conn = ds.getConnection();
//                RunScript.execute(conn, new InputStreamReader(this.getClass().getResourceAsStream(sqlLocation)));
//                jooqContext = new JooqContext(conn);
//                classForTest = new GeocodeService(jooqContext);
//                dsl = jooqContext.getDsl();
//
//                GeocodesRecord texas = dsl.newRecord(Geocodes.GEOCODES);
//                texas.setNameKey("texas");
//                texas.setLocation("Texas");
//                texas.setPriority(6228);
//                texas.store();
//
//                GeocodesRecord tennessee = dsl.newRecord(Geocodes.GEOCODES);
//                tennessee.setNameKey("tennessee");
//                tennessee.setLocation("Tennessee");
//                tennessee.setPriority(1511);
//                tennessee.store();
//
//                GeocodesRecord texascountymo = dsl.newRecord(Geocodes.GEOCODES);
//                texascountymo.setNameKey("texascountymo");
//                texascountymo.setLocation("Texas County, MO");
//                texascountymo.setPriority(124);
//                texascountymo.store();
//
//                GeocodesRecord tensascountyla = dsl.newRecord(Geocodes.GEOCODES);
//                tensascountyla.setNameKey("tensascountyla");
//                tensascountyla.setLocation("Tensas County, LA");
//                tensascountyla.setPriority(123);
//                tensascountyla.store();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }).test("autocomplete multiple data test", context -> {
//            final List<com.ourparents.db.tables.pojos.Geocodes> geocodes = classForTest.autocompleteTerm("Te");
//
//            context.assertEquals(4, geocodes.size());
//            context.assertEquals("Texas", geocodes.get(0).getLocation());
//            context.assertEquals("Tennessee", geocodes.get(1).getLocation());
//            context.assertEquals("Texas County, MO", geocodes.get(2).getLocation());
//            context.assertEquals("Tensas County, LA", geocodes.get(3).getLocation());
//        }).test("autocomplete term did not match multiple data", context -> {
//            final List<com.ourparents.db.tables.pojos.Geocodes> geocodes = classForTest.autocompleteTerm("ex");
//            context.assertEquals(0, geocodes.size());
//        }).after(context -> {
//            try {
//                jooqContext.destroy();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//        suite.run(new TestOptions().addReporter(consoleReport));
//
//    }
//
//    @Test
//    public void testAutoCompleteTermIfEmpty() {
//        TestSuite suite = TestSuite.create("GeocodeService empty data test suite");
//
//        suite.before(context -> {
//            JdbcDataSource ds = new JdbcDataSource();
//            ds.setURL(dbUrl);
//            ds.setUser(dbUser);
//            ds.setPassword(dbPassword);
//
//            try {
//                Connection conn = ds.getConnection();
//
//                RunScript.execute(conn, new InputStreamReader(this.getClass().getResourceAsStream(sqlLocation)));
//                jooqContext = new JooqContext(conn);
//                classForTest = new GeocodeService(jooqContext);
//                dsl = jooqContext.getDsl();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }).test("autocomplete empty data test", context -> {
//            final List<com.ourparents.db.tables.pojos.Geocodes> geocodes = classForTest.autocompleteTerm("Te");
//
//            context.assertEquals(0, geocodes.size());
//        }).after(context -> {
//            try {
//                jooqContext.destroy();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//        suite.run(new TestOptions().addReporter(consoleReport));
//    }
}
