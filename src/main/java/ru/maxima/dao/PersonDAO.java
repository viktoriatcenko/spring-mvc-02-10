package ru.maxima.dao;

import org.springframework.stereotype.Component;
import ru.maxima.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    // DAO - data access object - доступ к данным объектов

//    private List<Person> people = new ArrayList<>();
    private static Long PEOPLE_COUNT = 0L;
    private List<Person> people;

    {

        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Damir", 17, "damir@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Airat", 25, "airat@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Maxim", 27, "maxim@mail.ru"));
    }


    public List<Person> getAllPeople() {
        return people;
    }

    public Person findById(Long id) {
        return people.stream()
                .filter(person -> person.getId().equals(id))
                .findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(Long id, Person editedPerson) {
        Person personToBeUpdated = findById(id);
        personToBeUpdated.setName(editedPerson.getName());
        personToBeUpdated.setAge(editedPerson.getAge());
        personToBeUpdated.setEmail(editedPerson.getEmail());
    }

    public void deleteById(Long id) {
//        Person personToBeDeleted = findById(id);
//        people.remove(personToBeDeleted);
        people.removeIf(p -> p.getId().equals(id));
    }
}
