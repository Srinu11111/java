package com.nt.service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.Video;
import com.nt.repository.VideoRepository;

import jakarta.annotation.PostConstruct;

@Service
public class VideoServiceImpl implements VideoService {
	private static final Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);

	@Value("${files.video}")
	private String DIR;

	@Autowired
	private VideoRepository repo;

	@PostConstruct
	public void init() {
		File folder = new File(DIR);
		if (!folder.exists()) {
			if (folder.mkdir()) {
				logger.info("Folder created at {}", DIR);
			} else {
				logger.error("Failed to create folder at {}", DIR);
			}
		} else {
			logger.info("Folder already exists at {}", DIR);
		}
	}

	@Override
	public Video insertVideo(Video video, MultipartFile file) {
		if (file == null || file.isEmpty()) {
			logger.warn("File is missing or empty");
			return null; // Consider throwing a custom exception here
		}

		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			String contentType = file.getContentType();
			InputStream inputStream = file.getInputStream();
			Path path = Paths.get(DIR, fileName);

			Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);

			video.setContentType(contentType);
			video.setFilePath(path.toString());

			logger.info("File {} successfully uploaded to {}", fileName, DIR);
			return repo.save(video);
		} catch (Exception e) {
			logger.error("Error occurred while inserting video", e);
			return null;
		}

	}

}
