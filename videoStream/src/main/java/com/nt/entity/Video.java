package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Video {
	@Id
	private String videoId;
	private String title;
	private String description;
	private String contentType;
	private String filePath;
	public Video() {
		
	}
	public Video(String videoId, String title, String description, String contentType, String filePath) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.description = description;
		this.contentType = contentType;
		this.filePath = filePath;
	}
	public String getVideoId() {
		return videoId;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getContentType() {
		return contentType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", description=" + description + ", contentType="
				+ contentType + ", filePath=" + filePath + "]";
	}

}
