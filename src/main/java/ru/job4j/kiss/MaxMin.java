package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return minMax(value, comparator, 1);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return minMax(value, comparator, -1);
    }

    private  <T> T minMax(List<T> value, Comparator<T> comparator, int minMax) {
        T res = value.isEmpty() ? null : value.get(0);
        for (T v : value) {
            res = comparator.compare(res, v) * minMax > 0 ? res : v;
        }
        return res;
    }
}