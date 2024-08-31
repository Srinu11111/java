package com.nt.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.CustomerMessage;
import com.nt.entity.Video;
import com.nt.service.VideoServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class VideoController {

	@Autowired
	private VideoServiceImpl service;

	@PostMapping("/insert")
	public ResponseEntity<CustomerMessage> create(@RequestParam("file") MultipartFile file,
			@RequestParam("title") String title,@RequestParam("description") String description){
		Video video=new Video();
		video.setTitle(title);
		video.setDescription(description);
		video.setVideoId(UUID.randomUUID().toString());
		 Video data = service.insertVideo(video, file);
	        if (data != null) {
	            CustomerMessage successMessage = new CustomerMessage("Video uploaded successfully", data);
	            return ResponseEntity.status(HttpStatus.OK).body(successMessage);
	        } else {
	            CustomerMessage errorMessage = new CustomerMessage("Video not uploaded", null);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	        }
		
		
		
	}

}
