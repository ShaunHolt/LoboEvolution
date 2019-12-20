/*
* Copyright (c) 2002 and later by MH Software-Entwicklung. All Rights Reserved.
*
* JTattoo is multiple licensed. If your are an open source developer you can use
* it under the terms and conditions of the GNU General Public License version 2.0
* or later as published by the Free Software Foundation.
*
* see: gpl-2.0.txt
*
* If you pay for a license you will become a registered user who could use the
* software under the terms and conditions of the GNU Lesser General Public License
* version 2.0 or later with classpath exception as published by the Free Software
* Foundation.
*
* see: lgpl-2.0.txt
* see: classpath-exception.txt
*
* Registered users could also use JTattoo under the terms and conditions of the
* Apache License, Version 2.0 as published by the Apache Software Foundation.
*
* see: APACHE-LICENSE-2.0.txt
*/

package com.jtattoo.plaf;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalTheme;

public abstract class AbstractTheme extends MetalTheme {

	private static final Logger logger = Logger.getLogger(AbstractTheme.class.getName());
	
	public static final int TEXT_ANTIALIAS_DEFAULT = 0;
	public static final int TEXT_ANTIALIAS_GRAY = 1;
	public static final int TEXT_ANTIALIAS_HRGB = 2;
	public static final int TEXT_ANTIALIAS_HBGR = 3;
	public static final int TEXT_ANTIALIAS_VRGB = 4;
	public static final int TEXT_ANTIALIAS_VBGR = 5;
	public static final String DIALOG = "Dialog";

	public static final ColorUIResource RED = new ColorUIResource(255, 0, 0);
	public static final ColorUIResource GREEN = new ColorUIResource(0, 255, 255);
	public static final ColorUIResource CYAN = new ColorUIResource(0, 255, 255);
	public static final ColorUIResource WHITE = new ColorUIResource(255, 255, 255);
	public static final ColorUIResource SUPER_LIGHT_GRAY = new ColorUIResource(248, 248, 248);
	public static final ColorUIResource EXTRA_LIGHT_GRAY = new ColorUIResource(232, 232, 232);
	public static final ColorUIResource LIGHT_GRAY = new ColorUIResource(196, 196, 196);
	public static final ColorUIResource GRAY = new ColorUIResource(164, 164, 164);
	public static final ColorUIResource DARK_GRAY = new ColorUIResource(148, 148, 148);
	public static final ColorUIResource EXTRA_DARK_GRAY = new ColorUIResource(96, 96, 96);
	public static final ColorUIResource BLACK = new ColorUIResource(0, 0, 0);
	public static final ColorUIResource ORANGE = new ColorUIResource(255, 200, 0);
	public static final ColorUIResource LIGHT_ORANGE = new ColorUIResource(255, 220, 96);
	public static final ColorUIResource YELLOW = new ColorUIResource(255, 255, 196);
	public static final ColorUIResource BLUE = new ColorUIResource(0, 128, 255);
	public static final ColorUIResource DARK_BLUE = new ColorUIResource(0, 64, 128);

	protected static String internalName = "Default";
	protected static boolean windowDecoration = false;
	protected static boolean macStyleWindowDecoration = false;
	protected static boolean centerWindowTitle = false;
	protected static boolean linuxStyleScrollBar = false;
	protected static boolean macStyleScrollBar = false;
	protected static boolean dynamicLayout = false;
	protected static boolean textShadow = false;
	protected static boolean textAntiAliasing = true;
	protected static int textAntiAliasingMode = TEXT_ANTIALIAS_HRGB;
	protected static boolean backgroundPattern = true;
	protected static boolean brightMode = false;
	protected static boolean showFocusFrame = false;
	protected static boolean drawSquareButtons = false;
	protected static boolean toolbarDecorated = true;

	protected static boolean menuOpaque = true;
	protected static float menuAlpha = 0.9f;
	protected static String logoString = "JTattoo";
	protected static FontUIResource controlFont = null;
	protected static FontUIResource systemFont = null;
	protected static FontUIResource userFont = null;
	protected static FontUIResource smallFont = null;
	protected static FontUIResource menuFont = null;
	protected static FontUIResource windowTitleFont = null;
	protected static ColorUIResource foregroundColor = null;
	protected static ColorUIResource backgroundColor = null;
	protected static ColorUIResource backgroundColorLight = null;
	protected static ColorUIResource backgroundColorDark = null;
	protected static ColorUIResource alterBackgroundColor = null;
	protected static ColorUIResource disabledForegroundColor = null;
	protected static ColorUIResource disabledBackgroundColor = null;
	protected static ColorUIResource inputBackgroundColor = null;
	protected static ColorUIResource inputForegroundColor = null;
	protected static ColorUIResource selectionForegroundColor = null;
	protected static ColorUIResource selectionBackgroundColorLight = null;
	protected static ColorUIResource selectionBackgroundColorDark = null;
	protected static ColorUIResource selectionBackgroundColor = null;
	protected static ColorUIResource rolloverForegroundColor = null;
	protected static ColorUIResource rolloverColor = null;
	protected static ColorUIResource rolloverColorLight = null;
	protected static ColorUIResource rolloverColorDark = null;
	protected static ColorUIResource pressedForegroundColor = null;
	protected static ColorUIResource pressedBackgroundColor = null;
	protected static ColorUIResource pressedBackgroundColorLight = null;
	protected static ColorUIResource pressedBackgroundColorDark = null;
	protected static ColorUIResource focusColor = null;
	protected static ColorUIResource focusCellColor = null;
	protected static ColorUIResource focusFrameColor = null;
	protected static ColorUIResource focusBackgroundColor = null;
	protected static ColorUIResource focusForegroundColor = null;
	protected static ColorUIResource frameColor = null;
	protected static ColorUIResource gridColor = null;
	protected static ColorUIResource shadowColor = null;
	protected static ColorUIResource buttonForegroundColor = null;
	protected static ColorUIResource buttonBackgroundColor = null;
	protected static ColorUIResource buttonColorLight = null;
	protected static ColorUIResource buttonColorDark = null;
	protected static ColorUIResource controlForegroundColor = null;
	protected static ColorUIResource controlBackgroundColor = null;
	protected static ColorUIResource controlHighlightColor = null;
	protected static ColorUIResource controlShadowColor = null;
	protected static ColorUIResource controlDarkShadowColor = null;
	protected static ColorUIResource controlColorLight = null;
	protected static ColorUIResource controlColorDark = null;
	protected static ColorUIResource windowTitleForegroundColor = null;
	protected static ColorUIResource windowTitleBackgroundColor = null;
	protected static ColorUIResource windowTitleColorLight = null;
	protected static ColorUIResource windowTitleColorDark = null;
	protected static ColorUIResource windowBorderColor = null;
	protected static ColorUIResource windowIconColor = null;
	protected static ColorUIResource windowIconShadowColor = null;
	protected static ColorUIResource windowIconRolloverColor = null;

