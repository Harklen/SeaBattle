package seabattle.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        // Ваша логіка для збереження користувача у базі даних
        // Перевірте, чи користувача з таким ім'ям користувача вже існує
        if (userRepository.findByUsername(user.getUsername()) != null) {
            try {
                throw new Exception("User already exists");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return "redirect:/register?error";
        }

        // Зашифруйте пароль перед збереженням у базі даних
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Збереження користувача у базі даних
        userRepository.save(user);

        // Перенаправлення на сторінку входу після успішної реєстрації
        return "redirect:/login?success";
    }
}
