package com.devops.dxc.devops.api;

import com.devops.dxc.devops.api.dto.UFClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ricardoquiroga on 27-03-22
 */
@FeignClient(name="dafiti-client", url ="${uf.url}")
public interface UFClient {

    @GetMapping("/")
    UFClientResponse getUF();
}
