package xyz.myrecipeapp.myrecipeapp.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('CREATOR') or hasRole('EDITOR')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/editor")
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public String editorAccess() {
        return "Editor Board.";
    }

    @GetMapping("/creator")
    @PreAuthorize("hasRole('CREATOR') or hasRole('ADMIN')")
    public String creatorAccess() {
        return "Creator Board.";
    }
}
