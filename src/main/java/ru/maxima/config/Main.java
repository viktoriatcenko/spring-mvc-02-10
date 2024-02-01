package ru.maxima.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.maxima.model.Citizen;
import ru.maxima.model.Order;
import ru.maxima.model.Passport;
import ru.maxima.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Citizen.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Person.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Citizen citizen = new Citizen("Damir", 25);
            Passport passport = new Passport(citizen, 123456);

            citizen.setPassport(passport);

            session.save(citizen);
            session.save(passport);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

        //            Person person = session.get(Person.class, 3L);
//
//            System.out.println(person.getEmail());
//            System.out.println(person.getName());


//            Person person = new Person(6L, "Test", 32, "mail.ru", true);
//
//            session.save(person);

//            Person person1 = new Person("Test1", 55);
//            Person person2 = new Person("Test2", 66);
//            Person person3 = new Person("Test3", 77);
//            Person person4 = new Person("Test4", 88);
//
//            session.save(person1);
//            session.save(person2);
//            session.save(person3);
//            session.save(person4);

//            Person person = session.get(Person.class, 10L);
//
//            System.out.println(person.getEmail());
//            System.out.println(person.getName());

//            List<Person> people = session.createQuery("from Person where age > 30 and name like 'Test%'").getResultList();
//
//            people.forEach(p -> System.out.println(p.getName()));

//        Person person = session.get(Person.class, 4L);
//
//        List<Order> orders = person.getOrders();
//
//        orders.forEach(System.out::println);

        //
//            Person owner = session.get(Person.class, 3);
//
//            Order order = new Order("Yacht", owner);
//
//            session.save(order);
//
//
//
//            System.out.println(owner);

//        Order order = new Order("Iphone 12 pro Max", person);
//
//        person.setOrders(new ArrayList<>(Collections.singletonList(order)));
//
//        session.save(order);
//
//        session.save(person);


//        person.setName("Maxim1121212");
//
//        session.save(person);

//        List<Order> orders = person.getOrders();
//
//        // Даю Hibernate команду удалить при отправке commit()
//        // все на уровне SQL
//        orders.forEach(session::remove);
//
//        // SQL команды не делаю, удаляю на уровне кэша, так же подтверждаю ему, что нужно удалить
//        person.getOrders().clear();

        //            List<Order> orders = person.getOrders();
//
//            // Даю Hibernate команду удалить при отправке commit()
//            // все на уровне SQL
//            orders.forEach(session::remove);
//
//            // SQL команды не делаю, удаляю на уровне кэша, так же подтверждаю ему, что нужно удалить
//            orders.clear();
    }
}
