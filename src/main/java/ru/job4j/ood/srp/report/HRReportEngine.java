package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRReportEngine implements Report {

    private final Store store;
    private final Comparator<Employee> comparator;

    public HRReportEngine(Store store, Comparator<Employee> comparator) {
        this.store = store;
        this.comparator = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> employees = store
                .findBy(filter)
                .stream()
                .sorted(comparator)
                .toList();
        text.append("Name; Salary;");
        for (Employee employee : employees) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(" ")
                    .append(employee.getSalary());
        }
        return text.toString();
    }
}