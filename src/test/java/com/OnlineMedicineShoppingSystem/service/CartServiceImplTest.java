package com.OnlineMedicineShoppingSystem.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.OnlineMedicalShop.model.Cart;
import com.OnlineMedicalShop.model.Medicine;
import com.OnlineMedicalShop.repository.CartRepository;
import com.OnlineMedicalShop.service.CartServiceImpl;

public class CartServiceImplTest {
	
	@InjectMocks
	CartServiceImpl cartServiceImpl;
	
	@Mock
	CartRepository cartRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddToCart() {
		Cart cart = mock(Cart.class);
		Medicine medicine = mock(Medicine.class);
		when(cart.getMedicine()).thenReturn(medicine);
		when(cartRepository.save(cart)).thenReturn(cart);
		
		Cart result = cartServiceImpl.addtocart(cart);
		
		assertNotNull(result);
		assertEquals(cart, result);
	}
	
	// add more test cases as needed for other methods

}
