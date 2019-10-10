package examples.webcomponents.domain;

import java.util.Objects;

public class Address {

    private Long id;
    private String street;
    private String city;
    private Long zip;
    private String state;
    private Integer beds;
    private Integer baths;
    private Long squareFeet;
    private String type;
    private String saleDate;
    private Long price;
    private Double latitude;
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public Long getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(Long squareFeet) {
        this.squareFeet = squareFeet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
            Objects.equals(street, address.street) &&
            Objects.equals(city, address.city) &&
            Objects.equals(zip, address.zip) &&
            Objects.equals(state, address.state) &&
            Objects.equals(beds, address.beds) &&
            Objects.equals(baths, address.baths) &&
            Objects.equals(squareFeet, address.squareFeet) &&
            Objects.equals(type, address.type) &&
            Objects.equals(saleDate, address.saleDate) &&
            Objects.equals(price, address.price) &&
            Objects.equals(latitude, address.latitude) &&
            Objects.equals(longitude, address.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, zip, state, beds, baths, squareFeet, type, saleDate, price, latitude, longitude);
    }
}
