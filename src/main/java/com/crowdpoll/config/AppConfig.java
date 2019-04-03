package com.crowdpoll.config;

import com.crowdpoll.JobCompletionNotificationListener;
import com.crowdpoll.PollJobIncrementer;
import com.crowdpoll.donorsChoose.DonorsChooseService;
import com.crowdpoll.donorsChoose.DonorsChooseTasklet;
import com.crowdpoll.donorsChoose.repositories.DonorsChooseProposalRepository;
import com.crowdpoll.kiva.KivaService;
import com.crowdpoll.kiva.KivaTasklet;
import com.crowdpoll.kiva.repositories.KivaCampaignRepository;
import com.crowdpoll.repositories.CampaignImageRepository;
import com.crowdpoll.repositories.CampaignRepository;
import com.crowdpoll.twitter.TwitterTasklet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableBatchProcessing
@ComponentScan(basePackages={"com.crowdpoll.kiva", "com.crowdpoll.donorsChoose"})
@EntityScan(basePackages = {"com.crowdpoll.kiva", "com.crowdpoll.donorsChoose", "com.crowdpoll.entities"} )
@EnableJpaRepositories(basePackages = {"com.crowdpoll.kiva", "com.crowdpoll.donorsChoose", "com.crowdpoll.repositories"})
public class AppConfig {

    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    protected JobBuilderFactory jobBuilderFactory;

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;

    @Autowired
    protected KivaCampaignRepository kivaCampaignRepository;

    @Autowired
    protected DonorsChooseProposalRepository donorsChooseProposalRepository;

    @Autowired
    protected CampaignRepository campaignRepository;

    @Autowired
    protected CampaignImageRepository campaignImageRepository;

/*
    @Bean
    public DataSource dataSource() {
        log.info("data source");

        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("schema.sql")
                .build();
    }
 */
    @Bean
    public Tasklet kivaTasklet() {
        KivaTasklet kt = new KivaTasklet();
        kt.setKivaService( kivaService() );
        return kt;
    }

    @Bean
    public Tasklet donorsChooseTasklet() {
        DonorsChooseTasklet dct = new DonorsChooseTasklet();
        dct.setDonorsChooseService( donorsChooseService() );
        return dct;
    }


    @Bean
    public Tasklet twitterTasklet() {
        TwitterTasklet tt = new TwitterTasklet();
        return tt;
    }

    @Bean
    public KivaService kivaService() {
        KivaService ks = new KivaService();
        ks.setKivaCampaignRepository( kivaCampaignRepository );
        ks.setCampaignRepository( campaignRepository );
        ks.setCampaignImageRepository(campaignImageRepository);
        return ks;
    }

    @Bean
    public DonorsChooseService donorsChooseService() {
        DonorsChooseService dcs = new DonorsChooseService();
        dcs.setDonorsChooseProposalRepository(donorsChooseProposalRepository);
        dcs.setCampaignRepository( campaignRepository );
        dcs.setCampaignImageRepository( campaignImageRepository );
        return dcs;
    }

/*

    @Bean
    public Step stepKiva() {
        log.info("Kiva step started");
        return stepBuilderFactory.get("step1")
                .tasklet(kivaTasklet())
                .build();
    }


    @Bean
    public Step stepDonorsChoose() {
        log.info("DonorsChoose step started");
        return stepBuilderFactory.get("step1")
                .tasklet(donorsChooseTasklet())
                .build();
    }
    */

    @Bean
    public Flow flowKivaPoll() {
        return new FlowBuilder<Flow>("kivaPollFlow")
                .start(stepBuilderFactory.get("pollKiva")
                        .tasklet(kivaTasklet())
                        .build())
                .build();
    }


    @Bean
    public Flow flowDonorsChoosePoll() {
        return new FlowBuilder<Flow>("donorsChooseFlow")
                .start(stepBuilderFactory.get("pollDonorsChoose")
                        .tasklet(donorsChooseTasklet())
                        .build())
                .build();
    }


    @Bean
    public Flow scheduleTweets() {
        return new FlowBuilder<Flow>("tweetFlow")
                .start(stepBuilderFactory.get("createTweets")
                    .tasklet(twitterTasklet())
                    .build())
                .build();
    }


    @Bean
    public Job importCampaignsFromExternal(JobCompletionNotificationListener listener) throws Exception {
        log.info("Job started");



        return jobBuilderFactory.get("job1")
                .incrementer(new PollJobIncrementer())
                .start(flowDonorsChoosePoll())
                .split(new SimpleAsyncTaskExecutor()).add(flowKivaPoll())
                .next(scheduleTweets())
                .end()
                .build();



    }


}
