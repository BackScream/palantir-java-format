package com.palantir.javaformat.intellij.utils;

import com.intellij.openapi.projectRoots.Sdk;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SdkVersionComparator implements Comparator<Sdk> {
    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\d+)");

    @Override
    public int compare(Sdk sdk1, Sdk sdk2) {
        int mainVersion1 = extractMainVersion(sdk1.getVersionString());
        int mainVersion2 = extractMainVersion(sdk2.getVersionString());
        return Integer.compare(mainVersion1, mainVersion2);
    }

    public static int extractMainVersion(String versionString) {
        Matcher matcher = VERSION_PATTERN.matcher(versionString);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }
}