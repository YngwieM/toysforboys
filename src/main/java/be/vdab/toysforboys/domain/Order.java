package be.vdab.toysforboys.domain;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate ordered;
    private LocalDate required;
    private LocalDate shipped;
private String comments;
    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId")
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ElementCollection
    @CollectionTable(name = "orderdetails",
            joinColumns = @JoinColumn(name = "orderId"))
    private Set<OrderDetail> orderDetails;
    @Version
    private long version;


    public Order(LocalDate ordered, LocalDate required, LocalDate shipped, String comments, Customer customer, Status status) {
        this.ordered = ordered;
        this.required = required;
        this.shipped = shipped;
        this.comments = comments;
        setCustomer(customer);
        this.status = status;
        this.orderDetails = new LinkedHashSet<>();
    }

    protected Order() {}


    public Set<OrderDetail> getOrderDetails() {
        return Collections.unmodifiableSet(orderDetails);
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public LocalDate getOrdered() {
        return ordered;
    }

    public LocalDate getRequired() {
        return required;
    }

    public LocalDate getShipped() {
        return shipped;
    }

    public String getComments() {
        return comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(ordered, order.ordered) && Objects.equals(required, order.required) && Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordered, required, customer);
    }
}
