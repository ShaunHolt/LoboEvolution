/*
 GNU LESSER GENERAL PUBLIC LICENSE
 Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 Lobo Evolution. Copyright (C) 2014 Lobo Evolution

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

 Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it; ivan.difrancesco@yahoo.it
 */

package org.loboevolution.html.style;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.loboevolution.info.FontInfo;
import org.loboevolution.laf.FontFactory;
import org.loboevolution.laf.FontKey;
import org.loboevolution.html.CSSValues;
import org.loboevolution.html.ListValues;
import org.loboevolution.html.renderstate.RenderState;

public class HtmlValues {

	public static final Map<String, FontInfo> SYSTEM_FONTS = new HashMap<String, FontInfo>();

	static {
		final FontInfo systemFont = new FontInfo();
		SYSTEM_FONTS.put("caption", systemFont);
		SYSTEM_FONTS.put("icon", systemFont);
		SYSTEM_FONTS.put("menu", systemFont);
		SYSTEM_FONTS.put("message-box", systemFont);
		SYSTEM_FONTS.put("small-caption", systemFont);
		SYSTEM_FONTS.put("status-bar", systemFont);
	}

	public static Insets getInsets(String insetsSpec, RenderState renderState, boolean negativeOK) {
		final int[] insetsArray = new int[4];
		int size = 0;
		final StringTokenizer tok = new StringTokenizer(insetsSpec);
		if (tok.hasMoreTokens()) {
			String token = tok.nextToken();
			insetsArray[0] = getPixelSize(token, renderState, 0);
			if (negativeOK || insetsArray[0] >= 0) {
				size = 1;
				if (tok.hasMoreTokens()) {
					token = tok.nextToken();
					insetsArray[1] = getPixelSize(token, renderState, 0);
					if (negativeOK || insetsArray[1] >= 0) {
						size = 2;
						if (tok.hasMoreTokens()) {
							token = tok.nextToken();
							insetsArray[2] = getPixelSize(token, renderState, 0);
							if (negativeOK || insetsArray[2] >= 0) {
								size = 3;
								if (tok.hasMoreTokens()) {
									token = tok.nextToken();
									insetsArray[3] = getPixelSize(token, renderState, 0);
									size = 4;
									if (negativeOK || insetsArray[3] >= 0) {
										// nop
									} else {
										insetsArray[3] = 0;
									}
								}
							} else {
								size = 4;
								insetsArray[2] = 0;
							}
						}
					} else {
						size = 4;
						insetsArray[1] = 0;
					}
				}
			} else {
				size = 1;
				insetsArray[0] = 0;
			}
		}
		if (size == 4) {
			return new Insets(insetsArray[0], insetsArray[3], insetsArray[2], insetsArray[1]);
		} else if (size == 1) {
			final int val = insetsArray[0];
			return new Insets(val, val, val, val);
		} else if (size == 2) {
			return new Insets(insetsArray[0], insetsArray[1], insetsArray[0], insetsArray[1]);
		} else if (size == 3) {
			return new Insets(insetsArray[0], insetsArray[1], insetsArray[2], insetsArray[1]);
		} else {
			return null;
		}
	}

	public static ListStyle getListStyle(String listStyleText) {
		final ListStyle listStyle = new ListStyle();
		final String[] tokens = HtmlValues.splitCssValue(listStyleText);
		for (final String token : tokens) {
			final ListValues listStyleType = HtmlValues.getListStyleType(token);
			if (listStyleType != ListValues.TYPE_UNSET) {
				listStyle.setType(listStyleType.getValue());
			} else if (HtmlValues.isUrl(token)) {
				// TODO: listStyle.image
			} else {
				final ListValues listStylePosition = HtmlValues.getListStylePosition(token);
				if (listStylePosition != ListValues.POSITION_UNSET) {
					listStyle.setPosition(listStylePosition.getValue());
				}
			}
		}
		return listStyle;
	}

	public static ListValues getListStylePosition(String token) {
		final String tokenTL = token.toLowerCase();
		CSSValues tkn = CSSValues.get(tokenTL);
		switch (tkn) {
		case INSIDE:
			return ListValues.POSITION_INSIDE;
		case OUTSIDE:
			return ListValues.POSITION_OUTSIDE;
		default:
			return ListValues.POSITION_UNSET;
		}
	}

