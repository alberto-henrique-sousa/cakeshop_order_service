package br.com.poc.cakeshop_order_service.converter;

import br.com.poc.cakeshop_order_service.domain.entity.Product;
import br.com.poc.cakeshop_order_service.model.ProductDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDTO toDTO(@NotNull Product product) {

        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .createAt(product.getCreateAt())
                .updateAt(product.getUpdateAt())
                .build();
    }

    public Product toEntity(@NotNull ProductDTO productDTO) {

        Product product = new Product();
        product.setId(productDTO.getId());
        setProduct(productDTO, product);
        return product;
    }

    public void toEntity(ProductDTO productDTO, Product product) {

        setProduct(productDTO, product);
    }

    private static void setProduct(@NotNull ProductDTO productDTO, @NotNull Product product) {
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
    }

}
