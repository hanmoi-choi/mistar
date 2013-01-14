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
package com.apollo.mistar.support;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class JaxbJacksonObjectMapper extends ObjectMapper {

	public JaxbJacksonObjectMapper() {
		final AnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        super.getDeserializationConfig().withAppendedAnnotationIntrospector(introspector);
		super.getSerializationConfig().withAppendedAnnotationIntrospector(introspector);

		this.enableDefaultTypingAsProperty(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT, JsonTypeInfo.Id.CLASS.getDefaultPropertyName());
	}

}
