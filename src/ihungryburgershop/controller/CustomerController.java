package ihungryburgershop.controller;

import ihungryburgershop.model.Customer;
import java.util.ArrayList;

public class CustomerController {

    private static final ArrayList<Customer> customerList = new ArrayList<>();

    private static int customerNumber = 1;

    // Generate next Customer ID
    public static String generateCustomerId() {

        String customerId = String.format("C%03d", customerNumber);

        customerNumber++;

        return customerId;
    }

    // Add new customer
    public static boolean addCustomer(Customer customer) {

        if (customer == null) {
            return false;
        }

        customerList.add(customer);

        return true;
    }

    // Search customer by Customer ID
    public static Customer searchCustomer(String customerId) {

        for (Customer customer : customerList) {

            if (customer.getCustomerId().equalsIgnoreCase(customerId)) {
                return customer;
            }
        }

        return null;
    }

    // Get all customers
    public static ArrayList<Customer> getAllCustomers() {

        return customerList;
    }
}