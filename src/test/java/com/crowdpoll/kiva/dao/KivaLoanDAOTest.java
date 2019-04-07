package com.crowdpoll.kiva.dao;

import org.junit.Test;
import static org.junit.Assert.*;

public class KivaLoanDAOTest {

    @Test
    public void shouldReturnAURL() {
        KivaLoanDAO kivaLoanDAO = new KivaLoanDAO();
        kivaLoanDAO.setId( new Long( 10 ) );
        assertFalse( kivaLoanDAO.getPublicURL().isEmpty() );
    }

}
