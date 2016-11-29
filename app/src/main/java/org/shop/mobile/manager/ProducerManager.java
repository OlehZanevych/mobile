package org.shop.mobile.manager;

import android.util.Log;
import android.widget.Toast;

import org.shop.mobile.ProducersActivity;
import org.shop.mobile.resource.PagedProducerResultResource;
import org.shop.mobile.resource.PagedResultResource;
import org.shop.mobile.resource.ProducerResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProducerManager {

    public static final String PRODUCERS_URI = ProducerResource.PRODUCER_API_URI + "?fields=all";

    public static List<ProducerResource> getList() {
        RestTemplate request = new RestTemplate(true);
        request.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<PagedProducerResultResource> responseEntity =
                request.getForEntity(PRODUCERS_URI, PagedProducerResultResource.class);
        return responseEntity.getBody().getResources();
    }
}
