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

public class XmlReportEngineTest {

    @Test
    public void xmlReportTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan", now, now, 300));
        employees.add(new Employee("Oleg", now, now, 200));
        employees.add(new Employee("Mihail", now, now, 100));
        employees.forEach(store::add);
        String delimiter = "\n";
        Report engine = new XmlReportEngine(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(delimiter).append("<employees>");
        for (Employee employee : employees) {
            expect.append(delimiter).append("    <employee>").append(delimiter)
                    .append("        <name>").append(employee.getName())
                    .append("</name>").append(delimiter)
                    .append("        <hired>").append(parser.parse(employee.getHired()))
                    .append("</hired>").append(delimiter)
                    .append("        <fired>").append(parser.parse(employee.getFired()))
                    .append("</fired>").append(delimiter)
                    .append("        <salary>").append(employee.getSalary())
                    .append("</salary>").append(delimiter)
                    .append("    </employee>");
        }
        expect.append(delimiter).append("</employees>").append(delimiter);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}