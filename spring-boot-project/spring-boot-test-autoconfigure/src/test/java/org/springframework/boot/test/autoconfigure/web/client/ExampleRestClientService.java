/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.test.autoconfigure.web.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.Builder;

/**
 * Example web client using {@code RestClient} with {@link RestClientTest @RestClientTest}
 * tests.
 *
 * @author Scott Frederick
 */
@Service
public class ExampleRestClientService {

	private final Builder builder;

	private final RestClient restClient;

	public ExampleRestClientService(RestClient.Builder builder) {
		this.builder = builder;
		this.restClient = builder.baseUrl("https://example.com").build();
	}

	protected Builder getRestClientBuilder() {
		return this.builder;
	}

	public String test() {
		return this.restClient.get().uri("/test").retrieve().toEntity(String.class).getBody();
	}

	public void testPostWithBody(String body) {
		this.restClient.post().uri("/test").body(body).retrieve().toBodilessEntity();
	}

}
