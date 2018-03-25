package com.crowdpoll.kiva;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class KivaTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(KivaTasklet.class);

    @Autowired
    protected KivaService kivaService;


    public void setKivaService( KivaService kivaService ) {
        this.kivaService = kivaService;
    }

    public KivaService getKivaService() {
        return kivaService;
    }


    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        log.info( "Kiva Tasklet" );

        try {
            kivaService.pollForCampaigns();
        } catch (Exception e) {
            log.error( e.getLocalizedMessage() );
        }

        return null;
    }
}
