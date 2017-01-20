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
        Bundle bundle = Bundle.createEmptyBundle();
        assertTrue(bundle.isEmpty());
    }


    @Test(expected = IllegalArgumentException.class)
    public void cannotPutWithNullKey(){
        Bundle bundle = Bundle.createEmptyBundle();
        bundle.put(null, new Object());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotPutAnythingWithEmptyKey() {
        Bundle bundle = Bundle.createEmptyBundle();
        bundle.put("", new Object());
    }

    @Test(expected = NoSuchElementException.class)
    public void cannotGetAnythingWithEmptyKey(){
       Bundle bundle = Bundle.createEmptyBundle();
       bundle.getString("");
    }

    @Test
    public void gettingDefaultValueInsteadOfExceptionWhenNoValueFound() {
        String myKey = "MY_KEY";
        String defaultString = "DEFAULT_STR";
        Bundle bundle = Bundle.createEmptyBundle();

        bundle.putString(myKey, defaultString);
        String actualString = bundle.getString(myKey, defaultString);

        assertTrue(actualString.equals(defaultString));
    }

    @Test(expected = ClassCastException.class)
    public void gettingObjectOfWrongTypeShouldRaiseException(){
        String myKey = "MY_KEY";
        Object objToStore = new Object();

        Bundle bundle = Bundle.createEmptyBundle();
        bundle.put(myKey, objToStore);

        String str = bundle.getString(myKey);
    }
}
