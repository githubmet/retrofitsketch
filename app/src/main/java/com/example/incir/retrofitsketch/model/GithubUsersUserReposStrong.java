package com.example.incir.retrofitsketch.model;

import java.util.Map;

public class GithubUsersUserReposStrong {
    String id;
    String name;
    String full_name;
    String description;

    Map<String,OwnerDetail> owner;

    public class OwnerDetail{
        String login;
        String id;
        String avatar_url;

        public String getLogin() {
            return login;
        }

        public String getId() {
            return id;
        }

        public String getAvatar_url() {
            return avatar_url;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, OwnerDetail> getOwner() {
        return owner;
    }
}
