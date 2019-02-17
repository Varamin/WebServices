package com.greensquid.DevServers.service;

import com.greensquid.DevServers.model.Servers;
import com.greensquid.DevServers.repository.ServersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServersService {

    @Autowired
    private ServersRepository repository;

    public Integer getCountServers() {
        return Math.toIntExact(repository.count());
    }

    @Transactional
    public List<Servers> getAllServers() {
        return (List<Servers>) repository.findAll();
    }

}
