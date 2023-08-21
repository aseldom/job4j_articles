package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDateTime;
import java.util.Objects;

public class Food {
    private final String name;
    private final LocalDateTime expireDate;
    private final LocalDateTime createDate;
    private Double price;
    private final Double discount;

    public Food(String name, LocalDateTime expireDate, LocalDateTime createDate, Double price, Double discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", expireDate=" + expireDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name)
                && Objects.equals(expireDate, food.expireDate)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(price, food.price)
                && Objects.equals(discount, food.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expireDate, createDate, price, discount);
    }

}
