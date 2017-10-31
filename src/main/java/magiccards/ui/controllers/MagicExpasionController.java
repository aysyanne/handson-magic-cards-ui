package magiccards.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import magiccards.ui.entities.Card;
import magiccards.ui.entities.MagicExpansion;
import magiccards.ui.entities.Page;
import magiccards.ui.entities.TablePage;
import magiccards.ui.proxies.ExpansionFacadeProxy;

@Controller
public class MagicExpasionController {
	
	@Autowired
	private ExpansionFacadeProxy magicExpansionProxy;
	
	@RequestMapping(value="/magicexpansion", method = RequestMethod.GET)
    public String list() {

        return "magicexpansion/list";
    }
	
	 @RequestMapping(value="/magicexpansion/data", method = RequestMethod.GET)
	    public @ResponseBody TablePage<MagicExpansion> listPaged(@RequestParam("draw")int draw, @RequestParam("start")int start,@RequestParam("length")int length) {
	        int pageNumber = (start/length) + 1;
	        Page<MagicExpansion> magicExpansion = magicExpansionProxy.getExpansion(pageNumber, length);
	        TablePage<MagicExpansion> result = new TablePage<MagicExpansion>();
	        result.setData(magicExpansion.getContent());
	        result.setRecordsTotal(magicExpansion.getTotalElements());
	        result.setRecordsFiltered(magicExpansion.getTotalElements());
	        result.setDraw(draw);
	        return result;
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
