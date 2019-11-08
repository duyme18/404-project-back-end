package com.hotel.model;

import javax.persistence.*;

@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String bedroomQuantity;
    private String bathroomQuantity;
    private Double price;
    private String image;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_home_id")
    private CategoryHome categoryHome;
    @ManyToOne
    @JoinColumn(name = "category_room_id")
    private CategoryRoom categoryRoom;
    @ManyToOne
    @JoinColumn(name = "status_home_id")
    private StatusHome statusHome;

    public Home(String name, String address, String bedroomQuantity, String bathroomQuantity, Double price, String image, String description) {
        this.name = name;
        this.address = address;
        this.bedroomQuantity = bedroomQuantity;
        this.bathroomQuantity = bathroomQuantity;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBedroomQuantity() {
        return bedroomQuantity;
    }

    public void setBedroomQuantity(String bedroomQuantity) {
        this.bedroomQuantity = bedroomQuantity;
    }

    public String getBathroomQuantity() {
        return bathroomQuantity;
    }

    public void setBathroomQuantity(String bathroomQuantity) {
        this.bathroomQuantity = bathroomQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryHome getCategoryHome() {
        return categoryHome;
    }

    public void setCategoryHome(CategoryHome categoryHome) {
        this.categoryHome = categoryHome;
    }

    public CategoryRoom getCategoryRoom() {
        return categoryRoom;
    }

    public void setCategoryRoom(CategoryRoom categoryRoom) {
        this.categoryRoom = categoryRoom;
    }

    public StatusHome getStatusHome() {
        return statusHome;
    }

    public void setStatusHome(StatusHome statusHome) {
        this.statusHome = statusHome;
    }

    public Home() {
    }
}
