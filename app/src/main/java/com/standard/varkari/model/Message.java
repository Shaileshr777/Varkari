package com.standard.varkari.model;



import java.util.HashMap;
import java.util.Map;

public class Message
{

    String name,message,image_url;

    public Message() {
    }

    public Message(String name, String image_url, String message) {
        this.name = name;
        this.message = message;
        this.image_url = image_url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("image_url", image_url);
        result.put("name", name);


        return result;
    }
}
