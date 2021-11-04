package br.com.geninho.api.resources;

import br.com.geninho.api.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> FindById(@PathVariable Integer id){
        return ResponseEntity.ok().body(new User(1,"geninho","geninho@email.com","123"));
    }
}
