package org.cnu.realcoding.getsummoner.api;

import org.cnu.realcoding.getsummoner.domain.SummonerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenSummonerInfoByNameApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-c47f9eb8-cba7-491f-8555-cc0fbbcc7ec3";
    private final String summonerName = "Hide on Bush";
    private final String currentSummonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={apiKey}";

    public SummonerInfo getSummonerInfo() {
        SummonerInfo summonerInfo = restTemplate.exchange(currentSummonerUrl, HttpMethod.GET, null, SummonerInfo.class, summonerName, apiKey)
                .getBody();

        return summonerInfo;

    }
}
