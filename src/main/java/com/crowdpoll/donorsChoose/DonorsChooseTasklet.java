package com.crowdpoll.donorsChoose;

import com.crowdpoll.kiva.KivaTasklet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class DonorsChooseTasklet implements Tasklet{

    private static final Logger log = LoggerFactory.getLogger(KivaTasklet.class);

    protected DonorsChooseService donorsChooseService;


    public DonorsChooseService getDonorsChooseService() {
        return donorsChooseService;
    }

    public void setDonorsChooseService(DonorsChooseService donorsChooseService) {
        this.donorsChooseService = donorsChooseService;
    }

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        log.info( "DonorsChoose Tasklet" );

        try {
            donorsChooseService.pollForCampaigns();
        } catch (Exception e) {
            log.error( e.getLocalizedMessage() );
        }

        return null;
    }
}
