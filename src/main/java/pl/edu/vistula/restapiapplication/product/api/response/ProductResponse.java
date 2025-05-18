package pl.edu.vistula.restapiapplication.product.api.response;

public class ProductResponse {
    private final Long id;
    private final String name;

    public ProductResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}