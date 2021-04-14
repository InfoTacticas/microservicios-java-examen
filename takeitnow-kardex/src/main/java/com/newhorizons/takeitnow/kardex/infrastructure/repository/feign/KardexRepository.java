package com.newhorizons.takeitnow.kardex.infrastructure.repository.feign;


import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.mapper.IProductMapper;
import com.newhorizons.takeitnow.kardex.domain.entity.Product;
import com.newhorizons.takeitnow.kardex.domain.repository.IKardexRepository;
import com.newhorizons.takeitnow.kardex.infrastructure.feign.IProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository("repositoryFeign")
public class KardexRepository implements IKardexRepository {
    @Autowired
    private IProductFeign productFeign;

    @Autowired
    private IProductMapper productMapper;

    public List<KardexDto> getAll() {
        List<Product> products = productFeign.getAll();
        List<ProductDto> productsDto = productMapper.toProductsDto(products);
        return productsDto.stream().map(p -> new KardexDto(p, 1L, "Input", new Date())).collect(Collectors.toList());
    }

    public KardexDto getKardex(long productId, long quantity, String transactionType, Date transactionDate) {
        Product product = productFeign.getProduct(productId);
        ProductDto productDto = productMapper.toProductDto(product);
        return new KardexDto(productDto, quantity, transactionType, transactionDate);
    }
}
