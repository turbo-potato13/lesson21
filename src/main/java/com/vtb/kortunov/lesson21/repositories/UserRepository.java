package com.vtb.kortunov.lesson21.repositories;

import com.vtb.kortunov.lesson21.PrepareFactory;
import com.vtb.kortunov.lesson21.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class UserRepository {

    private final PrepareFactory factory;

    @Autowired
    public UserRepository(PrepareFactory factory) {
        this.factory = factory;
    }

    public void save(User user) {
        factory.getSession().beginTransaction();
        Query query = factory.getSession().createQuery("INSERT INTO User (name, age) SELECT :name , :age FROM User");
        query.setParameter("name", user.getName());
        query.setParameter("age", user.getAge());
        query.executeUpdate();
        factory.getSession().getTransaction().commit();
        factory.getSession().close();
    }

    public User get(Long id) {
        factory.getSession().beginTransaction();
        User user = factory.getSession().get(User.class, id);
        factory.getSession().getTransaction().commit();
        factory.getSession().close();
        return user;
    }

    public List<User> getAll() {
        factory.getSession().beginTransaction();
        List<User> users = factory.getSession().createQuery("SELECT u FROM User u", User.class).getResultList();
        factory.getSession().getTransaction().commit();
        factory.getSession().close();
        return users;
    }
}
