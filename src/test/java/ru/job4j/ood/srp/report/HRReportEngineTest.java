package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HRReportEngineTest {

    @Test
    public void hRReportTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Comparator<Employee> comparator = Comparator.comparingDouble(Employee::getSalary).reversed();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan", now, now, 300));
        employees.add(new Employee("Oleg", now, now, 200));
        employees.add(new Employee("Mihail", now, now, 100));
        employees.forEach(store::add);
        Report engine = new HRReportEngine(store, comparator);
        StringBuilder expect = new StringBuilder().append("Name; Salary;");
        for (Employee employee : employees) {
            expect.append(System.lineSeparator())
                    .append(employee.getName()).append(" ")
                    .append(employee.getSalary());
        }
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}