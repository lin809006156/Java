import java.io.*;
import java.util.*;

public class FileManager {

    public static void readData(SortedLinkedList<Customer> customers, SortedLinkedList<Ticket> tickets) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input_data.txt"))) {
            // 读取客户数据
            int customerCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < customerCount; i++) {
                String name = reader.readLine();
                String[] split = name.split(" ");
                String firstName = split[0];
                String lastName = split[1];
                customers.add(new Customer(firstName, lastName));
            }

            // 读取票务数据
            int ticketCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < ticketCount; i++) {
                String ticketName = reader.readLine();
                double price = Double.parseDouble(reader.readLine());
                tickets.add(new Ticket(ticketName, price));
            }
        } catch (IOException e) {
            System.out.println("Error reading data file: " + e.getMessage());
        }
    }
}
