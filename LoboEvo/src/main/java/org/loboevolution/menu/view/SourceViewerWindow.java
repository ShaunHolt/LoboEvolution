package org.loboevolution.menu.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.loboevolution.common.Strings;

public class SourceViewerWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	/** The jtf filter. */
	private JTextField jtfFilter;

	/** The pos. */
	private int pos = 0;

	/** The text area. */
	private transient RSyntaxTextArea textArea;

	/**
	 * Instantiates a new text viewer window.
	 */
	public SourceViewerWindow() {
		super("Lobo Source Viewer");
		createAndShowGUI();
	}

	private void addTextArea() {
		this.jtfFilter = new JTextField();

		final JButton findButton = new JButton("Next word");
		this.textArea = new RSyntaxTextArea();
		this.textArea.setHighlightCurrentLine(true);
		this.textArea.setAnimateBracketMatching(true);
		this.textArea.setAntiAliasingEnabled(true);
		this.textArea.setEditable(false);
		this.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
		this.textArea.setCodeFoldingEnabled(true);

		final RTextScrollPane scrollBar = new RTextScrollPane(this.textArea);
		scrollBar.setBorder(null);
		scrollBar.setLineNumbersEnabled(true);
		scrollBar.setViewportView(this.textArea);

		getContentPane().add(scrollBar);

		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
		panel.add(this.jtfFilter, BorderLayout.CENTER);
		panel.add(findButton, BorderLayout.EAST);
		add(panel, BorderLayout.SOUTH);

		findButton.addActionListener(e -> {
			final String find = this.jtfFilter.getText().toLowerCase();
			this.textArea.requestFocusInWindow();
			if (Strings.isNotBlank(find)) {
				final Document document = this.textArea.getDocument();
				final int findLength = find.length();
				try {
					boolean found = false;
					if (this.pos + findLength > document.getLength()) {
						this.pos = 0;
					}
					while (this.pos + findLength <= document.getLength()) {
						final String match = document.getText(this.pos, findLength).toLowerCase();
						if (match.equals(find)) {
							found = true;
							break;
						}
						this.pos++;
					}
					if (found) {
						final Rectangle viewRect = this.textArea.modelToView(this.pos);
						this.textArea.scrollRectToVisible(viewRect);
						this.textArea.setCaretPosition(this.pos + findLength);
						this.textArea.moveCaretPosition(this.pos);
						this.pos += findLength;
					}

				} catch (final Exception exp) {
					exp.printStackTrace();
				}

			}
		});
	}

	private void createAndShowGUI() {
		setResizable(true);
		setLocationRelativeTo(null);
		addTextArea();
	}

	@Override
	public Image getIconImage() {
		return new ImageIcon(getClass().getResource("/org/lobo/image/icon.png")).getImage();
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.textArea.setText(text);
	}
}