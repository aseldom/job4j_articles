package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return minMax(value, (v1, v2) -> comparator.compare(v1, v2) > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return minMax(value, (v1, v2) -> comparator.compare(v1, v2) < 0);
    }

    private  <T> T minMax(List<T> value, BiPredicate<T, T> biPredicate) {
        T res = value.isEmpty() ? null : value.get(0);
        for (T v : value) {
            res = biPredicate.test(res, v) ? res : v;
        }
        return res;
    }
}