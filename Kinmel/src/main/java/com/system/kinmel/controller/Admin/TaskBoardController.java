package com.system.kinmel.controller.Admin;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class TaskBoardController {
    private final CartService cartService;

    @GetMapping("/taskboard")
    public String getaddProduct(Model model){

        List<String> status = cartService.distinctstatus();
        List<Cart> carts = cartService.cartdetails();
        model.addAttribute("status",status);
        model.addAttribute("details",carts);
        return "Admin/taskboard";

    }

    @PostMapping("/update-cart-status")
    public ResponseEntity<String> updatestatus(@RequestParam Integer cart_id, @RequestParam String status){

        try {
            cartService.updatecartstatus(cart_id,status);

            // Return a success response
            return ResponseEntity.ok("Cart status updated successfully.");
        } catch (Exception e) {
            System.out.println("---------------------------------");
            System.out.println("REACHED PART 1 FAILED");

            System.out.println(e.getMessage());
            // Return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task status: " + e.getMessage());
        }


    }
}
