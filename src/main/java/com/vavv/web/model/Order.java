package com.vavv.web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Order")
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "guid", unique = true)
    private String guid;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_fk")
    private Set<OrderConfirmation> orderConfirmations = new HashSet<>();

    @Column(name = "purchase_order_number", nullable = false)
    private long purchaseOrderNumber;

    @Column(name = "sales_order_number", nullable = false)
    private long salesOrderNumber;

    @Column(name = "job_name", nullable = false)
    private String jobName;

    @Enumerated(EnumType.STRING)
    @Column(name = "material_type", nullable = false)
    private MaterialType materialType;

    @Column(name = "product_type")
    private String productType;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_type", nullable = false)
    private OrderType orderType;

    @Column(name = "order_date", nullable = false, columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "pickup_or_deliver_date", nullable = false, columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupOrDeliverDate;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "order_placed", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean orderPlaced;

    @Column(name = "is_picked_or_delivered", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isPickedOrDelivered;

    @Column(name = "completed_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedDate;

    @Column(name = "note")
    private String note;

    @Column(name = "user_id", nullable = false)
    private String userId;

    public Order() {
    }

    public Order(long purchaseOrderNumber, long salesOrderNumber, String jobName, MaterialType materialType,
                 OrderType orderType, Date orderDate, Date pickupOrDeliverDate, String city,
                 boolean orderPlaced, boolean isPickedOrDelivered, Date completedDate, String note,
                 String userId) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.salesOrderNumber = salesOrderNumber;
        this.jobName = jobName;
        this.materialType = materialType;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.pickupOrDeliverDate = pickupOrDeliverDate;
        this.city = city;
        this.orderPlaced = orderPlaced;
        this.isPickedOrDelivered = isPickedOrDelivered;
        this.completedDate = completedDate;
        this.note = note;
        this.userId = userId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Set<OrderConfirmation> getOrderConfirmations() {
        return orderConfirmations;
    }

    public void setOrderConfirmations(Set<OrderConfirmation> orderConfirmations) {
        this.orderConfirmations = orderConfirmations;
    }

    public long getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(long purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public long getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(long salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPickupOrDeliverDate() {
        return pickupOrDeliverDate;
    }

    public void setPickupOrDeliverDate(Date pickupOrDeliverDate) {
        this.pickupOrDeliverDate = pickupOrDeliverDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(boolean orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public boolean isPickedOrDelivered() {
        return isPickedOrDelivered;
    }

    public void setPickedOrDelivered(boolean pickedOrDelivered) {
        isPickedOrDelivered = pickedOrDelivered;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(guid, order.guid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guid);
    }

    @Override
    public String toString() {
        return "Order{" +
                "guid='" + guid + '\'' +
                ", orderConfirmations=" + orderConfirmations +
                ", purchaseOrderNumber=" + purchaseOrderNumber +
                ", salesOrderNumber=" + salesOrderNumber +
                ", jobName='" + jobName + '\'' +
                ", materialType=" + materialType +
                ", productType=" + productType +
                ", orderType=" + orderType +
                ", orderDate=" + orderDate +
                ", pickupOrDeliverDate=" + pickupOrDeliverDate +
                ", city='" + city + '\'' +
                ", orderPlaced=" + orderPlaced +
                ", isPickedOrDelivered=" + isPickedOrDelivered +
                ", completedDate=" + completedDate +
                ", note='" + note + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}
