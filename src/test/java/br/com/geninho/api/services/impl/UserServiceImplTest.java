package br.com.geninho.api.services.impl;

import br.com.geninho.api.domain.User;
import br.com.geninho.api.domain.dto.UserDTO;
import br.com.geninho.api.repositories.UserRepository;
import br.com.geninho.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NAME = "geninho";
    public static final String EMAIL = "geninho@email.com";
    public static final String PASSWORD = "123";
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenRetunAnUserInstance() {
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);
        User response = service.findById(ID);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(User.class, response.getClass()); //compara se as respostas são iguais / mesma classe
        Assertions.assertEquals(ID, response.getId()); // (ESPERADO, REPOSTA)
        Assertions.assertEquals(NAME, response.getName());
        Assertions.assertEquals(EMAIL, response.getEmail());
        Assertions.assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException(){
        Mockito.when(repository.findById(Mockito.anyInt())).thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));
        try{
            service.findById(ID);
        } catch (Exception ex){
            Assertions.assertEquals(ObjectNotFoundException.class, ex.getClass());
            Assertions.assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAnListOfUsers() {
        Mockito.when(repository.findAll()).thenReturn(List.of(user));

        List<User> response = service.findAll();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1,response.size());
        Assertions.assertEquals(User.class, response.get(0).getClass());

        Assertions.assertEquals(ID,response.get(0).getId());
        Assertions.assertEquals(NAME,response.get(0).getName());
        Assertions.assertEquals(EMAIL,response.get(0).getEmail());
        Assertions.assertEquals(PASSWORD,response.get(0).getPassword());

    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));

    }
}