import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Customer implements Comparable<Customer> {
    private String firstName;
    private String lastName;
    private Map<Ticket, Integer> ticketsPurchased;  // 存储每种票的购买数量

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ticketsPurchased = new HashMap<>();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void addTickets(Ticket ticket, int quantity) {

        if (ticketsPurchased.size() >= 3) {
            System.out.println("Error: You can only have up to 3 different types of tickets.");
            return;
        }

        ticketsPurchased.put(ticket, ticketsPurchased.getOrDefault(ticket, 0) + quantity);

        int totalTickets = ticketsPurchased.values().stream().mapToInt(Integer::intValue).sum();

        if (totalTickets < 6){
            writeLetterToFile("Dear " + getFullName() + ",\n"
                    + "You need to purchase at least " + (6 - totalTickets) + " more ticket(s) to qualify for discount.\n"
                    + "Thank you."
            );
        }
    }

    public void removeTickets(Ticket ticket, int quantity) {
        if (ticketsPurchased.containsKey(ticket)) {
            int currentQuantity = ticketsPurchased.get(ticket);
            int newQuantity = Math.max(0, currentQuantity - quantity);
            if (newQuantity == 0) {
                ticketsPurchased.remove(ticket);
            } else {
                ticketsPurchased.put(ticket, newQuantity);
            }
        }
    }

    public Map<Ticket, Integer> getTicketsPurchased() {
        return ticketsPurchased;
    }


    public double getTotalCost() {
        double totalCost = 0;
        for (Map.Entry<Ticket, Integer> entry : ticketsPurchased.entrySet()) {
            totalCost += entry.getKey().getPrice() * entry.getValue();
        }
        return totalCost;
    }

    public double getDiscountedCost() {
        double totalCost = getTotalCost();
        int totalTickets = ticketsPurchased.values().stream().mapToInt(Integer::intValue).sum();

        // 根据购买的票数计算折扣
        double discount = 0;
        if (totalTickets >= 26) {
            discount = 0.25;
        } else if (totalTickets >= 11) {
            discount = 0.15;
        } else if (totalTickets >= 6) {
            discount = 0.10;
        }

        return totalCost * (1 - discount);
    }

    private void writeLetterToFile(String message) {
        try (PrintWriter outFile = new PrintWriter(new FileWriter("src/letters.txt", true))) {  // 设置为追加模式
            outFile.println(message);  // 写入消息并自动换行
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @Override
    public int compareTo(Customer other) {
        return this.getFullName().compareTo(other.getFullName());
    }

    @Override
    public String toString() {
        return "Customer[firstName:" + firstName + ", lastName:" + lastName + "]";
    }
}
