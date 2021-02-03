package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Embeddable
@Access(AccessType.FIELD)
public class OrderDetail {
    private int ordered;
    private BigDecimal priceEach;
    @OneToMany
    @JoinColumn(name = "productId")
    @OrderBy("name")
    private Set<Product> products;

    public OrderDetail(int ordered, BigDecimal priceEach) {
        this.ordered = ordered;
        this.priceEach = priceEach;

    }

    protected OrderDetail() {}


    public Set<Product> getProduct() {
        return Collections.unmodifiableSet(products);
    }
    public boolean add(Product product) {
        if (product == null) {
            throw new NullPointerException();
        }
        return products.add(product);
    }



    public int getOrdered() {
        return ordered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        OrderDetail that = (OrderDetail) o;
        return ordered == that.ordered && Objects.equals(priceEach, that.priceEach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordered, priceEach);
    }
}
