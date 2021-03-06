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
package com.jtattoo.plaf.bernstein;

import javax.swing.Icon;

import com.jtattoo.plaf.AbstractIconFactory;
import com.jtattoo.plaf.BaseIcons;

/**
 * @author Michael Hagen
 */
public class BernsteinIconFactory implements AbstractIconFactory {

	private static BernsteinIconFactory instance = null;

	public static synchronized BernsteinIconFactory getInstance() {
		if (instance == null) {
			instance = new BernsteinIconFactory();
		}
		return instance;
	}

	private BernsteinIconFactory() {
	}

	@Override
	public Icon getCheckBoxIcon() {
		return BernsteinIcons.getCheckBoxIcon();
	}

	@Override
	public Icon getCloseIcon() {
		return BaseIcons.getCloseIcon();
	}

	@Override
	public Icon getComboBoxIcon() {
		return BaseIcons.getComboBoxIcon();
	}

	@Override
	public Icon getDownArrowIcon() {
		return BaseIcons.getDownArrowIcon();
	}

	@Override
	public Icon getFileChooserDetailViewIcon() {
		return BaseIcons.getFileChooserDetailViewIcon();
	}

	@Override
	public Icon getFileChooserHomeFolderIcon() {
		return BaseIcons.getFileChooserHomeFolderIcon();
	}

	@Override
	public Icon getFileChooserListViewIcon() {
		return BaseIcons.getFileChooserListViewIcon();
	}

	@Override
	public Icon getFileChooserNewFolderIcon() {
		return BaseIcons.getFileChooserNewFolderIcon();
	}

	@Override
	public Icon getFileChooserUpFolderIcon() {
		return BaseIcons.getFileChooserUpFolderIcon();
	}

	@Override
	public Icon getFileViewComputerIcon() {
		return BaseIcons.getFileViewComputerIcon();
	}

	@Override
	public Icon getFileViewFloppyDriveIcon() {
		return BaseIcons.getFileViewFloppyDriveIcon();
	}

	@Override
	public Icon getFileViewHardDriveIcon() {
		return BaseIcons.getFileViewHardDriveIcon();
	}

	@Override
	public Icon getIconIcon() {
		return BaseIcons.getIconIcon();
	}

	@Override
	public Icon getLeftArrowIcon() {
		return BaseIcons.getLeftArrowIcon();
	}

	@Override
	public Icon getMaxIcon() {
		return BaseIcons.getMaxIcon();
	}

	@Override
	public Icon getMenuArrowIcon() {
		return BaseIcons.getMenuArrowIcon();
	}

	@Override
	public Icon getMenuCheckBoxIcon() {
		return BaseIcons.getMenuCheckBoxIcon();
	}

	@Override
	public Icon getMenuIcon() {
		return BaseIcons.getMenuIcon();
	}

	@Override
	public Icon getMenuRadioButtonIcon() {
		return BaseIcons.getMenuRadioButtonIcon();
	}

	@Override
	public Icon getMinIcon() {
		return BaseIcons.getMinIcon();
	}

	@Override
	public Icon getOptionPaneErrorIcon() {
		return BaseIcons.getOptionPaneErrorIcon();
	}

	@Override
	public Icon getOptionPaneInformationIcon() {
		return BaseIcons.getOptionPaneInformationIcon();
	}

	@Override
	public Icon getOptionPaneQuestionIcon() {
		return BaseIcons.getOptionPaneQuestionIcon();
	}

	@Override
	public Icon getOptionPaneWarningIcon() {
		return BaseIcons.getOptionPaneWarningIcon();
	}

	@Override
	public Icon getPaletteCloseIcon() {
		return BaseIcons.getPaletteCloseIcon();
	}

	@Override
	public Icon getRadioButtonIcon() {
		return BernsteinIcons.getRadioButtonIcon();
	}

	@Override
	public Icon getRightArrowIcon() {
		return BaseIcons.getRightArrowIcon();
	}

	@Override
	public Icon getSplitterDownArrowIcon() {
		return BernsteinIcons.getSplitterDownArrowIcon();
	}

	@Override
	public Icon getSplitterHorBumpIcon() {
		return BaseIcons.getSplitterHorBumpIcon();
	}

	@Override
	public Icon getSplitterLeftArrowIcon() {
		return BernsteinIcons.getSplitterLeftArrowIcon();
	}

	@Override
	public Icon getSplitterRightArrowIcon() {
		return BernsteinIcons.getSplitterRightArrowIcon();
	}

	@Override
	public Icon getSplitterUpArrowIcon() {
		return BernsteinIcons.getSplitterUpArrowIcon();
	}

	@Override
	public Icon getSplitterVerBumpIcon() {
		return BaseIcons.getSplitterVerBumpIcon();
	}

	@Override
	public Icon getThumbHorIcon() {
		return BernsteinIcons.getThumbHorIcon();
	}

	@Override
	public Icon getThumbHorIconRollover() {
		return BernsteinIcons.getThumbHorIconRollover();
	}

	@Override
	public Icon getThumbVerIcon() {
		return BernsteinIcons.getThumbVerIcon();
	}

	@Override
	public Icon getThumbVerIconRollover() {
		return BernsteinIcons.getThumbVerIconRollover();
	}

	@Override
	public Icon getTreeCloseIcon() {
		return BaseIcons.getTreeClosedIcon();
	}

	@Override
	public Icon getTreeCollapsedIcon() {
		return BaseIcons.getTreeCollapsedIcon();
	}

	@Override
	public Icon getTreeExpandedIcon() {
		return BaseIcons.getTreeExpandedIcon();
	}

	@Override
	public Icon getTreeLeafIcon() {
		return BaseIcons.getTreeLeafIcon();
	}

	@Override
	public Icon getTreeOpenIcon() {
		return BaseIcons.getTreeOpenedIcon();
	}

	@Override
	public Icon getUpArrowIcon() {
		return BaseIcons.getUpArrowIcon();
	}

} // end of class BernsteinIconFactory
