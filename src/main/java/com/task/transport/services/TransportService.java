package com.task.transport.services;

import com.task.transport.models.Transport;

import com.task.transport.repositories.TransportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {
   private final TransportRepository transportRepository;

    @Autowired
    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }


    public List<Transport> listTransports(String mark, String model,
                                          String category, String number, Integer year){
        if(mark == null &&  model== null &&  category== null &&  number== null &&  year==null){
            return transportRepository.findAll();
        }
        return transportRepository.findTransport(mark, model, category, number, year);
    }


    public boolean createTransport(Transport transport){
        String number = transport.getNumber();
        if(transportRepository.findByNumber(number)!= null){
            return false;
        }
        transportRepository.save(transport);
        return true;
    }


    public void changeTransport(Transport transport){
        transportRepository.save(transport);
    }

    public Transport getTransportById(Long id){
        return transportRepository.findById(id).orElse(null);
    }


}
