package com.idcard.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.idcard.model.Idcard;
import com.idcard.service.IdCardService;

@Controller
@RequestMapping("/idcard")
public class IdCardController {
	
	private final IdCardService idCardService;
	
	public IdCardController(IdCardService idCardService) {
		this.idCardService = idCardService;
		
	}
	
	 @GetMapping("/idcardreg")
	    public String showForm(Model model) {
	        model.addAttribute("idCard", new Idcard());
	        return "index"; 
	    }
	 
	 // Handle form submission
	    @PostMapping("/generate")
	    public String generateIdCard(@ModelAttribute Idcard idCard,
	                                 @RequestParam("photo") MultipartFile photo) throws IOException {

	        // Save photo
	        String uploadDir = "uploads/";
	        String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
	        Path filePath = Paths.get(uploadDir + fileName);
	        Files.createDirectories(filePath.getParent());
	        Files.copy(photo.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

	        idCard.setPhotoPath(fileName);
	        Idcard saved = idCardService.saveIdcard(idCard);

	        return "redirect:/idcard/view/" + saved.getId();
	    }

	    // View ID card
	    @GetMapping("/view/{id}")
	    public String viewIdCard(@PathVariable Long id, Model model) {
	        Idcard card = idCardService.getIdcardById(id);
	        model.addAttribute("idCard", card);
	        return "idcard"; // templates/idcard.html
	    }
	
	

}
