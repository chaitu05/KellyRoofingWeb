package com.vavv.web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Order")
@Table(name = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "guid", unique = true)
    private String guid;

    public Order(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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
                '}';
    }

}
