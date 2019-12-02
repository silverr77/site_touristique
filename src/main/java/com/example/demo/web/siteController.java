package com.example.demo.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.commentRepository;
import com.example.demo.dao.pictureRepository;
import com.example.demo.dao.siteRepository;
import com.example.demo.entities.Picture;
import com.example.demo.entities.Site;
import com.example.demo.entities.comment;

@Controller
public class siteController {

	public String fileLocation = System.getProperty("user.dir")+"/uploadingDir/";
    @Autowired
    private siteRepository siterepository;
    @Autowired
    private pictureRepository picturerepository;
    
    @Autowired
    private commentRepository commentrepository;
    
    
	@RequestMapping("/")
	public String index(Model model) {
		List<Site> sites = siterepository.findAll();
		model.addAttribute("sites",sites);
		return "index";
	}
	
	@RequestMapping(value = "/site/addsite" ,method = RequestMethod.GET)
	public String addSite(Model model) {
		Site site=new Site();
		File file = new File(fileLocation);
        model.addAttribute("uploadingFiles", file.listFiles());
		model.addAttribute("site",site);
		return "addsite";
	}
	
	@RequestMapping(value = "/site/addsite" ,method = RequestMethod.POST)
	public String addSiteform(Model model,@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles,@Valid Site site,BindingResult bindingresult) {
		
		if(bindingresult.hasErrors()) {
			return "addsite";
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format(new Date());
		
		site.setDate_creation(dateString);
		siterepository.save(site);
		
		
		for(MultipartFile uploadedFile : uploadingFiles) {
			String filename=uploadedFile.getOriginalFilename();
			Picture picture=new Picture(filename,site);
            File file = new File(fileLocation + filename);
            try {
				uploadedFile.transferTo(file);
				picturerepository.save(picture);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return "redirect:/";
	}
	
	
	
	@RequestMapping(value="/site/detail",method = RequestMethod.GET)
	public String editproduit(Model model,@RequestParam(name = "id")int id) {
		Optional<Site> p=siterepository.findById(id);
		if(p.isPresent()) {
			Site site=p.get();
			model.addAttribute("site",site);
		}
		return "detail";
	}
	
	
	@RequestMapping(value="site/addcomment",method=RequestMethod.POST)
	public String addComment(HttpServletRequest request,Model model,@RequestParam(name = "id")int id,@RequestParam(name="ratting")int ratting,comment comment) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format( new Date()   );
		
		Optional<Site> site=siterepository.findById(id);
		if(site.isPresent()) {
			if(site.get().getRatting()==0) site.get().setRatting(ratting);
			else
			site.get().setRatting((site.get().getRatting()+ratting)/2);
			comment.setSite(site.get());
			comment.setDate_creation(dateString);
			commentrepository.save(comment);
		}
		
		
		 String referer = request.getHeader("Referer");
		    return "redirect:"+ referer;
	}
	
	
	@RequestMapping(value="sites")
	public String getSites() {
		return "sites";
	}
	

	
	
	
	
	
}
