/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Lars Vogel <lars.Vogel@gmail.com> - Bug 419770
 *******************************************************************************/
package com.eleomanni.nercurio.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.swt.widgets.Shell;
public class LoadHandler {

	@Inject private EPartService partService;
	
	private static boolean toggleMainPart = true;
	
	@Execute
	public void execute(Shell shell){
		MPart mainPart = partService.findPart("com.eleomanni.nercurio.parts.mainPart");
		if (mainPart != null){
			if (toggleMainPart){
				partService.hidePart(mainPart);
				toggleMainPart = false;
			}else{
				partService.showPart(mainPart, PartState.VISIBLE);
				toggleMainPart = true;
			}
		}
	}
}
