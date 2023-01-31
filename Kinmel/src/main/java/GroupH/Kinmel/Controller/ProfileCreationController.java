package GroupH.Kinmel.Controller;

import GroupH.Kinmel.Entity.ProfileCreation;
import GroupH.Kinmel.Pojo.ProfileCreationPojo;
import GroupH.Kinmel.Services.Interface.ProfileCreationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")

public class ProfileCreationController {
    private final ProfileCreationService profileCreationService;

    @GetMapping("/list")
    public String getUserList(Model model){
        List<ProfileCreation> users = profileCreationService.fetchAll();
        model.addAttribute("userList", users);

        return ("User/index");
    }

    @GetMapping("/profile/ProfileCreation")
    public String getPage(){
        return "profile/ProfileCreation";
    }

    @GetMapping("/ProfileCreation")
    public String createUser(Model model){
        model.addAttribute("user", new ProfileCreationPojo());
        return ("profile-creation");
    }

    @PostMapping("/save")
    public String saveUser(@Valid ProfileCreationPojo userPojo){
        profileCreationService.save(userPojo);
        return "redirect:/profile/list";
    }
}
