package pl.edu.vistula.restapiapplication.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
