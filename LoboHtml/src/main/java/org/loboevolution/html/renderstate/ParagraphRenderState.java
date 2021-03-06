/*
    GNU LESSER GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The XAMJ Project

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
*/
package org.loboevolution.html.renderstate;

import java.awt.FontMetrics;

import org.loboevolution.html.dom.domimpl.HTMLElementImpl;
import org.loboevolution.html.style.HtmlInsets;

public class ParagraphRenderState extends AbstractMarginRenderState {
	public ParagraphRenderState(RenderState prevRenderState, HTMLElementImpl element) {
		super(prevRenderState, element);
	}

	@Override
	protected HtmlInsets getDefaultMarginInsets() {
		final HtmlInsets insets = new HtmlInsets();
		final RenderState prevRS = getPreviousRenderState();
		final FontMetrics fm = prevRS == null ? getFontMetrics() : prevRS.getFontMetrics();
		insets.top = fm.getHeight();
		insets.bottom = fm.getHeight();
		insets.topType = HtmlInsets.TYPE_PIXELS;
		insets.bottomType = HtmlInsets.TYPE_PIXELS;
		return insets;
	}

}
