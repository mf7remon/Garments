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

class Inventory {
    private List<Garment> garments = new ArrayList<>();

    public void addGarment(Garment garment) {
        garments.add(garment);
        System.out.println("Added garment to inventory: " + garment.getName());
    }

    public Garment findGarment(String garmentName) {
        for (Garment g : garments) {
            if (g.getName().equals(garmentName)) {
                return g;
            }
        }
        return null;
    }
    public void removeGarment(String garmentName) {
        for (int i = 0; i < garments.size(); i++) {
            if (garments.get(i).getName().equals(garmentName)) {
                garments.remove(i);
                System.out.println("Removed garment from inventory: " + garmentName);
                break;
            }
        }
    }

    public List<Garment> getGarments() {
        return garments;
    }
}

public class Garment {
    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

    public Garment(String id, String name, String description, String size, String color, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void updateStock(int update) {
        stockQuantity += update;
        System.out.println("Updated stock for " + name + ": " + stockQuantity);
    }

    public double calculateDiscountPrice(double discount) {
        return price - (price * discount / 100);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Fabric cottonFabric = new Fabric("Fabric_01", "Cotton", "black", 15.0);
        Garment shirt = new Garment("Garment_01", "Shirt", "Cotton shirt", "XL", "black", 2500.0, 100);
        cottonFabric.addGarment(shirt);

        Supplier supplier = new Supplier("Supplier_01", "Mehedi", "01610936***");
        supplier.addFabric(cottonFabric);

        Customerr customer = new Customerr("Customer_01", "Fazlay Rabby", "remonmf3@gmail.com", "01575021***");
        Orderr order = new Orderr("1702", new Date());
        order.addGarment(shirt);
        customer.placeOrder(order);

        Inventory inventory = new Inventory();
        inventory.addGarment(shirt);

        order.printOrderDetail();


        shirt.updateStock(-5);
        double discountedPrice = shirt.calculateDiscountPrice(10);
        System.out.println("Discounted price: " + discountedPrice);
    }


}