package com.condation.cms.modules.ui.api;

/*-
 * #%L
 * ui-api
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

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.TypeReference;

/**
 *
 * @author thorstenmarx
 */
public class JSONUtil {
	
	public static String toString (Object object) {
		return JSON.toJSONString(object, JSONWriter.Feature.WriteClassName);
	}
	
	public static <T> T fromString (String value, Class<T> type) {
		return JSON.parseObject(value, type);
	}
	
	public static <T> T fromString (String value, TypeReference<T> type) {
		return JSON.parseObject(value, type);
	}
}
