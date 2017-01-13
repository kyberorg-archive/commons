package net.virtalab.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Storage for various types
 *
 * @author Alexander Muravya (alexander.muravya@kuehne-nagel.com)
 * @since 1.0
 */
public class Bundle {

    private Map<String, Object> map = new HashMap<>();

    public static Bundle getInstance() {
        return new Bundle();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void putObject(String key, Object value) {
        map.put(key, value);
    }
}
