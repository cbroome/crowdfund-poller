package com.crowdpoll.config;

import com.crowdpoll.JobCompletionNotificationListener;
import com.crowdpoll.kiva.KivaService;
import com.crowdpoll.kiva.KivaTasklet;
import com.crowdpoll.kiva.repositories.KivaCampaignRepository;
import com.crowdpoll.repositories.CampaignImageRepository;
import com.crowdpoll.repositories.CampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


import javax.sql.DataSource;


@Configuration
@EnableBatchProcessing
@ComponentScan(basePackages={"com.crowdpoll.kiva"})
@EntityScan(basePackages = {"com.crowdpoll.kiva","com.crowdpoll.entities"} )
@EnableJpaRepositories(basePackages = {"com.crowdpoll.kiva", "com.crowdpoll.repositories"})
public class AppConfig {

    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    protected JobBuilderFactory jobBuilderFactory;

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;

    @Autowired
    protected KivaCampaignRepository kivaCampaignRepository;

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
    public KivaService kivaService() {
        KivaService ks = new KivaService();
        ks.setKivaCampaignRepository( kivaCampaignRepository );
        ks.setCampaignRepository( campaignRepository );
        ks.setCampaignImageRepository(campaignImageRepository);
        return ks;
    }


    @Bean
    public Step stepKiva() {
        log.info("Step started");
        return stepBuilderFactory.get("step1")
                .tasklet(kivaTasklet())
                .build();
    }

    @Bean
    public Job importCampaignsFromExternal(JobCompletionNotificationListener listener) throws Exception {
        log.info("Job started");
        return jobBuilderFactory.get("job1")
                .incrementer(new RunIdIncrementer())
                .start(stepKiva())
                .build();

    }


}
