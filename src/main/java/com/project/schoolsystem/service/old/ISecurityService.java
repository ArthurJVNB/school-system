package com.project.schoolsystem.service.old;

public interface ISecurityService {
    String findLoggedInUsername();
    void autologin(String username, String password);
}