	public static ListValues getListStyleType(String token) {
		final String tokenTL = token.toLowerCase();
		CSSValues tkn = CSSValues.get(tokenTL);
		switch (tkn) {
		case NONE:
			return ListValues.TYPE_NONE;
		case DISC:
			return ListValues.TYPE_DISC;
		case CIRCLE:
			return ListValues.TYPE_CIRCLE;
		case SQUARE:
			return ListValues.TYPE_SQUARE;
		case DECIMAL:
			return ListValues.TYPE_DECIMAL;
		case DECIMAL_LEADING_ZERO:
			return ListValues.TYPE_DECIMAL_LEADING_ZERO;
		case LOWER_ALPHA:
		case LOWER_LATIN:
			return ListValues.TYPE_LOWER_ALPHA;
		case UPPER_ALPHA:
		case UPPER_LATIN:
			return ListValues.TYPE_UPPER_ALPHA;
		case LOWER_ROMAN:
			return ListValues.TYPE_LOWER_ROMAN;
		case UPPER_ROMAN:
			return ListValues.TYPE_UPPER_ROMAN;
		default:
			return ListValues.TYPE_UNSET;
		}
	}

	public static final int getPixelSize(String spec, RenderState renderState, int errorValue) {
		try {
			final int dpi = GraphicsEnvironment.isHeadless() ? 72 : Toolkit.getDefaultToolkit().getScreenResolution();
			final String lcSpec = spec.toLowerCase();
			String units = "";
			String text = "";
			if(isUnits(spec)) {
				units = lcSpec.substring(lcSpec.length() - 2, lcSpec.length());
				text = lcSpec.substring(0, lcSpec.length() - 2);
			}
					
			switch (units) {
			case "px":
                final double val = Double.parseDouble(text);
                final double inches = val / 96;
                return (int) Math.round(dpi * inches);
			case "em":
				final FontFactory FONT_FACTORY = FontFactory.getInstance();
				final Font DEFAULT_FONT = FONT_FACTORY.getFont(new FontKey());
				final Font f = (renderState == null) ? DEFAULT_FONT : renderState.getFont();
				final int fontSize = f.getSize();
				final double pixelSize = fontSize * dpi / 96;
				return (int) Math.round(pixelSize * Double.parseDouble(text));
			case "pt":
				return inches(72, dpi, text);
			case "pc":
				return inches(6, dpi, text);
			case "cm":
				return inches(2.54, dpi, text);
			case "mm":
				return inches(25.4, dpi, text);
			case "ex":
				final double xHeight = renderState.getFontMetrics().getAscent() * 0.47;
				return (int) Math.round(xHeight * Double.parseDouble(text));
			case "in":
				final String valText = lcSpec.substring(0, lcSpec.length() - 2);
				try {
					return (int) Math.round(dpi * Double.parseDouble(valText));
				} catch (final NumberFormatException nfe) {
					return errorValue;
				}
			default:
				return (int) Math.round(Double.parseDouble(lcSpec));
			}
		} catch (final Exception ex) {
			return errorValue;
		}
	}
	
	public static final int getPixelSize(String spec, RenderState renderState, int errorValue, int availSize) {
		try {
			if (spec.endsWith("%")) {
				final String perText = spec.substring(0, spec.length() - 1);
				final double val = Double.parseDouble(perText);
				return (int) Math.round(availSize * val / 100.0);
			} else {
				return getPixelSize(spec, renderState, errorValue);
			}
		} catch (final Exception nfe) {
			return errorValue;
		}
	}

	public static boolean isBackgroundPosition(String token) {
		return isLength(token) || token.endsWith("%") || token.equalsIgnoreCase("top")
				|| token.equalsIgnoreCase("center") || token.equalsIgnoreCase("bottom")
				|| token.equalsIgnoreCase("left") || token.equalsIgnoreCase("right");
	}

	public static boolean isBackgroundRepeat(String repeat) {
		final String repeatTL = repeat.toLowerCase();
		return repeatTL.indexOf("repeat") != -1;
	}

	public static boolean isBorderStyle(String token) {
		final String tokenTL = token.toLowerCase();
		return tokenTL.equals("solid") || tokenTL.equals("dashed") || tokenTL.equals("dotted")
				|| tokenTL.equals("double") || tokenTL.equals("none") || tokenTL.equals("hidden")
				|| tokenTL.equals("groove") || tokenTL.equals("ridge") || tokenTL.equals("inset")
				|| tokenTL.equals("outset");
	}

