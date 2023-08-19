package ru.job4j.ood.srp.store;

import ru.job4j.ood.srp.model.Employee;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.function.Predicate;

@XmlRootElement
public interface Store {
    void add(Employee em);

    @XmlElement(name = "employee")
    List<Employee> findBy(Predicate<Employee> filter);
}