package magiccards.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import magiccards.ui.entities.MagicExpansion;
import magiccards.ui.proxies.ExpansionFacadeProxy;

@Controller
public class MagicExpasionController {
	
	@Autowired
	private ExpansionFacadeProxy magicExpansionProxy;
	
	@RequestMapping(value="/magicexpansion", method = RequestMethod.GET)
    public String list() {

        return "magicexpansion/list";
    }
	
	@RequestMapping(value="/magicexpansion/create", method = RequestMethod.GET)
    public String create() {
        return "magicexpansion/create";
    }
	
	  @RequestMapping(value="/magicexpansion/update/{id}", method = RequestMethod.GET)
	    public String update(@PathVariable("id")String id, Model model) {

		  	MagicExpansion magicExpansion = magicExpansionProxy.getExpansionById(id);
	        model.addAttribute("card", magicExpansion);
	        return "magicexpansion/update";
	    }

	    @RequestMapping(value="/magicexpansion/create", method = RequestMethod.POST)
	    public String create(MagicExpansion magicExpansion) {
	    	magicExpansionProxy.create(magicExpansion);
	        return "redirect:/magicexpansion";
	    }
}
