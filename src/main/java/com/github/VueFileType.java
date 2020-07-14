package com.github;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author Yan
 */
public class VueFileType extends LanguageFileType {
    public static final VueFileType INSTANCE = new VueFileType();

    private VueFileType() {
        super(VueLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Shen file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Shen language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "element";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return VueIcons.FILE;
    }
}
