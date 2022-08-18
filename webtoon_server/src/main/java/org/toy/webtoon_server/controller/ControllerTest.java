package org.toy.webtoon_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/api")
public class ControllerTest {

//	@ApiOperation(value = "웹툰 데이터 조회", notes = "웹툰 데이터를 조회합니다.")
//	@GetMapping(value = "/getData", produces = MediaType.APPLICATION_JSON_VALUE)
//	public String getData() {
//		return "SUCCESS";
//	}

	@GetMapping("/hello")
    public String Hello(){
        return "hello";
    }
}
