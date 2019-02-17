package com.greensquid.DevServers.repository;

import com.greensquid.DevServers.model.Servers;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServersRepository extends JpaRepository<Servers, Long> {
}
