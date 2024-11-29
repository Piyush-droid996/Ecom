package com.ecommerce.cart.resource;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import com.ecommerce.cart.dao.CartDao;
import com.ecommerce.cart.dto.AddToCartRequest;
import com.ecommerce.cart.dto.CartDataResponse;
import com.ecommerce.cart.dto.CartResponse;
import com.ecommerce.cart.dto.CommonApiResponse;
import com.ecommerce.cart.dto.Product;
import com.ecommerce.cart.dto.ProductResponse;
import com.ecommerce.cart.dto.User;
import com.ecommerce.cart.dto.UserResponse;
import com.ecommerce.cart.exception.CartSaveFailedException;
import com.ecommerce.cart.external.ProductService;
import com.ecommerce.cart.external.UserService;
import com.ecommerce.cart.model.Cart;

class CartResourceTest {

    @InjectMocks
    private CartResource cartResource;

    @Mock
    private CartDao cartDao;

    @Mock
    private UserService userService;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddToCart_Success() {
        AddToCartRequest request = new AddToCartRequest();
        request.setProductId(1);
        request.setQuantity(2);
        request.setUserId(1);

        Cart cart = new Cart();
        cart.setId(1);
        cart.setProductId(1);
        cart.setQuantity(2);
        cart.setUserId(1);

        when(cartDao.save(any(Cart.class))).thenReturn(cart);

        ResponseEntity<CommonApiResponse> response = cartResource.add(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isSuccess());
        assertEquals("Cart added successful!!!", response.getBody().getResponseMessage());
    }

    @Test
    void testAddToCart_FailedToSave() {
        AddToCartRequest request = new AddToCartRequest();
        request.setProductId(1);
        request.setQuantity(2);
        request.setUserId(1);

        when(cartDao.save(any(Cart.class))).thenReturn(null);

        assertThrows(CartSaveFailedException.class, () -> cartResource.add(request));
    }

    @Test
    void testGetMyCart_Success() {
        int userId = 1;

        User user = new User();
        user.setId(1);
        user.setFirstName("John");

        UserResponse userResponse = new UserResponse();
        userResponse.setUsers(List.of(user));

        when(userService.getUserById(userId)).thenReturn(userResponse);

        Cart cart = new Cart();
        cart.setId(1);
        cart.setProductId(101);
        cart.setQuantity(2);
        cart.setUserId(userId);

        when(cartDao.findByUserId(userId)).thenReturn(List.of(cart));

        Product product = new Product();
        product.setId(101);
        product.setTitle("Test Product");
        product.setDescription("Test Description");
//        product.setPrice(123,456.75);
        product.setImageName("test.jpg");

        ProductResponse productResponse = new ProductResponse();
        productResponse.setProducts(List.of(product));

        when(productService.getProductId(101)).thenReturn(productResponse);

        ResponseEntity<CartResponse> response = cartResource.getMyCart(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isSuccess());
        assertEquals(1, response.getBody().getCartData().size());
        assertEquals("200.0", response.getBody().getTotalCartPrice());
    }

    @Test
    void testRemoveCartItem_Success() {
        int cartId = 1;

        Cart cart = new Cart();
        cart.setId(cartId);

        when(cartDao.findById(cartId)).thenReturn(Optional.of(cart));

        doNothing().when(cartDao).delete(cart);

        ResponseEntity<CommonApiResponse> response = cartResource.removeCartItem(cartId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isSuccess());
        assertEquals("product deleted from Cart Successfull!!!", response.getBody().getResponseMessage());
    }

    @Test
    void testRemoveCartItem_CartNotFound() {
        int cartId = 1;

        when(cartDao.findById(cartId)).thenReturn(Optional.empty());

        ResponseEntity<CommonApiResponse> response = cartResource.removeCartItem(cartId);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertFalse(response.getBody().isSuccess());
        assertEquals("Cart not found!!!", response.getBody().getResponseMessage());
    }
}
