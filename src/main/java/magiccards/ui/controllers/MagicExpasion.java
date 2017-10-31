package magiccards.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import magiccards.ui.entities.Card;
import magiccards.ui.proxies.CardsFacadeProxy;

@Controller
public class MagicExpasion {
	
	@Autowired
	//FIXME alterar repositorio apos criacao.
	private CardsFacadeProxy magicExpasionProxy;
	
	
	@RequestMapping(value="", method = RequestMethod.GET)
    public String list() {

        return "";
    }
	
	@RequestMapping(value="/magicExpasion/create", method = RequestMethod.GET)
    public String create() {
        return "magicExpasion/create";
    }
	
	//FIXME alterar entidade
	  @RequestMapping(value="/magicExpasion/update/{id}", method = RequestMethod.GET)
	    public String update(@PathVariable("id")String id, Model model) {

	        Card card = magicExpasionProxy.getCardById(id);
	        model.addAttribute("card", card);
	        return "magicExpasion/update";
	    }

	//FIXME alterar entidade
	    @RequestMapping(value="/magicExpasion/create", method = RequestMethod.POST)
	    public String create(Card card) {
	        magicExpasionProxy.create(card);
	        return "redirect:/magicExpasion";
	    }
}
