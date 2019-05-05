package org.cnu.realcoding.getsummoner.controller;

import org.cnu.realcoding.getsummoner.api.OpenSummonerInfoByNameApiClient;
import org.cnu.realcoding.getsummoner.domain.SummonerInfo;
import org.cnu.realcoding.getsummoner.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/summoner-info")
public class SummonerController {
    @Autowired
    private SummonerService summonerService;

    @GetMapping("/summoner-info/id-by-name")
    public String getSummonerInfoByName(){
        return summonerService.getSummonerIdByName();
    }

    @GetMapping("/summoner-info/info-by-id")
    public SummonerInfo getSummonerinfoById(@PathVariable String id){
        return summonerService.getSummonerInfo(id);
    }
}
