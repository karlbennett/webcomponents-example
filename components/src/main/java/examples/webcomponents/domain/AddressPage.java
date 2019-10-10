package examples.webcomponents.domain;

import java.util.List;
import java.util.Objects;

public class AddressPage {

    private int number;
    private int size;
    private int totalPages;
    private long totalElements;
    private List<Address> addresses;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressPage that = (AddressPage) o;
        return number == that.number &&
            size == that.size &&
            totalPages == that.totalPages &&
            totalElements == that.totalElements &&
            Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, size, totalPages, totalElements, addresses);
    }
}
