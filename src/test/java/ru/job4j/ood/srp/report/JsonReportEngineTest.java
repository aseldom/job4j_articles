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

public class JsonReportEngineTest {

    @Test
    public void jsonReportTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan", now, now, 300));
        employees.add(new Employee("Oleg", now, now, 200));
        employees.add(new Employee("Mihail", now, now, 100));
        employees.forEach(store::add);
        String delimiter = "\n";
        Report engine = new JsonReportEngine(store, parser);
        StringBuilder expect = new StringBuilder().append("[");
        for (Employee employee : employees) {
            expect.append(delimiter)
                    .append("  {").append(delimiter)
                    .append("    \"name\": \"").append(employee.getName())
                    .append("\",").append(delimiter)
                    .append("    \"hired\": \"").append(parser.parse(employee.getHired()))
                    .append("\",").append(delimiter)
                    .append("    \"fired\": \"").append(parser.parse(employee.getFired()))
                    .append("\",").append(delimiter)
                    .append("    \"salary\": ").append(employee.getSalary())
                    .append(delimiter)
                    .append("  },");
        }
        expect.deleteCharAt(expect.length() - 1).append(delimiter).append("]");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}