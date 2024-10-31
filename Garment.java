// Bismillah


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Fabric {
    public String id, type, color;
    public double pricePerMeter;
    private List<Garment> garments = new ArrayList<>();

    public Fabric(String id, String type, String color, double pricePerMeter) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
        System.out.println("Added garment to fabric: " + type);
    }

    public double calculateCost(double meters) {
        return pricePerMeter * meters;
    }

    public List<Garment> getGarments() {
        return garments;
    }
}
