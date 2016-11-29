package org.shop.mobile.manager;

import org.shop.mobile.model.Product;
import org.shop.mobile.resource.PagedProducerResultResource;
import org.shop.mobile.resource.PagedProductResultResource;
import org.shop.mobile.resource.PagedProductTypeResultResource;
import org.shop.mobile.resource.ProducerResource;
import org.shop.mobile.resource.ProductResource;
import org.shop.mobile.resource.ProductTypeResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {

    public static final String PRODUCERS_URI = ProducerResource.PRODUCER_API_URI + "?fields=id,name";

    public static final String PRODUCT_TYPES_URI = ProductTypeResource.PRODUCT_TYPE_API_URI + "?fields=id,name";

    public static final String PRODUCTS_URI = ProductResource.PRODUCT_API_URI +
            "?fields=id,productTypeId,category,producerId,cost,imageUri";

    public static List<Product> getList() {
        RestTemplate request = new RestTemplate(true);
        request.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        ResponseEntity<PagedProductTypeResultResource> productTypeResponseEntity =
                request.getForEntity(PRODUCT_TYPES_URI, PagedProductTypeResultResource.class);
        List<ProductTypeResource> productTypes = productTypeResponseEntity.getBody().getResources();
        Map<Long, String> productTypesNames = new HashMap<Long, String>();
        for (ProductTypeResource productType : productTypes) {
            productTypesNames.put(productType.getId(), productType.getName());
        }

        ResponseEntity<PagedProducerResultResource> producersResponseEntity =
                request.getForEntity(PRODUCERS_URI, PagedProducerResultResource.class);
        List<ProducerResource> producers = producersResponseEntity.getBody().getResources();
        Map<Long, String> producersNames = new HashMap<Long, String>();
        for (ProducerResource producer : producers) {
            producersNames.put(producer.getId(), producer.getName());
        }

        ResponseEntity<PagedProductResultResource> productResponseEntity =
                request.getForEntity(PRODUCTS_URI, PagedProductResultResource.class);
        List<ProductResource> productResources = productResponseEntity.getBody().getResources();

        List<Product> products = new ArrayList<>();
        for (ProductResource productResource : productResources) {
            Product product = new Product();
            product.setId(productResource.getId());
            product.setProductTypeName(productTypesNames.get(productResource.getProductTypeId()));
            switch (productResource.getCategory()) {
                case MAN:
                    product.setCategoryName("Для чоловіків");
                    break;
                case WOMAN:
                    product.setCategoryName("Для жінок");
                    break;
                case BOY:
                    product.setCategoryName("Для хлопчиків");
                    break;
                case GIRL:
                    product.setCategoryName("Для дівчаток");
                    break;
            }
            product.setProducerName(producersNames.get(productResource.getProducerId()));
            product.setCost(productResource.getCost());
            product.setImageUri(productResource.getImageUri());
            product.setInfo(productResource.getInfo());
            products.add(product);
        }
        return products;
    }


}
