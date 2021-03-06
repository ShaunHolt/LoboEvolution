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
package org.loboevolution.html.renderer;

import org.loboevolution.html.dom.domimpl.ModelNode;

public class LineBreak {
	
	public static final int LEFT = 1;
	public static final int NONE = 0;
	public static final int RIGHT = 2;
	public static final int BOTH = 3;

	public static int getBreakType(String clearAttr) {
		if (clearAttr == null) {
			return NONE;
		} else {
			switch (clearAttr) {
			case "right":
				return RIGHT;
			case "left":
				return LEFT;
			case "both":
				return BOTH;
			default:
				return NONE;
			}
		}
	}

	private final int breakType;

	private final ModelNode newLineNode;

	public LineBreak(final int breakType, ModelNode newLineNode) {
		super();
		this.breakType = breakType;
		this.newLineNode = newLineNode;
	}

	public int getBreakType() {
		return this.breakType;
	}

	public ModelNode getModelNode() {
		return this.newLineNode;
	}
}