	protected static ColorUIResource windowInactiveTitleForegroundColor = null;
	protected static ColorUIResource windowInactiveTitleBackgroundColor = null;
	protected static ColorUIResource windowInactiveTitleColorLight = null;
	protected static ColorUIResource windowInactiveTitleColorDark = null;
	protected static ColorUIResource windowInactiveBorderColor = null;
	protected static ColorUIResource menuForegroundColor = null;
	protected static ColorUIResource menuBackgroundColor = null;
	protected static ColorUIResource menuSelectionForegroundColor = null;
	protected static ColorUIResource menuSelectionBackgroundColor = null;
	protected static ColorUIResource menuSelectionBackgroundColorLight = null;
	protected static ColorUIResource menuSelectionBackgroundColorDark = null;
	protected static ColorUIResource menuColorLight = null;
	protected static ColorUIResource menuColorDark = null;
	protected static ColorUIResource toolbarForegroundColor = null;
	protected static ColorUIResource toolbarBackgroundColor = null;
	protected static ColorUIResource toolbarColorLight = null;
	protected static ColorUIResource toolbarColorDark = null;
	protected static ColorUIResource tabAreaBackgroundColor = null;
	protected static ColorUIResource tabSelectionForegroundColor = null;
	protected static ColorUIResource desktopColor = null;
	protected static ColorUIResource tooltipForegroundColor = null;
	protected static ColorUIResource tooltipBackgroundColor = null;
	protected static int tooltipBorderSize = 6;
	protected static int tooltipShadowSize = 6;
	protected static boolean tooltipCastShadow = false;

	protected static Color DEFAULT_COLORS[] = null;
	protected static Color HIDEFAULT_COLORS[] = null;
	protected static Color ACTIVE_COLORS[] = null;
	protected static Color INACTIVE_COLORS[] = null;
	protected static Color ROLLOVER_COLORS[] = null;
	protected static Color SELECTED_COLORS[] = null;
	protected static Color SELECTION_COLORS[] = null;
	protected static Color FOCUS_COLORS[] = null;
	protected static Color MENU_SELECTION_COLORS[] = null;
	protected static Color PRESSED_COLORS[] = null;
	protected static Color DISABLED_COLORS[] = null;
	protected static Color WINDOW_TITLE_COLORS[] = null;
	protected static Color WINDOW_INACTIVE_TITLE_COLORS[] = null;
	protected static Color TOOLBAR_COLORS[] = null;
	protected static Color MENUBAR_COLORS[] = null;
	protected static Color BUTTON_COLORS[] = null;
	protected static Color CHECKBOX_COLORS[] = null;
	protected static Color TAB_COLORS[] = null;
	protected static Color COL_HEADER_COLORS[] = null;
	protected static Color TRACK_COLORS[] = null;
	protected static Color THUMB_COLORS[] = null;
	protected static Color SLIDER_COLORS[] = null;
	protected static Color PROGRESSBAR_COLORS[] = null;

	protected static String textureSet = "Default";
	protected static boolean darkTexture = true;
	protected static Icon windowTexture = null;
	protected static Icon backgroundTexture = null;
	protected static Icon alterBackgroundTexture = null;
	protected static Icon selectedTexture = null;
	protected static Icon rolloverTexture = null;
	protected static Icon pressedTexture = null;
	protected static Icon disabledTexture = null;
	protected static Icon menubarTexture = null;

	protected static ColorUIResource createColor(String colorProp, ColorUIResource color) {
		if (colorProp != null && colorProp.trim().length() >= 5) {
			colorProp = colorProp.trim();
			int r = color.getRed();
			int g = color.getGreen();
			int b = color.getBlue();
			try {
				int p1 = 0;
				int p2 = colorProp.indexOf(' ');
				if (p2 > 0) {
					r = Integer.parseInt(colorProp.substring(p1, p2));
					p1 = p2 + 1;
					p2 = colorProp.indexOf(' ', p1);
					if (p2 > 0) {
						g = Integer.parseInt(colorProp.substring(p1, p2));
						b = Integer.parseInt(colorProp.substring(p2 + 1));
					}
				}
				return new ColorUIResource(r, g, b);
			} catch (NumberFormatException ex) {
				logger.severe("Exception while parsing color property: " + colorProp);
			}
		}
		return color;
	}

	protected static FontUIResource createFont(String fontProp) {
		if (fontProp != null && fontProp.trim().length() > 5) {
			return new FontUIResource(Font.decode(fontProp));
		}
		return null;
	}

	protected static int createInt(String intProp, int defaultValue) {
		int val = defaultValue;
		try {
			val = Integer.parseInt(intProp);
		} catch (NumberFormatException ex) {
			logger.severe("Exception while parsing int property: " + intProp);
		}
		return val;
	}

	public static String getInternalName() {
		return internalName;
	}

	public static void setInternalName(String name) {
		internalName = name;
	}

	public AbstractTheme() {
		super();
	}

	public boolean doDrawSquareButtons() {
		return drawSquareButtons;
	}

	public boolean doShowFocusFrame() {
		return showFocusFrame;
	}

	public Color[] getActiveColors() {
		return ACTIVE_COLORS;
	}

	public ColorUIResource getAlterBackgroundColor() {
		return alterBackgroundColor;
	}

	public Icon getAlterBackgroundTexture() {
		return alterBackgroundTexture;
	}

	public ColorUIResource getBackgroundColor() {
		return backgroundColor;
	}

	public ColorUIResource getBackgroundColorDark() {
		return backgroundColorDark;
	}

	public ColorUIResource getBackgroundColorLight() {
		return backgroundColorLight;
	}

	public Icon getBackgroundTexture() {
		return backgroundTexture;
	}

	public ColorUIResource getButtonBackgroundColor() {
		return buttonBackgroundColor;
	}

	public ColorUIResource getButtonColorDark() {
		return buttonColorDark;
	}

	public ColorUIResource getButtonColorLight() {
		return buttonColorLight;
	}

	public Color[] getButtonColors() {
		return BUTTON_COLORS;
	}

	public ColorUIResource getButtonForegroundColor() {
		return buttonForegroundColor;
	}

	public Color[] getCheckBoxColors() {
		return CHECKBOX_COLORS;
	}

	public Color[] getColHeaderColors() {
		return COL_HEADER_COLORS;
	}

	@Override
	public ColorUIResource getControl() {
		return controlBackgroundColor;
	}

	public ColorUIResource getControlBackgroundColor() {
		return controlBackgroundColor;
	}

	public ColorUIResource getControlColorDark() {
		return controlColorDark;
	}

	public ColorUIResource getControlColorLight() {
		return controlColorLight;
	}

	@Override
	public ColorUIResource getControlDarkShadow() {
		return controlDarkShadowColor;
	}

	public ColorUIResource getControlDarkShadowColor() {
		return controlDarkShadowColor;
	}

