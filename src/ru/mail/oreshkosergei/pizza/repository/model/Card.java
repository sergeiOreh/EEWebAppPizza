package ru.mail.oreshkosergei.pizza.repository.model;

public class Card {
    Integer id, month, year, number, userId;
    String description;

    private Card(Builder builder) {
        setId(builder.id);
        setMonth(builder.month);
        setYear(builder.year);
        setNumber(builder.number);
        setUserId(builder.userId);
        setDescription(builder.description);
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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static final class Builder {
        private Integer id;
        private Integer month;
        private Integer year;
        private Integer number;
        private Integer userId;
        private String description;

        private Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder month(Integer val) {
            month = val;
            return this;
        }

        public Builder year(Integer val) {
            year = val;
            return this;
        }

        public Builder number(Integer val) {
            number = val;
            return this;
        }

        public Builder userId(Integer val) {
            userId = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }

    public Card() {
    }
}
