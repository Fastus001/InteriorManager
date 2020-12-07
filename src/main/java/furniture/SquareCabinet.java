package furniture;

public class SquareCabinet extends Furniture{
    private final Double length;

    public SquareCabinet(Double price, Double length) {
        super(price);
        this.length = length;
    }

    @Override
    public Double area() {
        return length*length;
    }

    @Override
    public String show() {
        return String.format("Square Cabinet, length: %.2f, price: %.2f.",length,super.getPrice() );
    }
}
