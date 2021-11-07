package br.com.geninho.api.services;

import br.com.geninho.api.domain.User;
import br.com.geninho.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
}
