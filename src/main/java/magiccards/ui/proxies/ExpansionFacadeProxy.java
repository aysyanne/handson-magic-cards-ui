package magiccards.ui.proxies;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import magiccards.ui.entities.MagicExpansion;
import magiccards.ui.entities.Page;

@Component
@FeignClient(url= "${rest.client.cards.url:default}/magicexapansion", name="magicexpansion")
public interface ExpansionFacadeProxy {

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    MagicExpansion getExpansionById(@PathVariable("id") String gathererId);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    Page<MagicExpansion> getExpansion(@RequestParam(value = "page") int pageNumber, @RequestParam(value = "size") int size);

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    void create(MagicExpansion magicExpasion);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    void update(MagicExpansion magicExpasion);

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") String id);
}