package be.vdab.toysforboys.domain;

import javax.persistence.*;

@Entity
@Table(name = "productlines")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private long version;

    public ProductLine(String name, String discription) {
        this.name = name;
        this.description = discription;
    }

    protected ProductLine() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
