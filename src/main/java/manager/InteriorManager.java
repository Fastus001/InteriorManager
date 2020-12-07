package manager;

import exceptions.ExceededRoomAreaException;
import furniture.Furniture;
import interfaces.Measurable;
import room.RectangularRoom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InteriorManager {
    private final List<Measurable> resources = new ArrayList<>();
    private final Logger logger = Logger.getLogger(InteriorManager.class.getName());

    public InteriorManager() {
        try {
            FileHandler handler = new FileHandler("src/main/resources/filelog.log");
            logger.addHandler(handler);
            logger.setLevel(Level.FINER);
            handler.setLevel(Level.FINER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRoomWithFurniture(RectangularRoom room, Furniture... furnitures ) throws ExceededRoomAreaException {
        logger.entering(InteriorManager.class.getName(),"addRoomWithFurniture()");
        double areaFurniture = 0;
        for (Furniture furniture : furnitures) {
            areaFurniture += furniture.area();
        }
        if(areaFurniture<=room.area())
        {
            double price = 0;
            for(Furniture f: furnitures)
            {
                price+=f.getPrice();
                room.addFurniture(f);
            }
            resources.add(room);
            logger.info("Total price for furniture in room is - " + price);
        }else{
            throw new ExceededRoomAreaException("Total area exceeds room area!" );
        }
        logger.exiting(InteriorManager.class.getName(),"addRoomWithFurniture()");
    }

    public void showAllResources(){
        for (int i = 0; i < resources.size(); i++) {
            System.out.println((i+1)+". "+ resources.get(i).show());
        }
    }

    public Double countRoomsTotalArea()
    {
        double roomArea = 0;
        for(Measurable m:resources)
        {
            if(m instanceof RectangularRoom)
            {
                roomArea+=m.area();
            }
        }
        return roomArea;
    }


    public void addFurniture(Furniture furniture) {
        resources.add(furniture);
    }
}
