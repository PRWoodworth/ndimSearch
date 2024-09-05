package com.dimSearch.nDimSearch;

import com.dimSearch.nDimSearch.controller.SearchController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest
class NDimSearchApplicationTests {
	@Autowired
	private SearchController searchController;
	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;

	@Test
	void contextLoads() throws Exception {
		assertThat(searchController).isNotNull();
	}

//	TODO: test sending a default search request here

}
