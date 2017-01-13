package net.virtalab.commons;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Storage for various types
 *
 * @author Alexander Muravya (alexander.muravya@kuehne-nagel.com)
 * @since 1.0
 */
public class Bundle {

    private Map<String, Object> map = new HashMap<>();

    private static final String NO_DEFAULT_VALUE_MARKER = "MARKER";

    public static Bundle getInstance() {
        return new Bundle();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void putObject(String key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be <null>");
        }
        if (key.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty key is weird. Cannot store anything using empty key");
        }
        map.put(key, value);
    }

    public void putString(String myKey, String defaultString) {
        putObject(myKey, defaultString);
    }

    public String getString(String key) throws NoSuchElementException, IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be <null>");
        }
        String str = getString(key, NO_DEFAULT_VALUE_MARKER);
        if (Objects.equals(str, NO_DEFAULT_VALUE_MARKER)) {
            throw new NoSuchElementException("No element stored under key: " + key);
        }
        return str;
    }

    public String getString(String key, String defaultValue) {
        Object o = map.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (String) o;
        } catch (ClassCastException cce) {
            //TODO warning
            if(Objects.equals(defaultValue, NO_DEFAULT_VALUE_MARKER)){
                throw cce;
            }
            return defaultValue;
        }
    }
}
