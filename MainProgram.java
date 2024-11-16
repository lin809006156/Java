import java.util.Map;
import java.util.Scanner;

public class MainProgram {
    private static SortedLinkedList<Customer> customers = new SortedLinkedList<>();
    private static SortedLinkedList<Ticket> tickets = new SortedLinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数据
        FileManager.readData(customers, tickets);

        // 主菜单
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("f - Finish");
            System.out.println("t - Display all ticket information");
            System.out.println("c - Display all customers' information");
            System.out.println("a - Add tickets to a customer");
            System.out.println("r - Remove tickets from a customer");

            String option = scanner.nextLine();

            switch (option) {
                case "f":
                    System.out.println("Exiting program...");
                    return;
                case "t":
                    displayTickets();
                    break;
                case "c":
                    displayCustomers();
                    break;
                case "a":
                    addTickets(scanner);
                    break;
                case "r":
                    removeTickets(scanner);
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void displayTickets() {
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    private static void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.getFullName());
            System.out.println("Tickets Purchased:");
            for (Map.Entry<Ticket, Integer> entry : customer.getTicketsPurchased().entrySet()) {
                Ticket ticket = entry.getKey();
                int quantity = entry.getValue();
                System.out.println("--- " + ticket.getName() + ": " + quantity + " ticket(s)");
            }
            System.out.println("Total Cost: " + customer.getTotalCost());
            System.out.println("Discounted Cost: " + customer.getDiscountedCost());
            System.out.println();
        }
    }

    private static void addTickets(Scanner scanner) {
        System.out.println("Enter customer name (Full name): ");
        String name = scanner.nextLine();
        Customer customer = findCustomerByName(name);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Enter ticket name: ");
        String ticketName = scanner.nextLine();
        Ticket ticket = findTicketByName(ticketName);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        customer.addTickets(ticket, quantity);
        System.out.println("Tickets added.");
    }

    private static void removeTickets(Scanner scanner) {
        System.out.println("Enter customer name (Full name): ");
        String name = scanner.nextLine();
        Customer customer = findCustomerByName(name);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Enter ticket name: ");
        String ticketName = scanner.nextLine();
        Ticket ticket = findTicketByName(ticketName);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        customer.removeTickets(ticket, quantity);
        System.out.println("Tickets removed.");
    }

    private static Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getFullName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    private static Ticket findTicketByName(String ticketName) {
        for (Ticket ticket : tickets) {
            if (ticket.getName().equalsIgnoreCase(ticketName)) {
                return ticket;
            }
        }
        return null;
    }
}
