package ihungryburgershop.model;

public class Order {

    private String orderId;
    private String customerId;
    private String customerName;
    private int quantity;
    private String status;
    private double orderValue;

    public Order() {
    }

    public Order(String orderId, String customerId, String customerName,
                 int quantity, String status, double orderValue) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.quantity = quantity;
        this.status = status;
        this.orderValue = orderValue;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.orderValue = quantity * 500;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getOrderValue() {
        return orderValue;
    }

    @Override
    public String toString() {
        return orderId + " - "
                + customerId + " - "
                + customerName + " - "
                + quantity + " - "
                + status + " - Rs." + orderValue;
    }
}