package ru.mail.oreshkosergei.pizza.repository.model;

public class OrderItem {
    private Integer idOrderItem, quantity;
    private String pizzaName;
    private Float price;

    private OrderItem(Builder builder) {
        setIdOrderItem(builder.idOrderItem);
        setQuantity(builder.quantity);
        setPizzaName(builder.pizzaName);
        setPrice(builder.price);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Integer idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public OrderItem() {
    }

    public static final class Builder {
        private Integer idOrderItem;
        private Integer quantity;
        private String pizzaName;
        private Float price;

        private Builder() {
        }

        public Builder idOrderItem(Integer val) {
            idOrderItem = val;
            return this;
        }

        public Builder quantity(Integer val) {
            quantity = val;
            return this;
        }

        public Builder pizzaName(String val) {
            pizzaName = val;
            return this;
        }

        public Builder price(Float val) {
            price = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "idOrderItem=" + idOrderItem +
                ", quantity=" + quantity +
                ", pizzaName='" + pizzaName + '\'' +
                ", price=" + price +
                '}';
    }
}
