package magiccards.ui.proxies;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(url = "${rest.client.cards.url:default}/cards", name = "cards")
public interface ExpansionFacadeProxy {

}
