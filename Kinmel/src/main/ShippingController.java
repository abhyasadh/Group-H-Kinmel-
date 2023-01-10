package GroupH.Kinmel.Controller;


import GroupH.Kinmel.Pojo.ShippingPojo;

import GroupH.Kinmel.Services.Interface.ShippingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/checkout")

public class ShippingController {
    private final ShippingService shippingService;



    @GetMapping("/checkout")
    public String createUser(Model model){
        model.addAttribute("checkout", new ShippingPojo());
        return "template/Checkout";
    }


    @PostMapping("/save")
    public String saveUser(@Valid ShippingPojo shippingPojo){
        shippingService.save(shippingPojo);
        return "redirect:/profile/list"; //router ko path
    }

}
