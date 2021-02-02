package be.vdab.toysforboys.domain;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long version;

    public Country(String name) {
        this.name = name;
    }
    protected Country() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
