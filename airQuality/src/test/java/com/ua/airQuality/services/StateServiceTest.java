/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.airQuality.services;

import com.ua.airQuality.models.location.State;
import com.ua.airQuality.repositories.StateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class StateServiceTest {
    
    @Mock( lenient = true)
    private StateRepository repository;

    @InjectMocks
    private StateService service;
    
    @BeforeEach
    public void setUp() {
        State aveiro = new State("Aveiro","Portugal");
        State porto = new State("Porto","Portugal");
        State tokyo = new State("Tokyo","Japan");
        List<State> aveiroList = Arrays.asList(aveiro);
        List<State> allStates = Arrays.asList(aveiro,porto,tokyo);
        //Mockito.when(repository.findAllByCountry(aveiro.getCountry())).thenReturn(aveiroList);
        Mockito.when(repository.findAll()).thenReturn(allStates);
    }
    
    @Test
     public void getAllStates_returnAllStates() {
        State aveiro = new State("Aveiro","Portugal");
        State porto = new State("Porto","Portugal");
        State tokyo = new State("Tokyo","Japan");
        
        List<State> allStates = service.getAllStates();
        
        verifyFindAllStateIsCalledOnce();
        assertThat(allStates).hasSize(3).extracting(State::getState).contains(aveiro.getState(),porto.getState(),tokyo.getState());
    }
   
    private void verifyFindAllStateIsCalledOnce() {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(repository);
    }
    
    /*
    @Test
    public void whenValidCountry_thenStatesShouldBeFound() {
        State tokyo = new State("Tokyo","Japan");
        List<State> states = service.getStatesByCountry(tokyo.getCountry());
        assertThat(states).hasSize(1).extracting(State::getState).contains(tokyo.getState());
    }

    @Test
    public void whenInValidCountry_thenStatesShouldBeEmpty() {
        List<State> states = service.getStatesByCountry("Korea");
        assertThat(states).isEmpty();

        verifyFindByCountryIsCalledOnce("Korea");
    }
    
    private void verifyFindByCountryIsCalledOnce(String country) {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAllByCountry(country);
        Mockito.reset(repository);
    }
    */
}
