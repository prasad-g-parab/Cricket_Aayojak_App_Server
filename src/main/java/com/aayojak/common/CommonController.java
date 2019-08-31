package com.aayojak.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Util.ConversionUtil;
import com.aayojak.tournament.Tournament;
import com.aayojak.tournament.TournamentService;

import ch.qos.logback.core.pattern.ConverterUtil;

@RestController
@RequestMapping("api/common")
public class CommonController {

    @Autowired
    TournamentService tournamentService;

    @RequestMapping("/tournament")
    public List<Tournament> getTournaments(@RequestParam(value="active" , required = false) String isActive) {
        if (isActive == null) {
            return tournamentService.getTournaments();
        } else {
            return tournamentService.getTournaments(ConversionUtil.strictConvertSTringToBoolean(isActive));
        }
    }
}
