package ru.job4j.ood.lsp.foodstore;

import java.util.List;

public class ControlQuality {

    private final List<Store<Food>> stores;

    public ControlQuality(List<Store<Food>> stores) {
        this.stores = stores;

    }

    public Store<Food> distribute(Food food) {
        Store<Food> res = null;
        for (Store<Food> store : stores) {
            if (store.check(food)) {
                res = store;
                break;
            }
        }
        return res;
    }
}
