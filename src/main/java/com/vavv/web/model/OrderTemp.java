package com.vavv.web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "OrderTemp")
@Table(name = "order_another")
public class OrderTemp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "guid", unique = true)
    private String guid;

    @Override
    public String toString() {
        return "OrderTemp{" +
                "guid='" + guid + '\'' +
                ", orderConfirmations=" + orderConfirmations +
                ", purchaseOrderNumber=" + purchaseOrderNumber +
                ", salesOrderNumber=" + salesOrderNumber +
                ", jobName='" + jobName + '\'' +
                ", materialType=" + materialType +
                ", orderType=" + orderType +
                ", orderDate=" + orderDate +
                ", pickupOrDeliverDate=" + pickupOrDeliverDate +
                ", city='" + city + '\'' +
                ", isPickedOrDelivered=" + isPickedOrDelivered +
                ", completedDate=" + completedDate +
                ", note='" + note + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

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

    @Column(name = "is_picked_or_delivered", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isPickedOrDelivered;

    @Column(name = "completed_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedDate;

    @Column(name = "note")
    private String note;

    @Column(name = "user_id", nullable = false)
    private String userId;

    public OrderTemp() {
    }

    public OrderTemp(long purchaseOrderNumber, long salesOrderNumber, String jobName, MaterialType materialType, OrderType orderType, Date orderDate, Date pickupOrDeliverDate, String city, boolean isPickedOrDelivered, String note) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.salesOrderNumber = salesOrderNumber;
        this.jobName = jobName;
        this.materialType = materialType;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.pickupOrDeliverDate = pickupOrDeliverDate;
        this.city = city;
        this.isPickedOrDelivered = isPickedOrDelivered;
        this.note = note;
    }

    public OrderTemp(long purchaseOrderNumber, long salesOrderNumber, String jobName, MaterialType materialType, OrderType orderType, Date orderDate, Date pickupOrDeliverDate, String city, boolean isPickedOrDelivered) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.salesOrderNumber = salesOrderNumber;
        this.jobName = jobName;
        this.materialType = materialType;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.pickupOrDeliverDate = pickupOrDeliverDate;
        this.city = city;
        this.isPickedOrDelivered = isPickedOrDelivered;
    }

    public OrderTemp(long purchaseOrderNumber, long salesOrderNumber, String jobName, MaterialType materialType, OrderType orderType, Date orderDate, Date pickupOrDeliverDate, String city, boolean isPickedOrDelivered, String note, String userId) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.salesOrderNumber = salesOrderNumber;
        this.jobName = jobName;
        this.materialType = materialType;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.pickupOrDeliverDate = pickupOrDeliverDate;
        this.city = city;
        this.isPickedOrDelivered = isPickedOrDelivered;
        this.note = note;
        this.userId = userId;
    }

    public OrderTemp(long purchaseOrderNumber, long salesOrderNumber, String jobName, MaterialType materialType, OrderType orderType, Date orderDate, Date pickupOrDeliverDate, String city, boolean isPickedOrDelivered, Date completedDate) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.salesOrderNumber = salesOrderNumber;
        this.jobName = jobName;
        this.materialType = materialType;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.pickupOrDeliverDate = pickupOrDeliverDate;
        this.city = city;
        this.isPickedOrDelivered = isPickedOrDelivered;
        this.completedDate = completedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderTemp)) return false;
        OrderTemp orderTemp = (OrderTemp) o;
        return Objects.equals(guid, orderTemp.guid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guid);
    }

}
