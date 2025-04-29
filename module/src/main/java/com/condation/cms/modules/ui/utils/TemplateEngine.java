package com.condation.cms.modules.ui.utils;

/*-
 * #%L
 * ui-module
 * %%
 * Copyright (C) 2024 - 2025 Condation
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 *
 * @author thorstenmarx
 */
public class TemplateEngine {

	private final Configuration config;
	
	public TemplateEngine () {
		config = new Configuration(Configuration.VERSION_2_3_32);

		config.setTemplateLoader(new ClassTemplateLoader(TemplateEngine.class, "/manager"));
		config.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX);
		config.setDefaultEncoding("UTF-8");
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		config.setLogTemplateExceptions(false);
		config.setWrapUncheckedExceptions(true);
		config.setFallbackOnNullLoopVariable(false);
	}
	
	public String render (String templateName, Map<String, Object> model) throws IOException, TemplateException {
		var template = config.getTemplate(templateName, "UTF-8");
		
		StringWriter out = new StringWriter();
		template.process(model, out);
		
		return out.toString();
	}
}
