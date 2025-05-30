package com.ecommerce.order.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.order.dto.ProductResponse;

@Component
@FeignClient(name = "ecommerce-product-service")
public interface ProductService {
	
	@GetMapping("/api/product/id")
	ProductResponse getProductId(@RequestParam("productId") int  productId);

}
