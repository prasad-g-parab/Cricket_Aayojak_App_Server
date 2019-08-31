package com.aayojak.teamStats;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.aayojak.user.User;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@Table(name = "teamstats")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class teamStats {
    
    @Id
    @Column
    Long teamId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    User user;
    
    int totalMatches;
    int matchesWon;
    int matchesLost;
    int matchesTie;
    int matchesNoResult;
    
    @Type( type = "json" )
    @Column( columnDefinition = "json" )
    private List<String> titles;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getMatchesTie() {
        return matchesTie;
    }

    public void setMatchesTie(int matchesTie) {
        this.matchesTie = matchesTie;
    }

    public int getMatchesNoResult() {
        return matchesNoResult;
    }

    public void setMatchesNoResult(int matchesNoResult) {
        this.matchesNoResult = matchesNoResult;
    }

}
