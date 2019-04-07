package com.crowdpoll.kiva;

import com.crowdpoll.entities.Campaign;
import com.crowdpoll.entities.CampaignImage;
import com.crowdpoll.kiva.dao.KivaImageDAO;
import com.crowdpoll.kiva.dao.KivaLoanDAO;
import com.crowdpoll.kiva.entities.KivaCampaign;
import com.crowdpoll.kiva.repositories.KivaCampaignRepository;
import com.crowdpoll.repositories.CampaignImageRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class KivaServiceTest {


    @InjectMocks
    KivaService kivaService;

    @Mock
    KivaCampaignRepository kivaCampaignRepository;

    @Mock
    CampaignImageRepository campaignImageRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldLinkToCampaign() {
        Campaign campaign = new Campaign();
        KivaLoanDAO kivaLoanDAO = new KivaLoanDAO();
        KivaCampaign kivaCampaign = new KivaCampaign();

        kivaLoanDAO.setId( new Long( 1 ) );
        kivaService.linkToCampaign( campaign, kivaLoanDAO );
        verify( kivaCampaignRepository ).save( any( KivaCampaign.class ) );
    }


    @Test
    public void shouldLinkToCampaignImage() {
        Campaign campaign = new Campaign();
        KivaLoanDAO kivaLoanDAO = new KivaLoanDAO();

        kivaLoanDAO.setId( new Long( 1 ) );
        kivaLoanDAO.setImage( new KivaImageDAO() );
        kivaService.linkToCampaignImage( campaign, kivaLoanDAO );
        verify( campaignImageRepository ).save( any( CampaignImage.class ) );
    }



}
