package com.github.constant;

/**
 * @author Yan
 */
public enum ComponentTagEnum {
    /**
     *
     */
    A_ROW("Row", "a-row"),
    A_COL("Col", "a-col"),
    A_LAYOUT("Layout", "a-layout"),
    A_LAYOUT_SIDER("LayoutSider", "a-layout-sider"),
    A_LAYOUT_HEADER("LayoutSider", "a-layout-header"),
    A_LAYOUT_CONTENT("LayoutSider", "a-layout-content"),
    A_LAYOUT_FOOTER("LayoutSider", "a-layout-footer"),
    A_BUTTON("Button", "a-button"),
    A_AFFIX("Affix", "a-affix"),
    A_BREADCRUMB("Breadcrumb", "a-breadcrumb"),
    A_BREADCRUMB_ITEM("BreadcrumbItem", "a-breadcrumb-item"),
    A_DROPDOWN("Dropdown", "a-dropdown"),
    ;
    private String name;
    private String tag;

    ComponentTagEnum(String name, String tag) {
        this.name = name;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }
}
