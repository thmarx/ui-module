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
import com.condation.cms.api.hooks.HookSystem;
import com.condation.cms.modules.ui.api.JSONUtil;
import com.condation.cms.modules.ui.api.extensions.menu.MenuEntry;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import com.alibaba.fastjson2.TypeReference;
import java.util.Comparator;

/**
 *
 * @author thorstenmarx
 */
@RequiredArgsConstructor
public class UIHooks {

	public static final String HOOK_MENU = "module/ui/menu";

	private final HookSystem hookSystem;

	public List<MenuEntry> menuEntries() {
		List<MenuEntry> entries = new ArrayList<>();

		String filteredValue = hookSystem.filter(HOOK_MENU, JSONUtil.toString(entries)).value();

		entries = JSONUtil.fromString(filteredValue, new TypeReference<List<MenuEntry>>() {});
		
		sortMenuEntries(entries);
		
		return entries;
	}

	private void sortMenuEntries(List<MenuEntry> entries) {
		if (entries == null || entries.isEmpty()) {
			return;
		}

		// Sortiere die aktuelle Ebene
		entries.sort(Comparator.comparingInt(MenuEntry::getPosition));

		// Sortiere rekursiv die Kinder
		for (MenuEntry entry : entries) {
			sortMenuEntries(entry.getChildren());
		}
	}

}
