/*
    GNU GENERAL LICENSE
    Copyright (C) 2014 - 2020 Lobo Evolution

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    verion 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General License for more details.

    You should have received a copy of the GNU General Public
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    

    Contact info: ivan.difrancesco@yahoo.it
 */
package org.loboevolution.html.dom.svg;

public interface SVGPaint extends SVGColor {
	// Paint Types
	static final short SVG_PAINTTYPE_UNKNOWN = 0;
	static final short SVG_PAINTTYPE_RGBCOLOR = 1;
	static final short SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR = 2;
	static final short SVG_PAINTTYPE_NONE = 101;
	static final short SVG_PAINTTYPE_CURRENTCOLOR = 102;
	static final short SVG_PAINTTYPE_URI_NONE = 103;
	static final short SVG_PAINTTYPE_URI_CURRENTCOLOR = 104;
	static final short SVG_PAINTTYPE_URI_RGBCOLOR = 105;
	static final short SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR = 106;
	static final short SVG_PAINTTYPE_URI = 107;

	short getPaintType();

	String getUri();

	void setUri(String uri);

	void setPaint(short paintType, String uri, String rgbColor, String iccColor) throws SVGException;
}
