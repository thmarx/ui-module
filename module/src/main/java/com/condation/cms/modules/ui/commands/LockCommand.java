package com.condation.cms.modules.ui.commands;

/*-
 * #%L
 * ui-module
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

import com.condation.cms.modules.ui.extensionpoints.UILifecycleExtension;
import com.condation.cms.modules.ui.services.CommandService;

/**
 *
 * @author t.marx
 */
public class LockCommand {
	
	public static final String NAME = "lock";
	
	public static final CommandService.CommandHandler HANDLER = command -> {
		var mode = (String)command.parameters().get("mode");
		var uri = (String)command.parameters().get("uri");
		return UILifecycleExtension.lockService.lock(mode, uri);
	};
}
