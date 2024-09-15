package br.com.poc.cakeshop_order_service.service;

import br.com.poc.cakeshop_order_service.converter.ProductConverter;
import br.com.poc.cakeshop_order_service.domain.entity.Product;
import br.com.poc.cakeshop_order_service.model.ProductDTO;
import br.com.poc.cakeshop_order_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public List<ProductDTO> findAll() {
        final List<Product> products = productRepository.findAll(Sort.by("id"));
        return products.stream()
                .map(productConverter::toDTO)
                .toList();
    }

    public Optional<ProductDTO> get(Long id) {
        return productRepository.findById(id).map(productConverter::toDTO);
    }

    public ProductDTO create(ProductDTO productDTO) {
        Product product = productConverter.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productConverter.toDTO(savedProduct);
    }

    public Optional<ProductDTO> update(Long id, ProductDTO productDTO) {
        return productRepository.findById(id).map(existingProduct -> {
            productConverter.toEntity(productDTO, existingProduct);
            return productConverter.toDTO(productRepository.save(existingProduct));
        });
    }

    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
