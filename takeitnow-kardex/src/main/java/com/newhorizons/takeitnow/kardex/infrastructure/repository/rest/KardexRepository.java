package com.newhorizons.takeitnow.kardex.infrastructure.repository.rest;


import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.mapper.IProductMapper;
import com.newhorizons.takeitnow.kardex.domain.entity.Product;
import com.newhorizons.takeitnow.kardex.domain.repository.IKardexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Repository("repositoryRest")
public class KardexRepository implements IKardexRepository {
    @Autowired
    private RestTemplate restTemplateClient;

    @Autowired
    private IProductMapper productMapper;

    public List<KardexDto> getAll() {
        List<Product> products = Arrays.asList(restTemplateClient.getForObject("http://localhost:8002/products/getAll", Product[].class));
        List<ProductDto> productsDto = productMapper.toProductsDto(products);
        return productsDto.stream().map(p -> new KardexDto(p, 1L, "Input", new Date())).collect(Collectors.toList());
    }


    public KardexDto getKardex(long productId, long quantity, String transactionType, Date transactionDate) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("productId", Long.toString(productId));
        //Product product = restTemplateClient.getForObject("http://localhost:8002/takeitnow/api/products/getProduct/{productId}", Product.class, pathVariables);
        Product product = restTemplateClient.getForObject("http://localhost:8002/products/getProduct/{productId}", Product.class, pathVariables);
        ProductDto productDto = productMapper.toProductDto(product);
        return new KardexDto(productDto, quantity, transactionType, transactionDate);
    }
}
