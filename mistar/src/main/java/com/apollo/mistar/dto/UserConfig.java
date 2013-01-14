package com.apollo.mistar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 14/01/13
 */

public class UserConfig {

    @JsonProperty("wallPaperImage")
    private String wallPaperImage;

    @JsonProperty("isStreched")
    private boolean isStreched;

    public String getWallPaperImage() {
        return wallPaperImage;
    }

    public void setWallPaperImage(String wallPaperImage) {
        this.wallPaperImage = wallPaperImage;
    }

    public boolean isStreched() {
        return isStreched;
    }

    public void setStreched(boolean streched) {
        isStreched = streched;
    }
}
