package com.greensquid.DevServers.model;

import javax.persistence.*;

@Entity
@Table(name = "servers")
public class Servers extends AbstractModel {
    @Column(name = "name_server", length = 80)
    private String name_server;

    @Column(name = "description", length = 80)
    private String description;

    @Column(name = "status")
    private boolean status;


    public String getName_server() {
        return name_server;
    }

    public void setName_server(String name_server) {
        this.name_server = name_server;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
