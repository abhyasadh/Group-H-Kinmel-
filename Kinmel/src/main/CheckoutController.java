package GroupH.Kinmel.Controller;

import GroupH.Kinmel.Entity.Checkout;
import GroupH.Kinmel.Pojo.CheckoutPojo;
import GroupH.Kinmel.Services.Interface.CheckoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;



    @GetMapping("/checkout")
    public String createUser(Model model){
        model.addAttribute("checkout", new CheckoutPojo());
        return "html/checkout";
    }


    @PostMapping("/save")
    public String saveUser(@Valid CheckoutPojo checkoutPojo){
        checkoutService.save(checkoutPojo);
        return "redirect:/profile/list"; //router ko path
    }


}
