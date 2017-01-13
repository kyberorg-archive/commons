package net.virtalab.commons.test;

import net.virtalab.commons.Bundle;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

/**
 * Testing methods
 *
 * @since 1.0
 */

public class BundleClassTest {
    @Test
    public void noPayloadPresentRightAfterInit() {
        Bundle bundle = Bundle.getInstance();
        assertTrue(bundle.isEmpty());
    }


    @Test(expected = IllegalArgumentException.class)
    public void cannotPutWithNullKey(){
        Bundle bundle = Bundle.getInstance();
        bundle.putObject(null, new Object());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotPutAnythingWithEmptyKey() {
        Bundle bundle = Bundle.getInstance();
        bundle.putObject("", new Object());
    }

    @Test(expected = NoSuchElementException.class)
    public void cannotGetAnythingWithEmptyKey(){
       Bundle bundle = Bundle.getInstance();
       bundle.getString("");
    }
}
