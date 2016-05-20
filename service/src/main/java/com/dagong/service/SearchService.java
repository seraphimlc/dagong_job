package com.dagong.service;

import com.alibaba.fastjson.JSON;
import com.dagong.pojo.Company;
import com.dagong.pojo.Job;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liuchang on 16/4/5.
 */
@Service
public class SearchService {

    private TransportClient transportClient = null;
    private static final int PAGE_SIZE=10;

    public SearchService(){
        try {
            transportClient = TransportClient.builder().build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("172.16.54.144"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public List<Map> searchJobByType(String[] jobTypes,int page){
        List<Map> jobs = new ArrayList<>();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        for(String jobType:jobTypes){
            queryBuilder.should(QueryBuilders.matchQuery("jobType",jobType));
        }
        SearchResponse searchResponse = transportClient.prepareSearch("test")
                .setTypes("job")
                .setQuery(queryBuilder)
                .setFrom(page)
                .setSize(PAGE_SIZE)
                .execute()
                .actionGet();
        System.out.println("searchResponse = " + searchResponse);
        for (SearchHit searchHitFields : searchResponse.getHits().getHits()) {
            jobs.add(searchHitFields.getSource());
        }
        return jobs;
    }


    public Map getJob(String jobId){
        GetResponse response = transportClient.prepareGet("test", "job", jobId).execute().actionGet();
        if(response.isExists()){
            return response.getSource();
        }
        return null;
    }

    public boolean addUserFollowJobToIndex(){
        return true;
    }

    public boolean addJobToIndex(List<Job> jobList){
        if(jobList==null||jobList.isEmpty()){
            return false;
        }
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        jobList.forEach(job -> {

            bulkRequestBuilder.add(transportClient.prepareIndex("test", "job", job.getId()).setSource(JSON.toJSONString(job)));
        });
        BulkResponse bulkItemResponses = bulkRequestBuilder.execute().actionGet();

        return true;
    }

    public boolean updateJobInIndex(List<Job> jobList){
        if(jobList==null||jobList.isEmpty()){
            return false;
        }
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        jobList.forEach(job -> {
            bulkRequestBuilder.add(transportClient.prepareUpdate("test", "job", job.getId()).setDoc(JSON.toJSONString(job)));
        });
        BulkResponse bulkItemResponses = bulkRequestBuilder.execute().actionGet();

        return true;
    }


}
