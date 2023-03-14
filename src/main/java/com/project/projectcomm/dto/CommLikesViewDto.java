package com.project.projectcomm.dto;

import lombok.Data;

@Data
public class CommLikesViewDto {
    private int likes;
    private int bads;
    private CommLikesDto commLikes;
}
