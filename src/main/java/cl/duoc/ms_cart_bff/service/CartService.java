package cl.duoc.ms_cart_bff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.duoc.ms_cart_bff.clients.CartBsFeingClient;

@Service
public class CartService {
    @Autowired
    CartBsFeingClient cartBsFeingClient;
    
    public ResponseEntity<?> getCartById(Long idCart){
    return ResponseEntity.ok(cartBsFeingClient.getCartById(idCart));
    }


    public ResponseEntity<String> insertCart (Long idCustomer) {       
    return cartBsFeingClient.insertCart(idCustomer);
    }  
    
    public ResponseEntity<String> insertProduct (Long idProduct, Long idCart) {
    return cartBsFeingClient.insertProduct(idProduct, idCart);
    }
    
    public ResponseEntity<String> deleteProduct(String productName, Long idCart){
    return cartBsFeingClient.deleteProduct(productName, idCart);
    }    
}
