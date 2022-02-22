package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.myrecipeapp.myrecipeapp.exceptions.MyUserNotFoundException;
import xyz.myrecipeapp.myrecipeapp.model.User;
import xyz.myrecipeapp.myrecipeapp.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new MyUserNotFoundException("User by username " + username + " was not found!"));
    }
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new MyUserNotFoundException("User by id " + id + " was not found!"));
    }

    public void deleteUser(String username) {
        userRepository.deleteUserByUsername(username);
    }
}
