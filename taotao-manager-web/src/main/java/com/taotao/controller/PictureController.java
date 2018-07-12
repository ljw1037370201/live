package com.taotao.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.service.PictureService;

@Controller
@RequestMapping("/pic")
public class PictureController {
	
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public PictureResult uploda(MultipartFile uploadFile){
		byte[] bytes;
		try {
			bytes = uploadFile.getBytes();
			String name = uploadFile.getOriginalFilename();
			PictureResult pictureResult = pictureService.uploadFile(bytes, name);
			return pictureResult;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}