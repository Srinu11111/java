package com.nt.service;

import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.Video;

public interface VideoService {
	public Video insertVideo(Video video,MultipartFile file);


}
