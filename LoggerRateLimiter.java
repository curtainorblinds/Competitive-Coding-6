import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 359. Logger Rate Limiter
 * Link: https://leetcode.com/problems/logger-rate-limiter/description/
 */
public class LoggerRateLimiter {
    /**
     * Main functions needed in this design are lookup of existing message and either update its timestamp to latest
     * or not. Both of this can be achieved in O(1) through hashmap.
     *
     * TC for shouldPrintMessage: O(1)
     * SC for shouldPrintMessage: O(1) as no auxiliary space being used inside the function
     */
    private Map<String, Integer> messages;
    public LoggerRateLimiter() {
        this.messages = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!messages.containsKey(message)) {
            messages.put(message, timestamp);
            return true;
        }

        if (timestamp - messages.get(message) >= 10) {
            messages.put(message, timestamp);
            return true;
        }

        return false;
    }
}
