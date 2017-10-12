package com.springapp.mvc.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
/*
    private static Session session;
    private static Configuration configuration;
/*
    static {
        configuration = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/dance")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "dmitruk")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addAnnotatedClass(model.Man.class)
                .addAnnotatedClass(model.Woman.class)
                .addAnnotatedClass(model.Dance.class)
                .addAnnotatedClass(model.Style.class);
    }


    public static Session getSession() {

        SessionFactory factory = configuration.buildSessionFactory();
        session = factory.openSession();
        return session;
    }
    */

}
