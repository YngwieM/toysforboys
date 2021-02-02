package be.vdab.toysforboys.domain;

import javax.persistence.*;

@Entity
@Table(name = "productlines")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long discription;
    private long version;

    public ProductLine(String name, long discription) {
        this.name = name;
        this.discription = discription;
    }

    protected ProductLine() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getDiscription() {
        return discription;
    }
}
