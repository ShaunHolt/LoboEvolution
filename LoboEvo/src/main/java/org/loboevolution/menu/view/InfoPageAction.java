package org.loboevolution.menu.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.loboevolution.component.BrowserFrame;
import org.loboevolution.component.ToolBar;
import org.loboevolution.http.NavigationManager;

public class InfoPageAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private final BrowserFrame frame;

	public InfoPageAction(BrowserFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final ToolBar toolbar = this.frame.getToolbar();
		final InfoPageWindow textViewer = new InfoPageWindow(
				NavigationManager.getDocument(toolbar.getAddressBar().getText()));
		textViewer.setSize(new Dimension(600, 400));
		textViewer.setLocationByPlatform(true);
		textViewer.setVisible(true);
	}

}
