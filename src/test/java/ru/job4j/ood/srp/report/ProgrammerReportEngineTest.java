package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgrammerReportEngineTest {

    @Test
    public void programmerReportTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        List<Employee> employees = new ArrayList<>();
        String delimiter = "\r\n";
        employees.add(new Employee("Ivan", now, now, 300));
        employees.add(new Employee("Oleg", now, now, 200));
        employees.add(new Employee("Mihail", now, now, 100));
        store.add(employees.get(0));
        store.add(employees.get(1));
        store.add(employees.get(2));
        Report engine = new ProgrammerReportEngine(store, parser);
        StringBuilder expect = new StringBuilder().append("Name,Hired,Fired,Salary");
        for (Employee employee : employees) {
            expect.append(delimiter)
                    .append(employee.getName()).append(",")
                    .append(parser.parse(employee.getHired())).append(",")
                    .append(parser.parse(employee.getFired())).append(",")
                    .append(employee.getSalary());
        }
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}