package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.CalendarAdapterJson;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class JsonReportEngine implements Report {

    GsonBuilder builder;
    Gson gson;
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public JsonReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) {
        builder = new GsonBuilder();
        builder.registerTypeAdapter(GregorianCalendar.class, new CalendarAdapterJson());
        gson = builder.setPrettyPrinting().create();
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}
