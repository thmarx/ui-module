package com.condation.cms.modules.ui.api.menu;

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
import com.condation.cms.modules.ui.api.action.HookAction;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author thorstenmarx
 */
public class MenuEntryTest {

	@Test
	public void testSomeMethod() {
		var entry = MenuEntry.builder()
				.child(MenuEntry.builder().name("Child1").position(0).build())
				.child(MenuEntry.builder().divider(true).position(1).build())
				.child(MenuEntry.builder().name("Child1")
						.position(2)
						.action(new HookAction("module/ui/demo/menu/action", Map.of("name", "CondationCMS")))
						.build())
				.name("ExampleMenu")
				.build();
		
		var jsonString = JSONUtil.toString(entry);
		
		var entry2 = JSONUtil.fromString(jsonString, new TypeReference<List<MenuEntry>>() {});
		
		jsonString = JSONUtil.toString(entry2);
		
		entry2 = JSONUtil.fromString(jsonString, new TypeReference<List<MenuEntry>>() {});
		
		jsonString = JSONUtil.toString(entry2);
	}

}
