/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apollo.mistar.controller;

import com.apollo.mistar.util.AtmosphereUtils;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

/**
 * Main controller.
 *
 * @author Gunnar Hillert
 * @since  1.0
 *
 */
@Controller
//@RequestMapping(value = "/async")
public class AsyncController {

	private static final Logger logger = LoggerFactory
			.getLogger(AsyncController.class);

//	@Autowired
//	private ObjectMapper objectMapper;



	@RequestMapping(value = "async", method = RequestMethod.POST)
	@ResponseBody
	public void post(final AtmosphereResource event, @RequestBody String message)
			throws JsonGenerationException, JsonMappingException, IOException {

		logger.info("Received message to broadcast: {}", message);
        event.getBroadcaster().broadcast(message);
//
//		TwitterMessages twitterMessages = new TwitterMessages();
//
//		List<TwitterMessage> messages = new ArrayList<TwitterMessage>();
//
//		final TwitterMessage twitterMessage = new TwitterMessage(-1L,
//				new Date(), message, "websocket client", "");

//		messages.add(twitterMessage);
//		twitterMessages.setTwitterMessages(messages);
//		event.getBroadcaster().getAtmosphereResources().size();
//		event.getBroadcaster().broadcast(
//				objectMapper.writeValueAsString(twitterMessages));
	}

	/**
	 * Responsible for suspending the {@link javax.servlet.http.HttpServletResponse} and executing
	 * a broadcasts periodically.
	 *
	 * @throws java.io.IOException
	 */
	@RequestMapping(value = "async", method = RequestMethod.GET)
	@ResponseBody
	public void websockets(final AtmosphereResource event)
			throws JsonGenerationException, JsonMappingException, IOException {

		AtmosphereUtils.suspend(event);

		final Broadcaster bc = event.getBroadcaster();

		final int numberOfClients = bc.getAtmosphereResources().size();

		String statusMessage = "A new Client has connected on "
				+ new Date().toString() + " (Total: " + numberOfClients + ")";

		logger.info(statusMessage);
	}

}
