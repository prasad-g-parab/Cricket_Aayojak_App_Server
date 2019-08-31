package com.aayojak.tournament;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.aayojak.team.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    int tournamentId;
    @Column
    String tournamentName;
    @Column
    int entryFees;

    @Column
    int reEntryFees;
    
    @Column
    boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "teamId")
    Team oraganisingTeam;

    @Column
    LocalDate startDate;

    @Column
    LocalDate endDate;

    @Column
    int prize1_ammount;

    @Column
    int prize2_ammount;

    @Column
    int prize3_ammount;

    @Column
    String prize1_desc;

    @Column
    String prize2_desc;

    @Column
    String prize3_desc;

    @Column
    int teamPlyaerCount;

    @Column
    int squadPlayingCount;

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public int getEntryFees() {
        return entryFees;
    }

    public void setEntryFees(int entryFees) {
        this.entryFees = entryFees;
    }

    public int getReEntryFees() {
        return reEntryFees;
    }

    public void setReEntryFees(int reEntryFees) {
        this.reEntryFees = reEntryFees;
    }

    public boolean isDisabled() {
        return active;
    }

    public void setDisabled(boolean isDisabled) {
        this.active = isDisabled;
    }

    public Team getOraganisingTeam() {
        return oraganisingTeam;
    }

    public void setOraganisingTeam(Team oraganisingTeam) {
        this.oraganisingTeam = oraganisingTeam;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPrize1_ammount() {
        return prize1_ammount;
    }

    public void setPrize1_ammount(int prize1_ammount) {
        this.prize1_ammount = prize1_ammount;
    }

    public int getPrize2_ammount() {
        return prize2_ammount;
    }

    public void setPrize2_ammount(int prize2_ammount) {
        this.prize2_ammount = prize2_ammount;
    }

    public int getPrize3_ammount() {
        return prize3_ammount;
    }

    public void setPrize3_ammount(int prize3_ammount) {
        this.prize3_ammount = prize3_ammount;
    }

    public String getPrize1_desc() {
        return prize1_desc;
    }

    public void setPrize1_desc(String prize1_desc) {
        this.prize1_desc = prize1_desc;
    }

    public String getPrize2_desc() {
        return prize2_desc;
    }

    public void setPrize2_desc(String prize2_desc) {
        this.prize2_desc = prize2_desc;
    }

    public String getPrize3_desc() {
        return prize3_desc;
    }

    public void setPrize3_desc(String prize3_desc) {
        this.prize3_desc = prize3_desc;
    }

    public int getTeamPlyaerCount() {
        return teamPlyaerCount;
    }

    public void setTeamPlyaerCount(int teamPlyaerCount) {
        this.teamPlyaerCount = teamPlyaerCount;
    }

    public int getSquadPlayingCount() {
        return squadPlayingCount;
    }

    public void setSquadPlayingCount(int squadPlayingCount) {
        this.squadPlayingCount = squadPlayingCount;
    }
    


    
}
