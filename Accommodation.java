import java.io.Serializable;

public class Accommodation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;
    private double price;
    private boolean available;
    private String name;

    public Accommodation(String type, double price, boolean available, String name) {
        this.type = type;
        this.price = price;
        this.available = available;
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
