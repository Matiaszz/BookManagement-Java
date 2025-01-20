package dev.matias.bookManagement.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dev.matias.bookManagement.dto.ResponseMessage;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity<ResponseMessage> create(@RequestBody UserModel userModel) {

        if (userModel.getUsername().length() > 50) {
            return ResponseEntity.badRequest().body(new ResponseMessage(
                    "Username can't have more of 50 characters.", null, 400));
        }
        var hashedPassword = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(hashedPassword.toString());

        var userCreated = this.userRepository.save(userModel);

        return ResponseEntity.ok().body(new ResponseMessage("User created successfully", userCreated, 200));
    }
}
