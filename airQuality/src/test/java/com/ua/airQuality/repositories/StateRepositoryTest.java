
package com.ua.airQuality.repositories;

import com.ua.airQuality.models.location.State;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StateRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StateRepository stateRepository;
    
    @Test
    public void whenFindAllByCountry_thenReturnListStates(){
        State aveiro = new State("Aveiro","Portugal");
        State tokyo = new State("Tokyo","Japan");
        State porto = new State("Porto","Portugal");
        
        entityManager.persist(aveiro);
        entityManager.persist(tokyo);
        entityManager.persist(porto);
        
        List<State> states = stateRepository.findAllByCountry("Portugal");
        
        assertThat(states).hasSize(2).extracting(State::getState).containsOnly(aveiro.getState(),porto.getState());
        
    }
    
    @Test
    public void whenInvalidCountry_thenReturnEmptyList(){
        List<State> states = stateRepository.findAllByCountry("doesNotExist");
        assertThat(states).isEmpty();
    }
    
    @Test
    public void whenFindAll_thenReturnListAllStates(){
        State aveiro = new State("Aveiro","Portugal");
        State tokyo = new State("Tokyo","Japan");
        State porto = new State("Porto","Portugal");
        
        entityManager.persist(aveiro);
        entityManager.persist(tokyo);
        entityManager.persist(porto);
        
        List<State> states = stateRepository.findAll();
        
        assertThat(states).hasSize(3).extracting(State::getState).containsOnly(aveiro.getState(),porto.getState(),tokyo.getState());
        
    }
    
    
}
