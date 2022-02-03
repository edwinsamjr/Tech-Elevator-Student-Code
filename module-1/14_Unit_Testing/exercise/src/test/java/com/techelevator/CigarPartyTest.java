package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    @Test
    public void false_if_39_cigars() {
        CigarParty cigarParty = new CigarParty();
        boolean partySuccessful = cigarParty.haveParty(39, false);
        Assert.assertFalse("Unsuccessful party returned true", partySuccessful);
    }

    @Test
    public void true_if_40_cigars() {
        CigarParty cigarParty = new CigarParty();
        boolean partySuccessful = cigarParty.haveParty(40, false);
        Assert.assertTrue("Successful party returned false", partySuccessful);
    }

    @Test
    public void true_if_60_cigars() {
        CigarParty cigarParty = new CigarParty();
        boolean partySuccessful = cigarParty.haveParty(60, false);
        Assert.assertTrue("Successful party returned false", partySuccessful);
    }

    @Test
    public void true_if_61_cigars_and_weekend() {
        CigarParty cigarParty = new CigarParty();
        boolean partySuccessful = cigarParty.haveParty(61, true);
        Assert.assertTrue("Successful party returned false", partySuccessful);
    }

    @Test
    public void false_if_61_cigars_and_not_weekend() {
        CigarParty cigarParty = new CigarParty();
        boolean partySuccessful = cigarParty.haveParty(61, false);
        Assert.assertFalse("Unsuccessful party returned true", partySuccessful);
    }

}
