package com.crowdpoll.twitter;

import com.crowdpoll.kiva.KivaTasklet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TwitterTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(KivaTasklet.class);

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {

        log.info( "Twitter Tasklet" );
        return null;
    }
}
