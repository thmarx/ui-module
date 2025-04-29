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
import com.condation.cms.api.hooks.FilterContext;
import com.condation.cms.api.hooks.HookSystem;
import com.condation.cms.modules.ui.api.FilterContextHelper;
import com.condation.cms.modules.ui.api.menu.MenuEntry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author thorstenmarx
 */
public class UIHooksTest {

	@Test
	public void registerMenuEntry() {

		HookSystem hookSystem = new HookSystem();

		hookSystem.registerFilter(UIHooks.HOOK_MENU, (FilterContext<String> context)
				-> FilterContextHelper.filterList(context, (entries) -> {
					entries.add(MenuEntry.builder()
							.child(MenuEntry.builder().name("child1").build())
							.name("parent1")
							.build());
				}, MenuEntry.class)
		);

		UIHooks uiHooks = new UIHooks(hookSystem);

		var entries = uiHooks.menuEntries();
		Assertions.assertThat(entries).hasSize(1);
		Assertions.assertThat(entries.getFirst().getChildren()).hasSize(1);
	}

	@Test
	public void registerMenuEntryAreSorted() {

		HookSystem hookSystem = new HookSystem();

		hookSystem.registerFilter(UIHooks.HOOK_MENU, (FilterContext<String> context)
				-> FilterContextHelper.filterList(context, (entries) -> {
					entries.add(MenuEntry.builder()
							.name("parent55")
							.position(55)
							.build());
					entries.add(MenuEntry.builder()
							.name("parent66")
							.position(66)
							.build());
					entries.add(MenuEntry.builder()
							.name("parent44")
							.position(44)
							.build());
				}, MenuEntry.class)
		);

		UIHooks uiHooks = new UIHooks(hookSystem);

		var entries = uiHooks.menuEntries();
		Assertions.assertThat(entries).hasSize(3);
		Assertions.assertThat(entries.get(0).getName()).isEqualTo("parent44");
		Assertions.assertThat(entries.get(1).getName()).isEqualTo("parent55");
		Assertions.assertThat(entries.get(2).getName()).isEqualTo("parent66");
	}
}
