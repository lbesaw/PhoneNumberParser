package com.liambesaw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneParser {

    public static PhoneNumber useRegex(String number) {
        Pattern p = Pattern.compile("^(?:(?:\\+?(?<countrycode>\\d+)\\s*(?:[.-]\\s*)?)?(?:\\(\\s*(?<areacode>\\d+)\\s*\\)|(?<areacodealt>[2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])?)\\s*(?:[.-]\\s*)?)?(?<prefix>\\d+)\\s*(?:[.-]\\s*)?(?<suffix>[0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(?<extension>\\d+))?$");
        Matcher matcher = p.matcher(number);
        matcher.matches();

        return new PhoneNumber(matcher.group("countrycode"), matcher.group("areacode"), matcher.group("prefix"), matcher.group("suffix"), matcher.group("extension"));
    }
}