	@Override
	public ColorUIResource getControlDisabled() {
		return controlShadowColor;
	}

	public ColorUIResource getControlForegroundColor() {
		return controlForegroundColor;
	}

	@Override
	public ColorUIResource getControlHighlight() {
		return controlHighlightColor;
	}

	public ColorUIResource getControlHighlightColor() {
		return controlHighlightColor;
	}

	@Override
	public ColorUIResource getControlInfo() {
		return controlForegroundColor;
	}

	@Override
	public ColorUIResource getControlShadow() {
		return controlShadowColor;
	}

	public ColorUIResource getControlShadowColor() {
		return controlShadowColor;
	}

	@Override
	public ColorUIResource getControlTextColor() {
		return controlForegroundColor;
	}

	@Override
	public FontUIResource getControlTextFont() {
		if (controlFont == null) {
			if (JTattooUtilities.isLinux() && JTattooUtilities.isHiresScreen()) {
				controlFont = new FontUIResource(DIALOG, Font.BOLD, 14);
			} else {
				controlFont = new FontUIResource(DIALOG, Font.PLAIN, 12);
			}
		}
		return controlFont;
	}

	public Color[] getDefaultColors() {
		return DEFAULT_COLORS;
	}

	@Override
	public ColorUIResource getDesktopColor() {
		return desktopColor;
	}

	public ColorUIResource getDisabledBackgroundColor() {
		return disabledBackgroundColor;
	}

	public Color[] getDisabledColors() {
		return DISABLED_COLORS;
	}

	public ColorUIResource getDisabledForegroundColor() {
		return disabledForegroundColor;
	}

	public Icon getDisabledTexture() {
		return disabledTexture;
	}

	public ColorUIResource getFocusBackgroundColor() {
		return focusBackgroundColor;
	}

	public ColorUIResource getFocusCellColor() {
		return focusCellColor;
	}

	@Override
	public ColorUIResource getFocusColor() {
		return focusColor;
	}

	public Color[] getFocusColors() {
		return FOCUS_COLORS;
	}

	public ColorUIResource getFocusForegroundColor() {
		return focusForegroundColor;
	}

	public ColorUIResource getFocusFrameColor() {
		return focusFrameColor;
	}

	public ColorUIResource getForegroundColor() {
		return foregroundColor;
	}

	public ColorUIResource getFrameColor() {
		return frameColor;
	}

	public ColorUIResource getGridColor() {
		return gridColor;
	}

	public Color[] getHiDefaultColors() {
		return HIDEFAULT_COLORS;
	}

	public Color[] getInActiveColors() {
		return INACTIVE_COLORS;
	}

	public ColorUIResource getInputBackgroundColor() {
		return inputBackgroundColor;
	}

	public ColorUIResource getInputForegroundColor() {
		return inputForegroundColor;
	}

	public String getLogoString() {
		if (logoString != null) {
			if (logoString.trim().length() == 0) {
				return null;
			}
		}
		return logoString;
	}

	public float getMenuAlpha() {
		return menuAlpha;
	}

	public ColorUIResource getMenuBackgroundColor() {
		return menuBackgroundColor;
	}

	public Color[] getMenuBarColors() {
		return MENUBAR_COLORS;
	}

	public Icon getMenubarTexture() {
		return menubarTexture;
	}

	public ColorUIResource getMenuColorDark() {
		return menuColorDark;
	}

	public ColorUIResource getMenuColorLight() {
		return menuColorLight;
	}

	public ColorUIResource getMenuForegroundColor() {
		return menuForegroundColor;
	}

	public ColorUIResource getMenuSelectionBackgroundColor() {
		return menuSelectionBackgroundColor;
	}

	public ColorUIResource getMenuSelectionBackgroundColorDark() {
		return menuSelectionBackgroundColorDark;
	}

	public ColorUIResource getMenuSelectionBackgroundColorLight() {
		return menuSelectionBackgroundColorLight;
	}

	public Color[] getMenuSelectionColors() {
		return MENU_SELECTION_COLORS;
	}

	public ColorUIResource getMenuSelectionForegroundColor() {
		return menuSelectionForegroundColor;
	}

	@Override
	public FontUIResource getMenuTextFont() {
		if (menuFont == null) {
			if (JTattooUtilities.isLinux() && JTattooUtilities.isHiresScreen()) {
				menuFont = new FontUIResource(DIALOG, Font.BOLD, 14);
			} else {
				menuFont = new FontUIResource(DIALOG, Font.PLAIN, 12);
			}
		}
		return menuFont;
	}

	@Override
	public String getName() {
		return getInternalName();
	}

	public ColorUIResource getPressedBackgroundColor() {
		return pressedBackgroundColor;
	}

	public Color[] getPressedColors() {
		return PRESSED_COLORS;
	}

	public ColorUIResource getPressedForegroundColor() {
		return pressedForegroundColor;
	}

	public Icon getPressedTexture() {
		return pressedTexture;
	}

	// -----------------------------------------------------------------------------------
	@Override
	protected ColorUIResource getPrimary1() {
		return foregroundColor;
	}

	@Override
	protected ColorUIResource getPrimary2() {
		return desktopColor;
	}

	@Override
	protected ColorUIResource getPrimary3() {
		return selectionBackgroundColor;
	}

	@Override
	public ColorUIResource getPrimaryControl() {
		return EXTRA_LIGHT_GRAY;
	}

	@Override
	public ColorUIResource getPrimaryControlDarkShadow() {
		return GRAY;
	}

	@Override
	public ColorUIResource getPrimaryControlHighlight() {
		return WHITE;
	}

	@Override
	public ColorUIResource getPrimaryControlInfo() {
		return DARK_GRAY;
	}

	@Override
	public ColorUIResource getPrimaryControlShadow() {
		return LIGHT_GRAY;
	}

	public Color[] getProgressBarColors() {
		return PROGRESSBAR_COLORS;
	}

	public String getPropertyFileName() {
		return "JTattooTheme.properties";
	}

	public ColorUIResource getRolloverColor() {
		return rolloverColor;
	}

	public ColorUIResource getRolloverColorDark() {
		return rolloverColorDark;
	}

	public ColorUIResource getRolloverColorLight() {
		return rolloverColorLight;
	}

	public Color[] getRolloverColors() {
		return ROLLOVER_COLORS;
	}

	public ColorUIResource getRolloverForegroundColor() {
		return rolloverForegroundColor;
	}

	public Icon getRolloverTexture() {
		return rolloverTexture;
	}

	@Override
	protected ColorUIResource getSecondary1() {
		return frameColor;
	}

	@Override
	protected ColorUIResource getSecondary2() {
		return controlBackgroundColor;
	}

	@Override
	protected ColorUIResource getSecondary3() {
		return backgroundColor;
	}

	public Color[] getSelectedColors() {
		return SELECTED_COLORS;
	}

	public Icon getSelectedTexture() {
		return selectedTexture;
	}

