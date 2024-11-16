public class Ticket implements Comparable<Ticket> {
    private String name;
    private double price;

    public Ticket(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket[name=" + name + ", price=" + price + "]";
    }

    @Override
    public int compareTo(Ticket o) {
        return this.name.compareTo(o.name);
    }
}
