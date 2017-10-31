package magiccards.ui.proxies;

import magiccards.ui.entities.Card;
import magiccards.ui.entities.Page;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(url= "${rest.client.cards.url:default}/cards", name="cards")
public interface CardsFacadeProxy {

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    Card getCardById(@PathVariable("id") String gathererId);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    Page<Card> getcards(@RequestParam(value="page")int pageNumber, @RequestParam(value="size")int size);

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    void create(@RequestBody Card card);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    void update(Card card);

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id")String id);
}