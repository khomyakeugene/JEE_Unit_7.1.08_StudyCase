package com.company.model;

import javax.persistence.*;

/**
 * Created by Yevhen on 05.06.2016.
 */
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @SequenceGenerator(name = "pk_dish", sequenceName = "dish_dish_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_dish")
    @Column(name = "dish_id", unique = true, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private DishCategory category;

    @Column(name = "price")
    private Float price;

    @Column(name = "weight")
    private Float weight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;

        Dish dish = (Dish) o;

        return name != null ? name.equals(dish.name) :
                dish.name == null && category == dish.category && (price != null ? price.equals(dish.price) :
                        dish.price == null && (weight != null ? weight.equals(dish.weight) :
                                dish.weight == null));

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
