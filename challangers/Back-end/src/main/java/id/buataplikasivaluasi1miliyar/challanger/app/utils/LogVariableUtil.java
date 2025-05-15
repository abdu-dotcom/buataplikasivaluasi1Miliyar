package id.buataplikasivaluasi1miliyar.challanger.app.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class LogVariableUtil {

    public static String log(String varName, Object value) {

        // jika valu nya null
        if (value == null) {
            return String.format("Variable '%s' = null (Type: null)", varName);
        }

        String type = value.getClass().getSimpleName();
        String valueStr = "";

        // Array
        if (value.getClass().isArray()) {
            int length = Array.getLength(value);
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < length; i++) {
                sb.append(Array.get(value, i));
                if (i < length - 1) sb.append(", ");
            }
            sb.append("]");
            valueStr = sb.toString();

        // Collection (List, Set, etc.)
        } else if (value instanceof Collection) {
            Collection<?> collection = (Collection<?>) value;
            valueStr = collection.toString() + " (size: " + collection.size() + ")";

            // Map
        } else if (value instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) value;
            valueStr = map.toString() + " (size: " + map.size() + ")";

            // Primitive or object with toString
        } else {
            valueStr = value.toString();
        }

        return String.format("Variable '%s' = %s (Type: %s)", varName, valueStr, type);
    }

    // Optional: log multiple vars at once
    public static String log(Object... pairs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pairs.length; i += 2) {
            String varName = String.valueOf(pairs[i]);
            Object value = i + 1 < pairs.length ? pairs[i + 1] : null;
            sb.append(log(varName, value)).append(" | ");
        }
        return sb.toString();
    }
}
