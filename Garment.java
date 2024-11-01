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

class Supplier {
    public String id, name, contactInfo;
    private List<Fabric> suppliedFabrics = new ArrayList<>();

    public Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }
    public void addFabric(Fabric fabric) {
        suppliedFabrics.add(fabric);
        System.out.println("Added fabric to supplier: " + name);
    }

    public List<Fabric> getSuppliedFabrics() {
        return suppliedFabrics;
    }

}

class Orderr {
    public String orderId;
    public Date orderDate;
    public List<Garment> garments = new ArrayList<>();
    public double totalAmount;

    public Orderr(String orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public void addGarment(Garment garment) {
        garments.add(garment);
        totalAmount += garment.getPrice();
        System.out.println("Added garment to order: " + orderId);
    }

    public double calculateTotalAmount() {
        totalAmount = 0;
        for (Garment g : garments) {
            totalAmount += g.getPrice();
        }
        return totalAmount;
    }

    public void printOrderDetail() {
        System.out.println("Order ID: " + orderId + ", Date: " + orderDate + ", Total: " + totalAmount);
    }

}


class Customerr {
    public String customerId, name, email, phone;
    private List<Orderr> orders = new ArrayList<>();

    public Customerr(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void placeOrder(Orderr order) {
        orders.add(order);
        System.out.println("Order placed by: " + name);
    }

    public List<Orderr> viewOrders() {
        return orders;
    }
}