package br.com.geninho.api.services;

import br.com.geninho.api.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
}
