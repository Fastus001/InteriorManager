package furniture;

import interfaces.Measurable;

public abstract class Furniture implements Measurable {
    private final Double price;

    public Furniture(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
