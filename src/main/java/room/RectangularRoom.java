package room;

import furniture.Furniture;
import interfaces.Measurable;

import java.util.ArrayList;
import java.util.List;

public class RectangularRoom implements Measurable {
    private Double width;
    private Double length;
    List<Furniture> furnitures = new ArrayList<>();

    public RectangularRoom(Double width, Double length) {
        this.width = width;
        this.length = length;
    }

    public void addFurniture(Furniture furniture){
        furnitures.add(furniture);
    }

    @Override
    public Double area() {
        return width*length;
    }

    @Override
    public String show() {
        var sb = new StringBuilder();
        sb.append("Room, width: ")
                .append(width)
                .append(", length: ")
                .append(length)
                .append(".\n");
        if(furnitures.size()>0){
            sb.append("In room are following furnitures:\n");
        }
        for (Furniture f:furnitures)
        {
            sb.append(f.show()).append("\n");
        }

        return sb.toString();
    }
}
