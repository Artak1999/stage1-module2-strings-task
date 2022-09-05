package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String[] s = source.split(delimiters.toString());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if(s[i].length() > 0)
                result.add(s[i]);
        }
        return result;
    }
}
