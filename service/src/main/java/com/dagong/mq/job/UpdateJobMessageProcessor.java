package com.dagong.mq.job;

import com.alibaba.rocketmq.common.message.MessageExt;
import com.dagong.mq.MessageProcessor;
import com.dagong.pojo.Company;
import com.dagong.pojo.Job;
import com.dagong.service.CompanyService;
import com.dagong.service.JobService;
import com.dagong.service.SearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuchang on 16/4/16.
 */

@Service
public class UpdateJobMessageProcessor extends MessageProcessor {

    @Resource
    private JobService jobService;
    @Resource
    private CompanyService companyService;

    public UpdateJobMessageProcessor() {
        this.setTopic("job");
        this.setTag("updateStatus");
    }

    @Override
    protected void process(List<MessageExt> list) {
        List<Job> jobList = new ArrayList<>();
        list.forEach(messageExt -> {
            System.out.println("messageExt = " + messageExt.getTags());
            try {
                String jobId = new String(messageExt.getBody(), "UTF-8");
                Job job = jobService.getJobFromDB(jobId);
                if (job != null) {
                    String companyId = job.getCompanyId();
                    Company company = companyService.getCompanyById(companyId);
                    job.setCompanyName(company.getName());
                    jobList.add(job);

                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        });
        jobService.updateJobInIndex(jobList);

    }
}
