package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.myrecipeapp.myrecipeapp.exceptions.MyUserNotFoundException;
import xyz.myrecipeapp.myrecipeapp.model.User;
import xyz.myrecipeapp.myrecipeapp.repositories.UserRepository;

import java.util.List;

@Service
public class UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new MyUserNotFoundException("User with username " + username + " was not found!"));
    }
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new MyUserNotFoundException("User with id " + id + " was not found!"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }
}
