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

import com.alibaba.fastjson2.TypeReference;
import com.condation.cms.api.hooks.FilterContext;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author thorstenmarx
 */
public class FilterContextHelper {

	public static <T> String filterList(FilterContext<String> context, Consumer<List<T>> consumer, Class<T> clazz) {
		List<T> list = JSONUtil.fromString(context.value(), new TypeReference<List<T>>() {});
		consumer.accept(list);
		return JSONUtil.toString(list);
	}
}
