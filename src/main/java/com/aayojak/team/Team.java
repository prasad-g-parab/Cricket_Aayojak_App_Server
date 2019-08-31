package com.aayojak.team;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;

import com.aayojak.user.User;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@Table(name = "team")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Team implements Serializable{



   @Id
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName="user_id")
    User team;

    @Column
    String teamName;
    @Column
    String teamAddress;
    @Column
    String teamCaptainName;



    public User getTeam() {
        return team;
    }

    public void setTeam(User user) {
        this.team = user;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamAddress() {
        return teamAddress;
    }

    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress;
    }

    public String getTeamCaptainName() {
        return teamCaptainName;
    }

    public void setTeamCaptainName(String teamCaptainName) {
        this.teamCaptainName = teamCaptainName;
    }

}
