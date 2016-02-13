package com.example.incir.retrofitsketch.model;

import java.util.List;
public class StackexchangeQuatoRemainigStrong {
    String has_more;
    String quota_max;
    String quota_remaining;
    List<itemsDetail> items;

    public List<itemsDetail> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return  "has_more=" + has_more +
                "\nquota_max=" + quota_max +
                "\nquota_remaining=" + quota_remaining ;

    }
    public class itemsDetail {
        private String display_name;
        private String location;
        private String age;
        private String profile_image;

        public String getDisplay_name() {
            return display_name;
        }

        public String getLocation() {
            return location;
        }

        public String getAge() {
            return age;
        }

        public String getProfile_image() {
            return profile_image;
        }
    }
}
