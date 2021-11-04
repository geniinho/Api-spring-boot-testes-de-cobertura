package br.com.geninho.api.services;

import br.com.geninho.api.domain.User;

public interface UserService {
    User findById(Integer id);
}
