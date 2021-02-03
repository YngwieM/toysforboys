package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String scale;
    private String discription;
    private int inStock;
    private int inOrder;
    private BigDecimal price;
    @ManyToOne(optional = false)
    @JoinColumn(name = "productlineId")
    private ProductLine productLine;
    @Version
    private long version;


    public Product(String name, String scale, String discription, int inStock, int inOrder, BigDecimal price, ProductLine productLine) {
        this.name = name;
        this.scale = scale;
        this.discription = discription;
        this.inStock = inStock;
        this.inOrder = inOrder;
        this.price = price;
        setProductLine(productLine);
    }



    protected Product() {
    }


    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScale() {
        return scale;
    }

    public String getDiscription() {
        return discription;
    }

    public int getInStock() {
        return inStock;
    }

    public int getInOrder() {
        return inOrder;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
