package furniture;

public class Table extends Furniture{
    private final Double length;
    private final Double width;
    private final Double height;

    public Table(Double price, Double length, Double width, Double height) {
        super(price);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public Double area() {
        return length*width;
    }

    @Override
    public String show() {
        return String.format("Table, length: %.2f, width: %.2f, height: %.2f, price: %.2f.",
                length,width,height,super.getPrice() );
    }
}