	public static boolean isFontStyle(String token) {
		return "italic".equals(token) || "normal".equals(token) || "oblique".equals(token);
	}

	public static boolean isFontVariant(String token) {
		return "small-caps".equals(token) || "normal".equals(token);
	}

	public static boolean isFontWeight(String token) {
		if ("bold".equals(token) || "bolder".equals(token) || "lighter".equals(token)) {
			return true;
		}
		try {
			final int value = Integer.parseInt(token);
			return value % 100 == 0 && value >= 100 && value <= 900;
		} catch (final Exception nfe) {
			return false;
		}
	}
	
	public static boolean isUrl(String token) {
		return token.toLowerCase().startsWith("url(");
	}
	
	public static boolean isGradient(String token) {
		return token.toLowerCase().contains("gradient");
	}
	
	public static String quoteAndEscape(String text) {
		final StringBuilder result = new StringBuilder();
		result.append("'");
		int index = 0;
		final int length = text.length();
		while (index < length) {
			final char ch = text.charAt(index);
			switch (ch) {
			case '\'':
				result.append("\\'");
				break;
			case '\\':
				result.append("\\\\");
				break;
			default:
				result.append(ch);
			}
			index++;
		}
		result.append("'");
		return result.toString();
	}

	public static String[] splitCssValue(String cssValue) {
		final ArrayList<String> tokens = new ArrayList<String>(4);
		final int len = cssValue.length();
		int parenCount = 0;
		StringBuilder currentWord = null;
		for (int i = 0; i < len; i++) {
			final char ch = cssValue.charAt(i);
			switch (ch) {
			case '(':
				parenCount++;
				if (currentWord == null) {
					currentWord = new StringBuilder();
				}
				currentWord.append(ch);
				break;
			case ')':
				parenCount--;
				if (currentWord == null) {
					currentWord = new StringBuilder();
				}
				currentWord.append(ch);
				break;
			case ' ':
			case '\t':
			case '\n':
			case '\r':
				if (parenCount == 0) {
					tokens.add(currentWord.toString());
					currentWord = null;
					break;
				} else {
					// Fall through - no break
				}
			default:
				if (currentWord == null) {
					currentWord = new StringBuilder();
				}
				currentWord.append(ch);
				break;
			}
		}
		if (currentWord != null) {
			tokens.add(currentWord.toString());
		}
		return tokens.toArray(new String[tokens.size()]);
	}

	public static String unquoteAndUnescape(String text) {
		final StringBuilder result = new StringBuilder();
		int index = 0;
		final int length = text.length();
		boolean escape = false;
		boolean single = false;
		if (index < length) {
			final char ch = text.charAt(index);
			switch (ch) {
			case '\'':
				single = true;
				break;
			case '"':
				break;
			case '\\':
				escape = true;
				break;
			default:
				result.append(ch);
			}
			index++;
		}
		OUTER: for (; index < length; index++) {
			final char ch = text.charAt(index);
			switch (ch) {
			case '\'':
				if (escape || !single) {
					escape = false;
					result.append(ch);
				} else {
					break OUTER;
				}
				break;
			case '"':
				if (escape || single) {
					escape = false;
					result.append(ch);
				} else {
					break OUTER;
				}
				break;
			case '\\':
				if (escape) {
					escape = false;
					result.append(ch);
				} else {
					escape = true;
				}
				break;
			default:
				if (escape) {
					escape = false;
					result.append('\\');
				}
				result.append(ch);
			}
		}
		return result.toString();
	}

	private static int inches(double value, int dpi, String text) {
		double val = Double.parseDouble(text);
		final double inches = val / value;
		return (int) Math.round(dpi * inches);
	}

	private static boolean isLength(String token) {
		if (isUnits(token)) {
			return true;
		} else {
			try {
				Double.parseDouble(token);
				return true;
			} catch (final Exception nfe) {
				return false;
			}
		}
	}
	
	private static boolean isUnits(String token) {
		if (token.endsWith("px") || token.endsWith("pt") || token.endsWith("pc") || token.endsWith("cm")
				|| token.endsWith("mm") || token.endsWith("ex") || token.endsWith("em")) {
			return true;
		}
		return false;
	}
}
