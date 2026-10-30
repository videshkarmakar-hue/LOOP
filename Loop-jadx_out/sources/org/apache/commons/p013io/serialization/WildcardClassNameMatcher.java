package org.apache.commons.p013io.serialization;

import org.apache.commons.p013io.FilenameUtils;

/* JADX INFO: loaded from: classes18.dex */
final class WildcardClassNameMatcher implements ClassNameMatcher {
    private final String pattern;

    public WildcardClassNameMatcher(String pattern) {
        this.pattern = pattern;
    }

    @Override // org.apache.commons.p013io.serialization.ClassNameMatcher
    public boolean matches(String className) {
        return FilenameUtils.wildcardMatch(className, this.pattern);
    }
}
