package org.cnu.realcoding.getsummoner.service;

import lombok.extern.slf4j.Slf4j;
import org.cnu.realcoding.getsummoner.api.OpenSummonerInfoByIdApiClient;
import org.cnu.realcoding.getsummoner.api.OpenSummonerInfoByNameApiClient;
import org.cnu.realcoding.getsummoner.domain.SummonerInfo;
import org.cnu.realcoding.getsummoner.repository.SummonerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SummonerService {

    @Autowired
    private OpenSummonerInfoByIdApiClient openSummonerInfoByIdApiClient;
    @Autowired
    private OpenSummonerInfoByNameApiClient openSummonerInfoByNameApiClient;
    @Autowired
    private SummonerInfoRepository summonerInfoRepository;

    public String getSummonerIdByName(){
        return openSummonerInfoByNameApiClient.getSummonerInfo().getId();
    }

    @Bean
    public void getSummonerInfoByID() {

        String SummonerId = this.openSummonerInfoByNameApiClient.getSummonerInfo().getId();

        SummonerInfo summonerInfo = openSummonerInfoByIdApiClient.getSummonerInfo(SummonerId);

        SummonerInfo insertedSummonerInfo = summonerInfoRepository.insertSummonerInfo(summonerInfo);

        log.info("SummonerInfo has inserted successfully. SummonerInfo : {}", insertedSummonerInfo);
    }

    public SummonerInfo getSummonerInfo(String id){
        return summonerInfoRepository.findSummonerInfoById(id);
    }


}
