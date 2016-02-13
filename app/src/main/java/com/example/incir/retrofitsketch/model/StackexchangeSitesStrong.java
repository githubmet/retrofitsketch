package com.example.incir.retrofitsketch.model;

import java.util.List;

public class StackexchangeSitesStrong {
    List<itemsDetails> items;

    public List<itemsDetails> getItems() {
        return items;
    }

    public class itemsDetails{
    private String name;
    private String site_url;
    private String icon_url;
    List<stylingDetails> styling;

    public String getName() {
        return name;
    }

    public String getSite_url() {
        return site_url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public List<stylingDetails> getStyling() {
        return styling;
    }

    public class stylingDetails{
       String  tag_background_color;
       String  tag_foreground_color;

        public String getTag_background_color() {
            return tag_background_color;
        }

        public String getTag_foreground_color() {
            return tag_foreground_color;
        }
    }
    }
}
