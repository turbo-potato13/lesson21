package com.vtb.kortunov.lesson21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class PrepareFactory {
    private final SessionFactory factory;

    public PrepareFactory() {
        this.factory = buildSessionFactory();
    }

    private SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void shutdown() {
        factory.close();
    }

}
