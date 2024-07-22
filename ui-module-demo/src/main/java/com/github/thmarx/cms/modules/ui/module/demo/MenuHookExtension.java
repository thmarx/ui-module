package com.github.thmarx.cms.modules.ui.module.demo;

/*-
 * #%L
 * ui-module-demo
 * %%
 * Copyright (C) 2024 Marx-Software
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

import com.github.thmarx.cms.api.extensions.HookSystemRegisterExtentionPoint;
import com.github.thmarx.cms.api.hooks.HookSystem;
import com.github.thmarx.modules.api.annotation.Extension;
import java.util.List;

/**
 *
 * @author t.marx
 */
@Extension(HookSystemRegisterExtentionPoint.class)
public class MenuHookExtension extends HookSystemRegisterExtentionPoint {

	@Override
	public void register(HookSystem hs) {
		hs.registerAction("module/ui/menu", (context) -> {
			return List.of("eins", "zwei");
		});
	}
	
}
