package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MaxMinTest {

    MaxMin maxMin = new MaxMin();
    List<String> list = new ArrayList<>();

    @Test
    void checkMaxLengthStringThen123() {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        list.add("1");
        list.add("12");
        list.add("123");
        String expect = "123";
        String res = maxMin.max(list, comparator);
        assertThat(res).isEqualTo(expect);
    }

    @Test
    void checkMaxOneValueThen12() {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        list.add("12");
        String expect = "12";
        String res = maxMin.max(list, comparator);
        assertThat(res).isEqualTo(expect);
    }

    @Test
    void checkMaxNoValueThenNull() {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        String expect = null;
        String res = maxMin.max(list, comparator);
        assertThat(res).isEqualTo(expect);
    }

    @Test
    void checkMinLengthStringThen1() {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        list.add("1");
        list.add("12");
        list.add("123");
        String expect = "1";
        String res = maxMin.min(list, comparator);
        assertThat(res).isEqualTo(expect);
    }
}