package com.moon.moonblogserver.user;

public class UserResponse extends User {
    private String accessToken;
    private String refreshtoken;

    public UserResponse() {

    }

    public UserResponse(String accessToken, String refreshtoken) {
        super();
        this.accessToken = accessToken;
        this.refreshtoken = refreshtoken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshtoken() {
        return refreshtoken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshtoken(String refreshtoken) {
        this.refreshtoken = refreshtoken;
    }
}
