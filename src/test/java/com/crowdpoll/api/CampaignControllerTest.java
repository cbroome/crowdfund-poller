package com.crowdpoll.api;

import com.crowdpoll.donorsChoose.repositories.DonorsChooseProposalRepository;
import com.crowdpoll.entities.Campaign;
import com.crowdpoll.kiva.repositories.KivaCampaignRepository;
import com.crowdpoll.repositories.CampaignImageRepository;
import com.crowdpoll.repositories.CampaignRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class CampaignControllerTest {

    @InjectMocks
    CampainController campaignController;

    @Mock
    CampaignRepository campainRepository;

    @Mock
    DonorsChooseProposalRepository donorsChooseProposalRepository;

    @Mock
    KivaCampaignRepository kivaCampaignRepository;

    @Mock
    CampaignImageRepository campaignImageRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldCallGetActive() {
        List<Campaign> campaigns = new ArrayList<Campaign>();
        CampainController campainController = mock(CampainController.class);
        when(campainController.activeCampaigns()).thenReturn(campaigns);
        assert( campainController.getActive() ).equals( campaigns );
    }





    @Test
    public void shouldCallFindAllByEndDateGreaterThan() throws Exception {




    }

}
