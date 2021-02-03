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
    @ManyToOne
    @JoinColumn(name = "productId")
    @OrderBy("name")
    private Product product;

    public OrderDetail(int ordered, BigDecimal priceEach, Product product) {
        this.ordered = ordered;
        this.priceEach = priceEach;
        setProduct(product);

    }

    protected OrderDetail() {}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
