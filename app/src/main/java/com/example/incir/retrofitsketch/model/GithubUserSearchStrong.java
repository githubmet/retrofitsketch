package com.example.incir.retrofitsketch.model;

import java.util.List;

public class GithubUserSearchStrong {
    public List<itemsDetails> items;

    @Override
    public String toString() {
        return "\nlogin="+items.get(0).login+"\nid="+items.get(0).id+
                "\nscore="+items.get(0).score;
    }

    public class itemsDetails{
        //private yazmasan da default degerdir.
        private String login;      //eger bir yerde neden bos is yapayim dersen mutlaka bir kisa yolu vardir. make public to private.
        private String id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String subscriptions_url;
        private String organizations_url;
        private String repos_url;
        private String events_url;
        private String received_events_url;
        private String type;
        private String site_admin;
        private String score;

        public String getLogin() {
            return login;
        }

        public String getId() {
            return id;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public String getGravatar_id() {
            return gravatar_id;
        }

        public String getUrl() {
            return url;
        }

        public String getHtml_url() {
            return html_url;
        }

        public String getFollowers_url() {
            return followers_url;
        }

        public String getFollowing_url() {
            return following_url;
        }

        public String getGists_url() {
            return gists_url;
        }

        public String getStarred_url() {
            return starred_url;
        }

        public String getSubscriptions_url() {
            return subscriptions_url;
        }

        public String getOrganizations_url() {
            return organizations_url;
        }

        public String getRepos_url() {
            return repos_url;
        }

        public String getEvents_url() {
            return events_url;
        }

        public String getReceived_events_url() {
            return received_events_url;
        }

        public String getType() {
            return type;
        }

        public String getSite_admin() {
            return site_admin;
        }

        public String getScore() {
            return score;
        }
    }
}
