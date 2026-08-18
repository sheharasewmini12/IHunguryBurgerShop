package ihungryburgershop.controller;

import ihungryburgershop.model.Order;
import java.util.ArrayList;

public class OrderController {

    private static final ArrayList<Order> orderList = new ArrayList<>();

    private static int orderNumber = 1;

    // Generate next Order ID
    public static String generateOrderId() {

        String orderId = String.format("O%03d", orderNumber);

        orderNumber++;

        return orderId;
    }

    // Add new order
    public static boolean addOrder(Order order) {

        if (order == null) {
            return false;
        }

        orderList.add(order);

        return true;
    }

    // Get all orders
    public static ArrayList<Order> getAllOrders() {

        return orderList;
    }

    // Search order by Order ID
    public static Order searchOrder(String orderId) {

        for (Order order : orderList) {

            if (order.getOrderId().equalsIgnoreCase(orderId)) {
                return order;
            }
        }

        return null;
    }

    // Search orders by Customer ID
    public static ArrayList<Order> searchOrdersByCustomer(String customerId) {

        ArrayList<Order> customerOrders = new ArrayList<>();

        for (Order order : orderList) {

            if (order.getCustomerId().equalsIgnoreCase(customerId)) {
                customerOrders.add(order);
            }
        }

        return customerOrders;
    }

    // Search orders by status
    public static ArrayList<Order> searchOrdersByStatus(String status) {

        ArrayList<Order> statusOrders = new ArrayList<>();

        for (Order order : orderList) {

            if (order.getStatus().equalsIgnoreCase(status)) {
                statusOrders.add(order);
            }
        }

        return statusOrders;
    }

    // Update quantity
    public static boolean updateQuantity(String orderId, int newQuantity) {

        Order order = searchOrder(orderId);

        if (order == null) {
            return false;
        }

        if (!order.getStatus().equalsIgnoreCase("PREPARING")) {
            return false;
        }

        if (newQuantity <= 0) {
            return false;
        }

        order.setQuantity(newQuantity);

        return true;
    }

    // Update status
    public static boolean updateStatus(String orderId, String newStatus) {

        Order order = searchOrder(orderId);

        if (order == null) {
            return false;
        }

        if (!order.getStatus().equalsIgnoreCase("PREPARING")) {
            return false;
        }

        if (!newStatus.equalsIgnoreCase("PREPARING")
                && !newStatus.equalsIgnoreCase("DELIVERED")
                && !newStatus.equalsIgnoreCase("CANCELLED")) {

            return false;
        }

        order.setStatus(newStatus);

        return true;
    }
}