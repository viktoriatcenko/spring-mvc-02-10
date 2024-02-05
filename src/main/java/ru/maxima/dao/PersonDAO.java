package ru.maxima.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.model.Person;

import java.util.List;

@Component
public class PersonDAO {
    // DAO - data access object - доступ к данным объектов

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Аннотация скажет hibernate, что мы ничего не будем сохранять
    @Transactional
    public List<Person> getAllPeople() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Person", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person findById(Long id) {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Transactional
    public void update(Long id, Person editedPerson) {
        Person person = sessionFactory.getCurrentSession().get(Person.class, id);
        person.setName(editedPerson.getName());
        person.setAge(editedPerson.getAge());
        person.setEmail(editedPerson.getEmail());
    }

    @Transactional
    public void deleteById(Long id) {
        sessionFactory.getCurrentSession().remove(sessionFactory.getCurrentSession().get(Person.class, id));
    }

    public void upgradeToAdmin(Person person) {
//        jdbcTemplate.update("update person set admin = true where id = ? ",
//                 person.getId());
    }
}
