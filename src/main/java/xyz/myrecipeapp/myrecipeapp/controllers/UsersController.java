package xyz.myrecipeapp.myrecipeapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import xyz.myrecipeapp.myrecipeapp.model.ERole;
import xyz.myrecipeapp.myrecipeapp.model.Role;
import xyz.myrecipeapp.myrecipeapp.model.User;
import xyz.myrecipeapp.myrecipeapp.payload.request.SignupRequest;
import xyz.myrecipeapp.myrecipeapp.payload.request.UpdateRequest;
import xyz.myrecipeapp.myrecipeapp.payload.response.MessageResponse;
import xyz.myrecipeapp.myrecipeapp.repositories.RoleRepository;
import xyz.myrecipeapp.myrecipeapp.repositories.UserRepository;
import xyz.myrecipeapp.myrecipeapp.services.UsersService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
@PreAuthorize("hasRole('ADMIN')")
@Transactional
public class UsersController {

    private final UsersService usersService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/find/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User users = usersService.findUserByUsername(username);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is in use!"));
        }
        User newUser = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()));
        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(adminRole);
                        break;
                    case "creator":
                        Role creatorRole = roleRepository.findByName(ERole.ROLE_CREATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(creatorRole);
                        break;
                    case "editor":
                        Role editorRole = roleRepository.findByName(ERole.ROLE_EDITOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(editorRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(userRole);
                }
            });
        }
        newUser.setRoles(roles);
        userRepository.save(newUser);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    /*Not working :/ Duplicate entry 'admin' for key
    Working after deleting uniqueConstraints from User model class - Table annotation
    */
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UpdateRequest updateRequest, @PathVariable("id") Long id) {
        User updatedUser = usersService.findUserById(id);
        if (updatedUser == null){
            throw new RuntimeException("User with id " + id + " was not found!");
        }
        Set<String> strRoles = updateRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            roles.add(userRole);
        }
        else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(adminRole);
                        break;
                    case "creator":
                        Role creatorRole = roleRepository.findByName(ERole.ROLE_CREATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(creatorRole);
                        break;
                    case "editor":
                        Role editorRole = roleRepository.findByName(ERole.ROLE_EDITOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(editorRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(userRole);
                }
            });
        }
        String strUsername = updateRequest.getUsername();
        updatedUser.setUsername(strUsername);
        String strEmail = updateRequest.getEmail();
        updatedUser.setEmail(strEmail);
        encoder.encode(updatedUser.getPassword());
        updatedUser.setRoles(roles);
        userRepository.save(updatedUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        if (!userRepository.existsById(id)){
            return ResponseEntity
            .badRequest()
            .body(new MessageResponse("User with id " + id + " was not found!"));
        }
        usersService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
