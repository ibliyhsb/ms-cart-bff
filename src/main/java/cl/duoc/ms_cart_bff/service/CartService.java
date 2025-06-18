package cl.duoc.ms_cart_bff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.duoc.ms_cart_bff.clients.CartBsFeingClient;
import feign.FeignException.FeignClientException;

@Service
public class CartService {
    @Autowired
    CartBsFeingClient cartBsFeingClient;
    
    public ResponseEntity<?> getCartById(Long idCart){
    try {
    return ResponseEntity.ok(cartBsFeingClient.getCartById(idCart));}
    catch(FeignClientException feignClientException){
        return ResponseEntity.status(feignClientException.status()).body(feignClientException.contentUTF8());
        }
    }

    public ResponseEntity<?> insertCart (Long idCustomer) {    
        try{   
            return cartBsFeingClient.insertCart(idCustomer);
        }
        catch(FeignClientException feignClientException){
            return ResponseEntity.status(feignClientException.status()).body(feignClientException.contentUTF8());
      }
        
    }  
    
    public ResponseEntity<String> insertProduct (Long idProduct, Long idCart) {
    return cartBsFeingClient.insertProduct(idProduct, idCart);
    }
    
    public ResponseEntity<String> deleteProduct(String productName, Long idCart){
        try{
            return cartBsFeingClient.deleteProduct(productName, idCart);
        }
        catch(FeignClientException feignClientException){
            return ResponseEntity.status(feignClientException.status()).body(feignClientException.contentUTF8());
        }
    }    
}
