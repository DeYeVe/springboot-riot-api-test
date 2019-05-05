package org.cnu.realcoding.getsummoner.domain;

import lombok.Data;

@Data
public class SummonerInfo {
    private int profileIconId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private String id;
    private String accountId;
    private long revisionDate;
}
