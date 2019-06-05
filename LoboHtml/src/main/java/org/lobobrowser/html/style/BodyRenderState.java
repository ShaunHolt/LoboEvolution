/*
    GNU LESSER GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 Lobo Evolution

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
package org.lobobrowser.html.style;

import java.awt.Color;

import org.lobo.common.Strings;
import org.lobo.laf.ColorFactory;
import org.lobobrowser.html.domimpl.HTMLElementImpl;

public class BodyRenderState extends StyleSheetRenderState {

	public BodyRenderState(RenderState prevRenderState, HTMLElementImpl element) {
		super(prevRenderState, element);
	}

	@Override
	public BackgroundInfo getBackgroundInfo() {
		BackgroundInfo binfo = this.iBackgroundInfo;
		if (binfo != INVALID_BACKGROUND_INFO) {
			return binfo;
		}
		binfo = super.getBackgroundInfo();
		if (binfo == null || binfo.backgroundColor == null) {
			final String bgcolor = this.element.getAttribute("bgcolor");
			if (Strings.isNotBlank(bgcolor)) {
				if (binfo == null) {
					binfo = new BackgroundInfo();
				}
				binfo.backgroundColor = ColorFactory.getInstance().getColor(bgcolor);
			}
		}
		this.iBackgroundInfo = binfo;
		return binfo;
	}
	
	@Override
	public Color getColor() {
		Color c = super.getColor();
		if (c != null) {
			return c;
		}
		String tcolor = this.element.getAttribute("text");
		
		if (Strings.isNotBlank(tcolor)) {
			c = ColorFactory.getInstance().getColor(tcolor);
		} else {
			tcolor = "black";
		}

		return c;
	}

	@Override
	public HtmlInsets getMarginInsets() {
		HtmlInsets insets = this.marginInsets;
		if (insets != INVALID_INSETS) {
			return insets;
		}
		insets = super.getMarginInsets();
		if (insets == null) {
			final HTMLElementImpl element = this.element;
			String leftMargin = element.getAttribute("leftmargin");
			String rightMargin = element.getAttribute("rightmargin");
            String bottomMargin = element.getAttribute("bottommargin");
			String topMargin = element.getAttribute("topmargin");
			final String marginWidth = element.getAttribute("marginwidth");
			final String marginHeight = element.getAttribute("marginheight");
			if (leftMargin == null) {
				leftMargin = marginWidth;
			}
			if (rightMargin == null) {
				rightMargin = marginWidth;
			}
			if (topMargin == null) {
				topMargin = marginHeight;
			}
			if (bottomMargin == null) {
				bottomMargin = marginHeight;
			}
			if (leftMargin != null) {
				if (insets == null) {
					insets = new HtmlInsets();
				}
				insets.left = HtmlValues.getPixelSize(leftMargin, null, 0);
				insets.leftType = HtmlInsets.TYPE_PIXELS;
			}
			if (rightMargin != null) {
				if (insets == null) {
					insets = new HtmlInsets();
				}
				insets.right = HtmlValues.getPixelSize(rightMargin, null, 0);
				insets.rightType = HtmlInsets.TYPE_PIXELS;
			}
			if (topMargin != null) {
				if (insets == null) {
					insets = new HtmlInsets();
				}
				insets.top = HtmlValues.getPixelSize(topMargin, null, 0);
				insets.topType = HtmlInsets.TYPE_PIXELS;
			}
			if (bottomMargin != null) {
				if (insets == null) {
					insets = new HtmlInsets();
				}
				insets.bottom = HtmlValues.getPixelSize(bottomMargin, null, 0);
				insets.bottomType = HtmlInsets.TYPE_PIXELS;
			}
		}
		this.marginInsets = insets;
		return insets;
	}

	@Override
	public void invalidate() {
		super.invalidate();
	}

}