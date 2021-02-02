package be.vdab.toysforboys.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class Address {
    private String streetAndNumber;
    private String city;
    private String state;
    private String postalCode;


    public Address(String streetAndNumber, String city, String state, String postalCode) {
        this.streetAndNumber = streetAndNumber;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    protected Address() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(streetAndNumber, address.streetAndNumber) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAndNumber, city, state, postalCode);
    }
}
