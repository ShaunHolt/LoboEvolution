package org.loboevolution.menu.bookmarks;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import org.loboevolution.common.Strings;
import org.loboevolution.info.BookmarkInfo;
import org.loboevolution.store.BookmarksStore;

public class OkCancelAddBookAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private final boolean add;

	private final AddBookmarkWindow window;

	public OkCancelAddBookAction(AddBookmarkWindow window, boolean add) {
		this.window = window;
		this.add = add;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		final BookmarksStore book = new BookmarksStore();
		if (this.add) {
			book.insertBookmark(getinfo());
			JOptionPane.showMessageDialog(this.window, "Bookmark Added!");
		} else {
			this.window.setVisible(false);
			this.window.dispose();
		}
	}

	private BookmarkInfo getinfo() {
		final BookmarkInfo binfo = new BookmarkInfo();
		binfo.setUrl(this.window.getUrlField().getValue());
		binfo.setTitle(this.window.getTitleField().getValue());
		binfo.setDescription(this.window.getDescriptionField().getValue());
		binfo.setTags(Strings.split(this.window.getTagsField().getValue()));
		return binfo;
	}
}