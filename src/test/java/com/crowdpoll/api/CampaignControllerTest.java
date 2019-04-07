package com.crowdpoll.api;

import com.crowdpoll.entities.Campaign;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class CampaignControllerTest {


    @Test
    public void shouldCallGetActive() {
        List<Campaign> campaigns = new ArrayList<Campaign>();
        CampainController campainController = mock(CampainController.class);
        when(campainController.activeCampaigns()).thenReturn(campaigns);
        assert( campainController.getActive() ).equals( campaigns );
    }


}
