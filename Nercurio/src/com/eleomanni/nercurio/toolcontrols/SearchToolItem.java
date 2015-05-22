package com.eleomanni.nercurio.toolcontrols;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class SearchToolItem {
	@Inject private Logger log;
	
	@PostConstruct
	public void createControls(Composite parent) {
		final Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout());
		
		Text text = new Text(comp, SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL
				| SWT.BORDER);
		text.setMessage("Cerca Paziente");
		GridDataFactory.fillDefaults().hint(200, SWT.DEFAULT).applyTo(text);
		text.addListener(SWT.CHANGED, listener);
	}
	
	Listener listener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			Text t = (Text) event.widget;
			String txt = t.getText();
				log.info(txt);
		};
	};
}
