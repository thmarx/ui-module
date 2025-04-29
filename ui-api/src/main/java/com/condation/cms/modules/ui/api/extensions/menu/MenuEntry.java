package com.condation.cms.modules.ui.api.extensions.menu;

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
import com.condation.cms.modules.ui.api.JSONUtil;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

/**
 *
 * @author thorstenmarx
 */
@Builder
@Getter
public class MenuEntry {

	private String name;
	
	private boolean divider = false;
	
	@Builder.Default
	private int position = 0;
	
	@Singular
	private List<MenuEntry> children;
	
	public boolean hasChildren () {
		return children != null && ! children.isEmpty();
	}
	
	public String toJsonString () {
		return JSONUtil.toString(this);
	}
	
	public static MenuEntry fromJsonString (String value) {
		return JSONUtil.fromString(value, MenuEntry.class);
	}
	
	public static List<MenuEntry> listFromJsonString (String value) {
		return JSONUtil.fromString(value, new TypeReference<List<MenuEntry>>() {});
	}
}
