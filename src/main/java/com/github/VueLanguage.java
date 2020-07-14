package com.github;

import com.intellij.lang.Language;

/**
 * @author Yan
 */
public class VueLanguage extends Language {
    public static final VueLanguage INSTANCE = new VueLanguage();
    private VueLanguage() {
        super("Shen");
    }
}
