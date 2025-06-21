package cl.duoc.ms_cart_bff.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.duoc.ms_cart_bff.model.dto.CartDTO;


@FeignClient(name = "ms-cart-bs", url = "http://localhost:8181")
public interface CartBsFeingClient {

    @GetMapping("/api/Cart/getCartById/{idCart}")
    public CartDTO getCartById(@PathVariable("idCart") Long idCart);
    
    @PostMapping("/api/Cart/insertCart/{idCustomer}")
    public ResponseEntity<String> insertCart (@PathVariable("idCustomer") Long idCustomer);
    
    @PostMapping("/api/Cart/insertProduct/{idProduct}/{idCart}")
    public ResponseEntity<String> insertProduct (@PathVariable("idProduct") Long idProduct, @PathVariable("idCart") Long idCart);

    @DeleteMapping("/api/Cart/deleteProduct/{productName}/{idCart}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productName") String productName, @PathVariable("idCart") Long idCart);

}
