package ru.mail.oreshkosergei.pizza.repository.model;

public class Order {
    private Integer id, quantity;
    private String orderPizzaName, status, firstName, surname;
    private Float orderPriceOnePizza;

    private Order(Builder builder) {
        setId(builder.id);
        setQuantity(builder.quantity);
        setOrderPizzaName(builder.orderPizzaName);
        setStatus(builder.status);
        setFirstName(builder.firstName);
        setSurname(builder.surname);
        setOrderPriceOnePizza(builder.orderPriceOnePizza);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOrderPizzaName() {
        return orderPizzaName;
    }

    public void setOrderPizzaName(String orderPizzaName) {
        this.orderPizzaName = orderPizzaName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Float getOrderPriceOnePizza() {
        return orderPriceOnePizza;
    }

    public void setOrderPriceOnePizza(Float orderPriceOnePizza) {
        this.orderPriceOnePizza = orderPriceOnePizza;
    }

    public static final class Builder {
        private Integer id;
        private Integer quantity;
        private String orderPizzaName;
        private String status;
        private String firstName;
        private String surname;
        private Float orderPriceOnePizza;

        private Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder quantity(Integer val) {
            quantity = val;
            return this;
        }

        public Builder orderPizzaName(String val) {
            orderPizzaName = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder surname(String val) {
            surname = val;
            return this;
        }

        public Builder orderPriceOnePizza(Float val) {
            orderPriceOnePizza = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", orderPizzaName='" + orderPizzaName + '\'' +
                ", status='" + status + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", orderPriceOnePizza=" + orderPriceOnePizza +
                '}';
    }

    public Order() {
    }
}
