package com.example.incir.retrofitsketch.model;

import java.util.HashMap;

public class GithubGistsStrong {
    String id; //eger files a baska bir isim vermek istiyor isen @serialzi.. attribute kullan
    String url;
    HashMap<String,filesDetails> files;

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("id= " + id + "\n");
        for(HashMap.Entry<String,filesDetails> gex: files.entrySet()){
            sb.append("Key="+gex.getKey()+"\nType="+gex.getValue().type+"\nLanguage="+
            gex.getValue().language+"\n");
        }

        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public HashMap<String, filesDetails> getFiles() {
        return files;
    }

    public class filesDetails{
        String type;
        String language;
        String filename;

        public String getType() {
            return type;
        }

        public String getLanguage() {
            return language;
        }

        public String getFilename() {
            return filename;
        }
    }
}
//buradaki key degeri JSON objelerinden biri olan "files" array objesinin icersindeki
//JSON arrayinin adidir(key), value degerleri icin alttaki sinif ile veri
//cache store alanlari olusturman gerekir.
