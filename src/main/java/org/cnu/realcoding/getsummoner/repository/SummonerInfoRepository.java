package org.cnu.realcoding.getsummoner.repository;

import org.cnu.realcoding.getsummoner.domain.SummonerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class SummonerInfoRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public SummonerInfo insertSummonerInfo(SummonerInfo summonerInfo) {
        return mongoTemplate.insert(summonerInfo);
    }

    public SummonerInfo findSummonerInfoById(String summonerId) {
        Query query = new Query();

        query.addCriteria(Criteria.where("name").is(summonerId));
        query.with(Sort.by(Sort.Order.desc("_id")));

        return mongoTemplate.findOne(query, SummonerInfo.class);
    }
}