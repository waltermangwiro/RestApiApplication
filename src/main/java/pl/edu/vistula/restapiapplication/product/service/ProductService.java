package pl.edu.vistula.restapiapplication.product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.restapiapplication.product.api.request.ProductRequest;
import pl.edu.vistula.restapiapplication.product.api.request.UpdateProductRequest;
import pl.edu.vistula.restapiapplication.product.api.response.ProductResponse;
import pl.edu.vistula.restapiapplication.product.domain.Product;
import pl.edu.vistula.restapiapplication.product.repository.ProductRepository;
import pl.edu.vistula.restapiapplication.product.support.ProductExceptionSupplier;
import pl.edu.vistula.restapiapplication.product.support.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductResponse(savedProduct);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }
}