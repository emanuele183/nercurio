package com.eleomanni.nercurio.toolcontrols;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
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
		text.setToolTipText("Cerca Paziente");
		text.setMessage("Cerca Paziente");
		GridDataFactory.fillDefaults().hint(200, SWT.DEFAULT).applyTo(text);
		setAutoCompletion(text);
		text.addListener(SWT.CHANGED, listener);
	}
	
	Listener listener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			Text t = (Text) event.widget;
			//Method for autocompletion
            setAutoCompletion(t);
		};
	};
	
	private String[] getAllProposals( String text )
    {
        String[] proposals = new String[] { "alfa","beta","gamma","delta","epsilon","aaa","bbb","ccc","ddd","eee","f","g"};
        if(  text.length() != 0 && text != null ){
        	//TODO inserire chiamata a DB
//            for( int i = 0 ; i < 5 ; i++ )
//                proposals[i] = text+i;
        }
        return proposals;
    }
	
	private void setAutoCompletion( Text text )
    {
        try
        {
            ContentProposalAdapter adapter = null;
            String[] defaultProposals = getAllProposals(text.getText());
            SimpleContentProposalProvider scp = new SimpleContentProposalProvider( defaultProposals );
            scp.setFiltering(true);
            adapter = new ContentProposalAdapter(text, new TextContentAdapter(),
            		scp,null,null);
            adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
            adapter.setPropagateKeys(true);
        }
        catch( Throwable t )
        {
            t.printStackTrace();
        }
    }
}