	public ColorUIResource getSelectionBackgroundColor() {
		return selectionBackgroundColor;
	}

	public ColorUIResource getSelectionBackgroundColorDark() {
		return selectionBackgroundColorDark;
	}

	public ColorUIResource getSelectionBackgroundColorLight() {
		return selectionBackgroundColorLight;
	}

	public Color[] getSelectionColors() {
		return SELECTION_COLORS;
	}

	public ColorUIResource getSelectionForegroundColor() {
		return selectionForegroundColor;
	}

	public ColorUIResource getShadowColor() {
		return shadowColor;
	}

	public Color[] getSliderColors() {
		return SLIDER_COLORS;
	}

	@Override
	public FontUIResource getSubTextFont() {
		if (smallFont == null) {
			if (JTattooUtilities.isLinux() && JTattooUtilities.isHiresScreen()) {
				smallFont = new FontUIResource(DIALOG, Font.BOLD, 12);
			} else {
				smallFont = new FontUIResource(DIALOG, Font.PLAIN, 10);
			}
		}
		return smallFont;
	}

	@Override
	public ColorUIResource getSystemTextColor() {
		return foregroundColor;
	}

	@Override
	public FontUIResource getSystemTextFont() {
		if (systemFont == null) {
			if (JTattooUtilities.isLinux() && JTattooUtilities.isHiresScreen()) {
				systemFont = new FontUIResource(DIALOG, Font.BOLD, 14);
			} else {
				systemFont = new FontUIResource(DIALOG, Font.PLAIN, 12);
			}
		}
		return systemFont;
	}

	public ColorUIResource getTabAreaBackgroundColor() {
		return tabAreaBackgroundColor;
	}

	public Color[] getTabColors() {
		return TAB_COLORS;
	}

	public ColorUIResource getTabSelectionForegroundColor() {
		return tabSelectionForegroundColor;
	}

	public Object getTextAntiAliasingHint() {
		if (isTextAntiAliasingOn()) {
			switch (textAntiAliasingMode) {
			case TEXT_ANTIALIAS_DEFAULT:
				return RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT;
			case TEXT_ANTIALIAS_HRGB:
				return RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB;
			case TEXT_ANTIALIAS_HBGR:
				return RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR;
			case TEXT_ANTIALIAS_VRGB:
				return RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB;
			case TEXT_ANTIALIAS_VBGR:
				return RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VBGR;
			default:
				return RenderingHints.VALUE_TEXT_ANTIALIAS_ON;
			}
		}
		return RenderingHints.VALUE_TEXT_ANTIALIAS_OFF;
	}

	public int getTextAntiAliasingMode() {
		return textAntiAliasingMode;
	}

	public String getTextureSet() {
		return textureSet;
	}

	public Color[] getThumbColors() {
		return THUMB_COLORS;
	}

	public ColorUIResource getToolbarBackgroundColor() {
		return toolbarBackgroundColor;
	}

	public ColorUIResource getToolbarColorDark() {
		return toolbarColorDark;
	}

	public ColorUIResource getToolbarColorLight() {
		return toolbarColorLight;
	}

	public Color[] getToolBarColors() {
		return TOOLBAR_COLORS;
	}

	public ColorUIResource getToolbarForegroundColor() {
		return toolbarForegroundColor;
	}

	public ColorUIResource getTooltipBackgroundColor() {
		return tooltipBackgroundColor;
	}

	public int getTooltipBorderSize() {
		return Math.max(0, Math.min(8, tooltipBorderSize));
	}

	public ColorUIResource getTooltipForegroundColor() {
		return tooltipForegroundColor;
	}

	public int getTooltipShadowSize() {
		return Math.max(0, Math.min(8, tooltipShadowSize));
	}

	public Color[] getTrackColors() {
		return TRACK_COLORS;
	}

	@Override
	public FontUIResource getUserTextFont() {
		if (userFont == null) {
			if (JTattooUtilities.isLinux() && JTattooUtilities.isHiresScreen()) {
				userFont = new FontUIResource(DIALOG, Font.BOLD, 14);
			} else {
				userFont = new FontUIResource(DIALOG, Font.PLAIN, 12);
			}
		}
		return userFont;
	}

	public ColorUIResource getWindowBorderColor() {
		return windowBorderColor;
	}

	public ColorUIResource getWindowIconColor() {
		return windowIconColor;
	}

	public ColorUIResource getWindowIconRolloverColor() {
		return windowIconRolloverColor;
	}

	public ColorUIResource getWindowIconShadowColor() {
		return windowIconShadowColor;
	}

	public ColorUIResource getWindowInactiveBorderColor() {
		return windowInactiveBorderColor;
	}

	public ColorUIResource getWindowInactiveTitleBackgroundColor() {
		return windowInactiveTitleBackgroundColor;
	}

	public ColorUIResource getWindowInactiveTitleColorDark() {
		return windowInactiveTitleColorDark;
	}

	public ColorUIResource getWindowInactiveTitleColorLight() {
		return windowInactiveTitleColorLight;
	}

	public Color[] getWindowInactiveTitleColors() {
		return WINDOW_INACTIVE_TITLE_COLORS;
	}

	public ColorUIResource getWindowInactiveTitleForegroundColor() {
		return windowInactiveTitleForegroundColor;
	}

	public Icon getWindowTexture() {
		return windowTexture;
	}

	public ColorUIResource getWindowTitleBackgroundColor() {
		return windowTitleBackgroundColor;
	}

	public ColorUIResource getWindowTitleColorDark() {
		return windowTitleColorDark;
	}

	public ColorUIResource getWindowTitleColorLight() {
		return windowTitleColorLight;
	}

	public Color[] getWindowTitleColors() {
		return WINDOW_TITLE_COLORS;
	}

	@Override
	public FontUIResource getWindowTitleFont() {
		if (windowTitleFont == null) {
			if (JTattooUtilities.isLinux() && JTattooUtilities.isHiresScreen()) {
				windowTitleFont = new FontUIResource(DIALOG, Font.BOLD, 14);
			} else {
				windowTitleFont = new FontUIResource(DIALOG, Font.BOLD, 12);
			}
		}
		return windowTitleFont;
	}

	public ColorUIResource getWindowTitleForegroundColor() {
		return windowTitleForegroundColor;
	}

	public boolean isBackgroundPatternOn() {
		return backgroundPattern;
	}

	public boolean isBrightMode() {
		return brightMode;
	}

	public boolean isCenterWindowTitleOn() {
		return centerWindowTitle;
	}

	public boolean isDarkTexture() {
		return darkTexture;
	}

	public boolean isDynamicLayout() {
		return dynamicLayout;
	}

	public boolean isLargeFontSize() {
		return userFont.getSize() >= 16;
	}

	public boolean isLinuxStyleScrollBarOn() {
		return linuxStyleScrollBar;
	}

