package google;

import com.sun.tools.javac.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class DistinctMails {

    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> emap = new HashMap<>();
        for (String email : emails) {
            String key = getEmail(email);
            if (!emap.containsKey(key)) {
                emap.put(key, 1);
            }
        }
        return emap.keySet().size();
    }

    private String getEmail(String original) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean skip = false;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == '@') {
                return formDomain(stringBuffer, original, i);
            } else if (original.charAt(i) == '+') {
                skip = true;
            } else if (original.charAt(i) != '.' && skip == false) {
                stringBuffer.append(original.charAt(i));
            }
        }
        return "";
    }

    private String formDomain(StringBuffer buffer, String original, int i) {
        for (; i < original.length(); i++) {
            buffer.append(original.charAt(i));
        }
        return buffer.toString();
    }
}
