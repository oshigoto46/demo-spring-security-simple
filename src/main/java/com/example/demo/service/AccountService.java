package com.example.demo.service;

import com.example.demo.entity.User2;

import java.util.List;

public interface AccountService {
  List<User2> findAll();
  void register(String name, String email, String password, String[] roles);
}