	public boolean isMacStyleScrollBarOn() {
		return macStyleScrollBar;
	}

	public boolean isMacStyleWindowDecorationOn() {
		return macStyleWindowDecoration;
	}

	public boolean isMediumFontSize() {
		return userFont.getSize() >= 14 && userFont.getSize() < 16;
	}

	public boolean isMenuOpaque() {
		return menuOpaque;
	}

	public boolean isSmallFontSize() {
		return userFont.getSize() < 14;
	}

	public boolean isTextAntiAliasingOn() {
		return textAntiAliasing;
	}

	public boolean isTextShadowOn() {
		return textShadow;
	}

	public boolean isTinyFontSize() {
		return userFont.getSize() < 12;
	}

	public boolean isToolbarDecorated() {
		return toolbarDecorated;
	}

	public boolean isTooltipCastShadow() {
		return tooltipCastShadow;
	}

	public boolean isWindowDecorationOn() {
		return windowDecoration;
	}

	public void loadProperties() {
		FileInputStream in = null;
		try {
			String fileName = System.getProperty("user.home") + "/.jtattoo/" + getPropertyFileName();
			Properties props = new Properties();
			in = new FileInputStream(fileName);
			props.load(in);
			setProperties(props);
		} catch (IOException ex) {
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
	}

	public void setProperties(Properties props) {
		if (props != null) {
			if (props.getProperty("windowDecoration") != null) {
				windowDecoration = props.getProperty("windowDecoration").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("macStyleWindowDecoration") != null) {
				macStyleWindowDecoration = props.getProperty("macStyleWindowDecoration").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("centerWindowTitle") != null) {
				centerWindowTitle = props.getProperty("centerWindowTitle").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("linuxStyleScrollBar") != null) {
				linuxStyleScrollBar = props.getProperty("linuxStyleScrollBar").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("macStyleScrollBar") != null) {
				macStyleScrollBar = props.getProperty("macStyleScrollBar").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("dynamicLayout") != null) {
				dynamicLayout = props.getProperty("dynamicLayout").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("textShadow") != null) {
				textShadow = props.getProperty("textShadow").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("textAntiAliasing") != null) {
				textAntiAliasing = props.getProperty("textAntiAliasing").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("textAntiAliasingMode") != null) {
				String mode = props.getProperty("textAntiAliasingMode");
				if (mode.equalsIgnoreCase("default")) {
					textAntiAliasingMode = TEXT_ANTIALIAS_DEFAULT;
				}
				if (mode.equalsIgnoreCase("gray")) {
					textAntiAliasingMode = TEXT_ANTIALIAS_GRAY;
				}
				if (mode.equalsIgnoreCase("hrgb")) {
					textAntiAliasingMode = TEXT_ANTIALIAS_HRGB;
				}
				if (mode.equalsIgnoreCase("hbgr")) {
					textAntiAliasingMode = TEXT_ANTIALIAS_HBGR;
				}
				if (mode.equalsIgnoreCase("vrgb")) {
					textAntiAliasingMode = TEXT_ANTIALIAS_VRGB;
				}
				if (mode.equalsIgnoreCase("vbgr")) {
					textAntiAliasingMode = TEXT_ANTIALIAS_VBGR;
				}
			}
			if (props.getProperty("backgroundPattern") != null) {
				backgroundPattern = props.getProperty("backgroundPattern").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("brightMode") != null) {
				brightMode = props.getProperty("brightMode").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("showFocusFrame") != null) {
				showFocusFrame = props.getProperty("showFocusFrame").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("drawSquareButtons") != null) {
				drawSquareButtons = props.getProperty("drawSquareButtons").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("toolbarDecorated") != null) {
				toolbarDecorated = props.getProperty("toolbarDecorated").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("menuOpaque") != null) {
				menuOpaque = props.getProperty("menuOpaque").trim().equalsIgnoreCase("on");
			}
			if (props.getProperty("logoString") != null) {
				logoString = props.getProperty("logoString").trim();
			}
			if (props.getProperty("controlTextFont") != null) {
				controlFont = createFont(props.getProperty("controlTextFont"));
			}
			if (props.getProperty("systemTextFont") != null) {
				systemFont = createFont(props.getProperty("systemTextFont"));
			}
			if (props.getProperty("userTextFont") != null) {
				userFont = createFont(props.getProperty("userTextFont"));
			}
			if (props.getProperty("menuTextFont") != null) {
				menuFont = createFont(props.getProperty("menuTextFont"));
			}
			if (props.getProperty("windowTitleFont") != null) {
				windowTitleFont = createFont(props.getProperty("windowTitleFont"));
			}
			if (props.getProperty("subTextFont") != null) {
				smallFont = createFont(props.getProperty("subTextFont"));
			}

			if (props.getProperty("foregroundColor") != null) {
				foregroundColor = createColor(props.getProperty("foregroundColor"), foregroundColor);
			}
			if (props.getProperty("backgroundColor") != null) {
				backgroundColor = createColor(props.getProperty("backgroundColor"), backgroundColor);
			}
			if (props.getProperty("backgroundColorLight") != null) {
				backgroundColorLight = createColor(props.getProperty("backgroundColorLight"), backgroundColorLight);
			}
			if (props.getProperty("backgroundColorDark") != null) {
				backgroundColorDark = createColor(props.getProperty("backgroundColorDark"), backgroundColorDark);
			}
			if (props.getProperty("alterBackgroundColor") != null) {
				alterBackgroundColor = createColor(props.getProperty("alterBackgroundColor"), alterBackgroundColor);
			}
			if (props.getProperty("disabledForegroundColor") != null) {
				disabledForegroundColor = createColor(props.getProperty("disabledForegroundColor"),
						disabledForegroundColor);
			}
			if (props.getProperty("disabledBackgroundColor") != null) {
				disabledBackgroundColor = createColor(props.getProperty("disabledBackgroundColor"),
						disabledBackgroundColor);
			}
			if (props.getProperty("inputForegroundColor") != null) {
				inputForegroundColor = createColor(props.getProperty("inputForegroundColor"), inputForegroundColor);
			}
			if (props.getProperty("inputBackgroundColor") != null) {
				inputBackgroundColor = createColor(props.getProperty("inputBackgroundColor"), inputBackgroundColor);
			}
			if (props.getProperty("selectionForegroundColor") != null) {
				selectionForegroundColor = createColor(props.getProperty("selectionForegroundColor"),
						selectionForegroundColor);
			}
			if (props.getProperty("selectionBackgroundColor") != null) {
				selectionBackgroundColor = createColor(props.getProperty("selectionBackgroundColor"),
						selectionBackgroundColor);
			}
			if (props.getProperty("selectionBackgroundColorLight") != null) {
				selectionBackgroundColorLight = createColor(props.getProperty("selectionBackgroundColorLight"),
						selectionBackgroundColorLight);
			}
			if (props.getProperty("selectionBackgroundColorDark") != null) {
				selectionBackgroundColorDark = createColor(props.getProperty("selectionBackgroundColorDark"),
						selectionBackgroundColorDark);
			}
			if (props.getProperty("frameColor") != null) {
				frameColor = createColor(props.getProperty("frameColor"), frameColor);
			}
			if (props.getProperty("gridColor") != null) {
				gridColor = createColor(props.getProperty("gridColor"), gridColor);
			}
			if (props.getProperty("shadowColor") != null) {
				shadowColor = createColor(props.getProperty("shadowColor"), shadowColor);
			}
			if (props.getProperty("focusColor") != null) {
				focusColor = createColor(props.getProperty("focusColor"), focusColor);
			}
			if (props.getProperty("focusCellColor") != null) {
				focusCellColor = createColor(props.getProperty("focusCellColor"), focusCellColor);
			}
			if (props.getProperty("focusFrameColor") != null) {
				focusFrameColor = createColor(props.getProperty("focusFrameColor"), focusFrameColor);
			}
			if (props.getProperty("focusBackgroundColor") != null) {
				focusBackgroundColor = createColor(props.getProperty("focusBackgroundColor"), focusBackgroundColor);
			}
			if (props.getProperty("focusForegroundColor") != null) {
				focusForegroundColor = createColor(props.getProperty("focusForegroundColor"), focusForegroundColor);
			}

			if (props.getProperty("rolloverForegroundColor") != null) {
				rolloverForegroundColor = createColor(props.getProperty("rolloverForegroundColor"),
						rolloverForegroundColor);
			}
			if (props.getProperty("rolloverColor") != null) {
				rolloverColor = createColor(props.getProperty("rolloverColor"), rolloverColor);
			}
			if (props.getProperty("rolloverColorLight") != null) {
				rolloverColorLight = createColor(props.getProperty("rolloverColorLight"), rolloverColorLight);
			}
			if (props.getProperty("rolloverColorDark") != null) {
				rolloverColorDark = createColor(props.getProperty("rolloverColorDark"), rolloverColorDark);
			}
			if (props.getProperty("pressedForegroundColor") != null) {
				pressedForegroundColor = createColor(props.getProperty("pressedForegroundColor"),
						pressedForegroundColor);
			}
			if (props.getProperty("pressedBackgroundColor") != null) {
				pressedBackgroundColor = createColor(props.getProperty("pressedBackgroundColor"),
						pressedBackgroundColor);
			}
			if (props.getProperty("pressedBackgroundColorLight") != null) {
				pressedBackgroundColorLight = createColor(props.getProperty("pressedBackgroundColorLight"),
						pressedBackgroundColorDark);
			}
			if (props.getProperty("pressedBackgroundColorDark") != null) {
				pressedBackgroundColorDark = createColor(props.getProperty("pressedBackgroundColorDark"),
						pressedBackgroundColorDark);
			}

			if (props.getProperty("buttonForegroundColor") != null) {
				buttonForegroundColor = createColor(props.getProperty("buttonForegroundColor"), buttonForegroundColor);
			}
			if (props.getProperty("buttonBackgroundColor") != null) {
				buttonBackgroundColor = createColor(props.getProperty("buttonBackgroundColor"), buttonBackgroundColor);
			}
			if (props.getProperty("buttonColorLight") != null) {
				buttonColorLight = createColor(props.getProperty("buttonColorLight"), buttonColorLight);
			}
			if (props.getProperty("buttonColorDark") != null) {
				buttonColorDark = createColor(props.getProperty("buttonColorDark"), buttonColorDark);
			}

			if (props.getProperty("controlForegroundColor") != null) {
				controlForegroundColor = createColor(props.getProperty("controlForegroundColor"),
						controlForegroundColor);
			}
			if (props.getProperty("controlBackgroundColor") != null) {
				controlBackgroundColor = createColor(props.getProperty("controlBackgroundColor"),
						controlBackgroundColor);
			}
			if (props.getProperty("controlColorLight") != null) {
				controlColorLight = createColor(props.getProperty("controlColorLight"), controlColorLight);
			}
			if (props.getProperty("controlColorDark") != null) {
				controlColorDark = createColor(props.getProperty("controlColorDark"), controlColorDark);
			}
			if (props.getProperty("controlHighlightColor") != null) {
				controlHighlightColor = createColor(props.getProperty("controlHighlightColor"), controlHighlightColor);
			}
			if (props.getProperty("controlShadowColor") != null) {
				controlShadowColor = createColor(props.getProperty("controlShadowColor"), controlShadowColor);
			}
			if (props.getProperty("controlDarkShadowColor") != null) {
				controlDarkShadowColor = createColor(props.getProperty("controlDarkShadowColor"),
						controlDarkShadowColor);
			}

			if (props.getProperty("windowTitleForegroundColor") != null) {
				windowTitleForegroundColor = createColor(props.getProperty("windowTitleForegroundColor"),
						windowTitleForegroundColor);
			}
			if (props.getProperty("windowTitleBackgroundColor") != null) {
				windowTitleBackgroundColor = createColor(props.getProperty("windowTitleBackgroundColor"),
						windowTitleBackgroundColor);
			}
			if (props.getProperty("windowTitleColorLight") != null) {
				windowTitleColorLight = createColor(props.getProperty("windowTitleColorLight"), windowTitleColorLight);
			}
			if (props.getProperty("windowTitleColorDark") != null) {
				windowTitleColorDark = createColor(props.getProperty("windowTitleColorDark"), windowTitleColorDark);
			}
			if (props.getProperty("windowBorderColor") != null) {
				windowBorderColor = createColor(props.getProperty("windowBorderColor"), windowBorderColor);
			}
			if (props.getProperty("windowIconColor") != null) {
				windowIconColor = createColor(props.getProperty("windowIconColor"), windowIconColor);
			}
			if (props.getProperty("windowIconShadowColor") != null) {
				windowIconShadowColor = createColor(props.getProperty("windowIconShadowColor"), windowIconShadowColor);
			}
			if (props.getProperty("windowIconRolloverColor") != null) {
				windowIconRolloverColor = createColor(props.getProperty("windowIconRolloverColor"),
						windowIconRolloverColor);
			}

			if (props.getProperty("windowInactiveTitleForegroundColor") != null) {
				windowInactiveTitleForegroundColor = createColor(
						props.getProperty("windowInactiveTitleForegroundColor"), windowInactiveTitleForegroundColor);
			}
			if (props.getProperty("windowTitleBackgroundColor") != null) {
				windowInactiveTitleBackgroundColor = createColor(
						props.getProperty("windowInactiveTitleBackgroundColor"), windowInactiveTitleBackgroundColor);
			}
			if (props.getProperty("windowInactiveTitleColorLight") != null) {
				windowInactiveTitleColorLight = createColor(props.getProperty("windowInactiveTitleColorLight"),
						windowInactiveTitleColorLight);
			}
			if (props.getProperty("windowInactiveTitleColorDark") != null) {
				windowInactiveTitleColorDark = createColor(props.getProperty("windowInactiveTitleColorDark"),
						windowInactiveTitleColorDark);
			}
			if (props.getProperty("windowInactiveBorderColor") != null) {
				windowInactiveBorderColor = createColor(props.getProperty("windowInactiveBorderColor"),
						windowInactiveBorderColor);
			}

			if (props.getProperty("menuForegroundColor") != null) {
				menuForegroundColor = createColor(props.getProperty("menuForegroundColor"), menuForegroundColor);
			}
			if (props.getProperty("menuBackgroundColor") != null) {
				menuBackgroundColor = createColor(props.getProperty("menuBackgroundColor"), menuBackgroundColor);
			}
			if (props.getProperty("menuSelectionForegroundColor") != null) {
				menuSelectionForegroundColor = createColor(props.getProperty("menuSelectionForegroundColor"),
						menuSelectionForegroundColor);
			}
			if (props.getProperty("menuSelectionBackgroundColor") != null) {
				menuSelectionBackgroundColor = createColor(props.getProperty("menuSelectionBackgroundColor"),
						menuSelectionBackgroundColor);
			}
			if (props.getProperty("menuSelectionBackgroundColorLight") != null) {
				menuSelectionBackgroundColorLight = createColor(props.getProperty("menuSelectionBackgroundColorLight"),
						menuSelectionBackgroundColorLight);
			}
			if (props.getProperty("menuSelectionBackgroundColorDark") != null) {
				menuSelectionBackgroundColorDark = createColor(props.getProperty("menuSelectionBackgroundColorDark"),
						menuSelectionBackgroundColorDark);
			}
			if (props.getProperty("menuColorLight") != null) {
				menuColorLight = createColor(props.getProperty("menuColorLight"), menuColorLight);
			}
			if (props.getProperty("menuColorDark") != null) {
				menuColorDark = createColor(props.getProperty("menuColorDark"), menuColorDark);
			}

			if (props.getProperty("toolbarForegroundColor") != null) {
				toolbarForegroundColor = createColor(props.getProperty("toolbarForegroundColor"),
						toolbarForegroundColor);
			}
			if (props.getProperty("toolbarBackgroundColor") != null) {
				toolbarBackgroundColor = createColor(props.getProperty("toolbarBackgroundColor"),
						toolbarBackgroundColor);
			}
			if (props.getProperty("toolbarColorLight") != null) {
				toolbarColorLight = createColor(props.getProperty("toolbarColorLight"), toolbarColorLight);
			}
			if (props.getProperty("toolbarColorDark") != null) {
				toolbarColorDark = createColor(props.getProperty("toolbarColorDark"), toolbarColorDark);
			}

			if (props.getProperty("tabAreaBackgroundColor") != null) {
				tabAreaBackgroundColor = createColor(props.getProperty("tabAreaBackgroundColor"),
						tabAreaBackgroundColor);
			} else {
				tabAreaBackgroundColor = backgroundColor;
			}
			if (props.getProperty("tabSelectionForegroundColor") != null) {
				tabSelectionForegroundColor = createColor(props.getProperty("tabSelectionForegroundColor"),
						tabSelectionForegroundColor);
			}

			if (props.getProperty("desktopColor") != null) {
				desktopColor = createColor(props.getProperty("desktopColor"), desktopColor);
			}
			if (props.getProperty("tooltipForegroundColor") != null) {
				tooltipForegroundColor = createColor(props.getProperty("tooltipForegroundColor"),
						tooltipForegroundColor);
			}
			if (props.getProperty("tooltipBackgroundColor") != null) {
				tooltipBackgroundColor = createColor(props.getProperty("tooltipBackgroundColor"),
						tooltipBackgroundColor);
			}
			if (props.getProperty("tooltipBorderSize") != null) {
				tooltipBorderSize = createInt(props.getProperty("tooltipBorderSize"), tooltipBorderSize);
			}
			if (props.getProperty("tooltipShadowSize") != null) {
				tooltipShadowSize = createInt(props.getProperty("tooltipShadowSize"), tooltipShadowSize);
			}
			if (props.getProperty("tooltipCastShadow") != null) {
				tooltipCastShadow = props.getProperty("tooltipCastShadow").trim().equalsIgnoreCase("on");
			}

			if (props.getProperty("textureSet") != null) {
				textureSet = props.getProperty("textureSet");
			}
			if (props.getProperty("darkTexture") != null) {
				darkTexture = props.getProperty("darkTexture").trim().equalsIgnoreCase("on");
			}
			if (props.get("windowTexture") != null) {
				Object texture = props.get("windowTexture");
				if (texture instanceof Icon) {
					windowTexture = (Icon) texture;
				}
			}
			if (props.get("backgroundTexture") != null) {
				Object texture = props.get("backgroundTexture");
				if (texture instanceof Icon) {
					backgroundTexture = (Icon) texture;
				}
			}
			if (props.get("alterBackgroundTexture") != null) {
				Object texture = props.get("alterBackgroundTexture");
				if (texture instanceof Icon) {
					alterBackgroundTexture = (Icon) texture;
				}
			}
			if (props.get("selectedTexture") != null) {
				Object texture = props.get("selectedTexture");
				if (texture instanceof Icon) {
					selectedTexture = (Icon) texture;
				}
			}
			if (props.get("rolloverTexture") != null) {
				Object texture = props.get("rolloverTexture");
				if (texture instanceof Icon) {
					rolloverTexture = (Icon) texture;
				}
			}
			if (props.get("pressedTexture") != null) {
				Object texture = props.get("pressedTexture");
				if (texture instanceof Icon) {
					pressedTexture = (Icon) texture;
				}
			}
			if (props.get("disabledTexture") != null) {
				Object texture = props.get("disabledTexture");
				if (texture instanceof Icon) {
					disabledTexture = (Icon) texture;
				}
			}
			if (props.get("menubarTexture") != null) {
				Object texture = props.get("menubarTexture");
				if (texture instanceof Icon) {
					menubarTexture = (Icon) texture;
				}
			}
		}
	}

	public void setUpColor() {
		windowDecoration = true;
		macStyleWindowDecoration = JTattooUtilities.isMac();
		centerWindowTitle = JTattooUtilities.isWindows() && JTattooUtilities.getOSVersion() >= 6.2
				&& JTattooUtilities.getOSVersion() < 10.0;
		linuxStyleScrollBar = !JTattooUtilities.isWindows();
		macStyleScrollBar = JTattooUtilities.isMac();
		dynamicLayout = true;
		textShadow = false;
		textAntiAliasing = true;
		textAntiAliasingMode = TEXT_ANTIALIAS_HRGB;
		backgroundPattern = true;
		brightMode = false;
		showFocusFrame = false;
		drawSquareButtons = false;
		toolbarDecorated = true;
		menuOpaque = true;
		menuAlpha = 0.9f;
		logoString = "JTattoo";

		controlFont = null;
		systemFont = null;
		userFont = null;
		smallFont = null;
		menuFont = null;
		windowTitleFont = null;

		foregroundColor = BLACK;
		backgroundColor = EXTRA_LIGHT_GRAY;
		backgroundColorLight = WHITE;
		backgroundColorDark = EXTRA_LIGHT_GRAY;
		alterBackgroundColor = LIGHT_GRAY;
		disabledForegroundColor = GRAY;
		disabledBackgroundColor = SUPER_LIGHT_GRAY;
		inputBackgroundColor = WHITE;
		inputForegroundColor = BLACK;
		selectionForegroundColor = BLACK;
		selectionBackgroundColor = LIGHT_GRAY;
		selectionBackgroundColorLight = EXTRA_LIGHT_GRAY;
		selectionBackgroundColorDark = LIGHT_GRAY;
		focusColor = ORANGE;
		focusCellColor = ORANGE;
		focusFrameColor = new ColorUIResource(230, 191, 116);
		focusBackgroundColor = new ColorUIResource(255, 250, 212);
		focusForegroundColor = BLACK;
		frameColor = DARK_GRAY;
		gridColor = GRAY;
		shadowColor = new ColorUIResource(0, 24, 0);

		rolloverForegroundColor = BLACK;
		rolloverColor = EXTRA_LIGHT_GRAY;
		rolloverColorLight = WHITE;
		rolloverColorDark = EXTRA_LIGHT_GRAY;

		pressedForegroundColor = BLACK;
		pressedBackgroundColor = LIGHT_GRAY;
		pressedBackgroundColorLight = new ColorUIResource(ColorHelper.brighter(pressedBackgroundColor, 20));
		pressedBackgroundColorDark = new ColorUIResource(ColorHelper.darker(pressedBackgroundColor, 4));

		buttonForegroundColor = BLACK;
		buttonBackgroundColor = LIGHT_GRAY;
		buttonColorLight = WHITE;
		buttonColorDark = LIGHT_GRAY;

		controlForegroundColor = BLACK;
		controlBackgroundColor = LIGHT_GRAY;
		controlHighlightColor = WHITE;
		controlShadowColor = LIGHT_GRAY;
		controlDarkShadowColor = DARK_GRAY;
		controlColorLight = WHITE;
		controlColorDark = LIGHT_GRAY;

		windowTitleForegroundColor = BLACK;
		windowTitleBackgroundColor = BLUE;
		windowTitleColorLight = EXTRA_LIGHT_GRAY;
		windowTitleColorDark = LIGHT_GRAY;
		windowBorderColor = LIGHT_GRAY;
		windowIconColor = BLACK;
		windowIconShadowColor = WHITE;
		windowIconRolloverColor = RED;

		windowInactiveTitleForegroundColor = BLACK;
		windowInactiveTitleBackgroundColor = EXTRA_LIGHT_GRAY;
		windowInactiveTitleColorLight = WHITE;
		windowInactiveTitleColorDark = EXTRA_LIGHT_GRAY;
		windowInactiveBorderColor = EXTRA_LIGHT_GRAY;

		menuForegroundColor = BLACK;
		menuBackgroundColor = EXTRA_LIGHT_GRAY;
		menuSelectionForegroundColor = BLACK;
		menuSelectionBackgroundColor = LIGHT_GRAY;
		menuSelectionBackgroundColorLight = EXTRA_LIGHT_GRAY;
		menuSelectionBackgroundColorDark = LIGHT_GRAY;
		menuColorLight = EXTRA_LIGHT_GRAY;
		menuColorDark = LIGHT_GRAY;

		toolbarForegroundColor = BLACK;
		toolbarBackgroundColor = LIGHT_GRAY;
		toolbarColorLight = WHITE;
		toolbarColorDark = LIGHT_GRAY;

		tabAreaBackgroundColor = backgroundColor;
		tabSelectionForegroundColor = selectionForegroundColor;
		desktopColor = DARK_BLUE;
		tooltipForegroundColor = BLACK;
		tooltipBackgroundColor = YELLOW;
		tooltipBorderSize = 6;
		tooltipShadowSize = 6;
		tooltipCastShadow = false;

		textureSet = "Default";
		darkTexture = true;
	}

	public void setUpColorArrs() {
		DEFAULT_COLORS = ColorHelper.createColorArr(controlColorLight, controlColorDark, 20);
		HIDEFAULT_COLORS = ColorHelper.createColorArr(ColorHelper.brighter(controlColorLight, 40),
				ColorHelper.brighter(controlColorDark, 40), 20);
		ACTIVE_COLORS = DEFAULT_COLORS;
		INACTIVE_COLORS = HIDEFAULT_COLORS;
		ROLLOVER_COLORS = ColorHelper.createColorArr(rolloverColorLight, rolloverColorDark, 20);
		SELECTED_COLORS = DEFAULT_COLORS;
		SELECTION_COLORS = ColorHelper.createColorArr(selectionBackgroundColorLight, selectionBackgroundColorDark, 20);
		FOCUS_COLORS = ColorHelper.createColorArr(ColorHelper.brighter(focusBackgroundColor, 20),
				ColorHelper.darker(focusBackgroundColor, 10), 20);
		MENU_SELECTION_COLORS = ColorHelper.createColorArr(menuSelectionBackgroundColorLight,
				menuSelectionBackgroundColorDark, 20);
		// PRESSED_COLORS = DEFAULT_COLORS;
		PRESSED_COLORS = ColorHelper.createColorArr(pressedBackgroundColorDark, pressedBackgroundColorLight, 20);
		DISABLED_COLORS = HIDEFAULT_COLORS;
		WINDOW_TITLE_COLORS = ColorHelper.createColorArr(windowTitleColorLight, windowTitleColorDark, 20);
		WINDOW_INACTIVE_TITLE_COLORS = ColorHelper.createColorArr(windowInactiveTitleColorLight,
				windowInactiveTitleColorDark, 20);
		TOOLBAR_COLORS = ColorHelper.createColorArr(toolbarColorLight, toolbarColorDark, 20);
		MENUBAR_COLORS = ColorHelper.createColorArr(menuColorLight, menuColorDark, 20);
		BUTTON_COLORS = ColorHelper.createColorArr(buttonColorLight, buttonColorDark, 20);
		CHECKBOX_COLORS = DEFAULT_COLORS;
		TAB_COLORS = DEFAULT_COLORS;
		COL_HEADER_COLORS = DEFAULT_COLORS;
		TRACK_COLORS = ColorHelper.createColorArr(new Color(220, 220, 220), Color.white, 20);
		THUMB_COLORS = DEFAULT_COLORS;
		SLIDER_COLORS = DEFAULT_COLORS;
		PROGRESSBAR_COLORS = DEFAULT_COLORS;
	}

} // end of class AbstractTheme
