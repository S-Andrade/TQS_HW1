
package com.ua.airQuality.repositories;
import com.ua.airQuality.models.air.Pollution;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PollutionRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PollutionRepository pollutionRepository;
    
    @Test
    public void whenFindAllByCountryAndStateAndCity_thenReturnListPollution(){
        Pollution aveiro = new Pollution();
        aveiro.setCity("Aveiro");
        aveiro.setState("Aveiro");
        aveiro.setCountry("Portugal");
        Pollution oliveirinha = new Pollution();
        oliveirinha.setCity("Oliveirinha");
        oliveirinha.setState("Aveiro");
        oliveirinha.setCountry("Portugal");
        Pollution porto = new Pollution();
        porto.setCity("Porto");
        porto.setState("Porto");
        porto.setCountry("Portugal");
        
        entityManager.persist(aveiro);
        entityManager.persist(oliveirinha);
        entityManager.persist(porto);
        
        List<Pollution> pollution = pollutionRepository.findAllPollutionByCountryAndStateAndCity("Portugal", "Aveiro","Aveiro");
        
        assertThat(pollution).hasSize(1).extracting(Pollution::getCity).containsOnly(aveiro.getCity());
        
    }
    
    @Test
    public void whenInvalidCity_thenReturnEmptyList(){
        List<Pollution> pollution = pollutionRepository.findAllPollutionByCountryAndStateAndCity("Portugal", "Aveiro","doesNotExist");
        assertThat(pollution).isEmpty();
    }

    @Test
    public void whenInvalidState_thenReturnEmptyList(){
       List<Pollution> pollution = pollutionRepository.findAllPollutionByCountryAndStateAndCity("Portugal", "doesNotExist","Aveiro");
        assertThat(pollution).isEmpty();
    }

    @Test
    public void whenInvalidCountry_thenReturnEmptyList(){
       List<Pollution> pollution = pollutionRepository.findAllPollutionByCountryAndStateAndCity("doesNotExist", "Aveiro","Aveiro");
        assertThat(pollution).isEmpty();
    }
    
    @Test
    public void whenFindAll_thenReturnListAllPollution(){
        Pollution aveiro = new Pollution();
        aveiro.setCity("Aveiro");
        aveiro.setState("Aveiro");
        aveiro.setCountry("Portugal");
        Pollution oliveirinha = new Pollution();
        oliveirinha.setCity("Oliveirinha");
        oliveirinha.setState("Aveiro");
        oliveirinha.setCountry("Portugal");
        Pollution porto = new Pollution();
        porto.setCity("Porto");
        porto.setState("Porto");
        porto.setCountry("Portugal");
        entityManager.persist(aveiro);
        entityManager.persist(oliveirinha);
        entityManager.persist(porto);
        
        List<Pollution> pollution = pollutionRepository.findAll();
        
        assertThat(pollution).hasSize(3).extracting(Pollution::getCity).containsOnly(aveiro.getCity(),oliveirinha.getCity(),porto.getCity());
        
    }
    
    
}
