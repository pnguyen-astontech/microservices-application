package com.company.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by petenguy1 on 12/27/2016.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stateId")
    private Integer id;

    @Version
    private Integer version;

    private String stateName;
    private String stateAbbreviation;

    public State() {
    }

    public State(String stateName, String stateAbbreviation) {
        this.stateName = stateName;
        this.stateAbbreviation = stateAbbreviation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }
}
