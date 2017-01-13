package net.virtalab.commons.test;

import net.virtalab.commons.Bundle;
import org.junit.Test;

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

    public void cannotPutWithNullKey(){
        Bundle bundle = Bundle.getInstance();
        bundle.putObject(null, new Object());
    }
}
