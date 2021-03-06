/*
 * This file is part of LaTeXDraw
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 *  LaTeXDraw is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  LaTeXDraw is distributed without any warranty; without even the
 *  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 */
package net.sf.latexdraw.instruments;

import com.google.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import net.sf.latexdraw.actions.LatexProperties;
import net.sf.latexdraw.actions.ModifyLatexProperties;
import net.sf.latexdraw.util.LNamespace;
import net.sf.latexdraw.util.LPath;
import net.sf.latexdraw.view.latex.LaTeXGenerator;
import net.sf.latexdraw.view.latex.VerticalPosition;
import org.malai.javafx.instrument.JfxInstrument;
import org.malai.javafx.instrument.JfxInteractor;
import org.malai.javafx.instrument.library.CheckboxInteractor;
import org.malai.javafx.instrument.library.ComboBoxInteractor;
import org.malai.javafx.instrument.library.SpinnerInteractor;
import org.malai.javafx.interaction.library.KeysTyped;
import org.malai.undo.Undoable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This instrument modifies the properties of the drawing.
 */
public class DrawingPropertiesCustomiser extends JfxInstrument implements Initializable {
	/** The field that changes the title of the drawing. */
	@FXML private TextField titleField;

	/** The field that changes the label of the drawing. */
	@FXML private TextField labelField;

	/** Defines if the horizontal position of the drawing must be centred. */
	@FXML private CheckBox middleHorizPosCB;

	/** Defines the position of the drawing. */
	@FXML private ComboBox<VerticalPosition> positionCB;

	/** Defines the scale of the drawing. */
	@FXML private Spinner<Double> scaleField;

	/** The LaTeX code generator. */
	@Inject private LaTeXGenerator latexGen;

	/**
	 * Creates the instrument.
	 */
	DrawingPropertiesCustomiser() {
		super();
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		ShapePropertyCustomiser.scrollOnSpinner(scaleField);
		positionCB.getItems().addAll(VerticalPosition.values());
		setActivated(true);
	}

	@Override
	public void onUndoableUndo(final Undoable undoable) {
		super.onUndoableUndo(undoable);
		updateWidgets();
	}

	@Override
	public void onUndoableRedo(final Undoable undoable) {
		super.onUndoableRedo(undoable);
		updateWidgets();
	}

	@Override
	public void reinit() {
		super.reinit();
		latexGen.setCaption(""); //$NON-NLS-1$
		latexGen.setLabel(""); //$NON-NLS-1$
		latexGen.setPositionHoriCentre(false);
		latexGen.setPositionVertToken(VerticalPosition.NONE);
		updateWidgets();
	}

	@Override
	public void save(final boolean generalPreferences, final String nsURI, final Document document, final Element root) {
		super.save(generalPreferences, nsURI, document, root);

		if(document == null || root == null || generalPreferences) return;

		final String ns = LPath.INSTANCE.getNormaliseNamespaceURI(nsURI);

		if(!latexGen.getCaption().isEmpty()) {
			final Element elt = document.createElement(ns + LNamespace.XML_CAPTION);
			elt.appendChild(document.createTextNode(latexGen.getCaption()));
			root.appendChild(elt);
		}
		if(!latexGen.getLabel().isEmpty()) {
			final Element elt = document.createElement(ns + LNamespace.XML_LABEL);
			elt.appendChild(document.createTextNode(latexGen.getLabel()));
			root.appendChild(elt);
		}
		if(latexGen.isPositionHoriCentre()) {
			final Element elt = document.createElement(ns + LNamespace.XML_POSITION_HORIZ);
			elt.setTextContent(String.valueOf(latexGen.isPositionHoriCentre()));
			root.appendChild(elt);
		}
		if(latexGen.getPositionVertToken() != VerticalPosition.NONE) {
			final Element elt = document.createElement(ns + LNamespace.XML_POSITION_VERT);
			elt.setTextContent(latexGen.getPositionVertToken().toString());
			root.appendChild(elt);
		}
	}

	@Override
	public void load(final boolean generalPreferences, final String nsURI, final Element root) {
		super.load(generalPreferences, nsURI, root);

		final String name = root.getNodeName();

		if(name.endsWith(LNamespace.XML_CAPTION)) latexGen.setCaption(root.getTextContent());
		else if(name.endsWith(LNamespace.XML_LABEL)) latexGen.setLabel(root.getTextContent());
		else if(name.endsWith(LNamespace.XML_POSITION_HORIZ)) latexGen.setPositionHoriCentre(Boolean.parseBoolean(root.getTextContent()));
		else if(name.endsWith(LNamespace.XML_POSITION_VERT))
			latexGen.setPositionVertToken(VerticalPosition.getPosition(root.getTextContent()));
	}

	protected void updateWidgets() {
		titleField.setText(latexGen.getCaption());
		labelField.setText(latexGen.getLabel());
		middleHorizPosCB.setSelected(latexGen.isPositionHoriCentre());
		positionCB.setValue(latexGen.getPositionVertToken());
		scaleField.getValueFactory().setValue(latexGen.getScale());
	}

	@Override
	public void setActivated(final boolean isactivated) {
		super.setActivated(isactivated);
		if(isactivated) {
			updateWidgets();
		}
	}

	@Override
	protected void initialiseInteractors() throws IllegalAccessException, InstantiationException {
		addInteractor(new LabelFieldToChangeLabel());
		addInteractor(new titleFieldToChangeCaption());
		addInteractor(new CheckBox2CustDrawing());
		addInteractor(new ComboBox2CustDrawing());
		addInteractor(new Spinner2CustDrawing());
	}

	private class CheckBox2CustDrawing extends CheckboxInteractor<ModifyLatexProperties, DrawingPropertiesCustomiser> {
		CheckBox2CustDrawing() throws InstantiationException, IllegalAccessException {
			super(DrawingPropertiesCustomiser.this, ModifyLatexProperties.class, middleHorizPosCB);
		}

		@Override
		public void initAction() {
			action.setProperty(LatexProperties.POSITION_HORIZONTAL);
			action.setGenerator(instrument.latexGen);
			action.setValue(instrument.middleHorizPosCB.isSelected());
		}
	}

	private class ComboBox2CustDrawing extends ComboBoxInteractor<ModifyLatexProperties, DrawingPropertiesCustomiser> {
		ComboBox2CustDrawing() throws InstantiationException, IllegalAccessException {
			super(DrawingPropertiesCustomiser.this, ModifyLatexProperties.class, positionCB);
		}

		@Override
		public void initAction() {
			action.setProperty(LatexProperties.POSITION_VERTICAL);
			action.setGenerator(instrument.latexGen);
			action.setValue(instrument.positionCB.getSelectionModel().getSelectedItem());
		}
	}

	private class Spinner2CustDrawing extends SpinnerInteractor<ModifyLatexProperties, DrawingPropertiesCustomiser> {
		Spinner2CustDrawing() throws InstantiationException, IllegalAccessException {
			super(DrawingPropertiesCustomiser.this, ModifyLatexProperties.class, scaleField);
		}

		@Override
		public void initAction() {
			action.setProperty(LatexProperties.SCALE);
			action.setGenerator(instrument.latexGen);
		}

		@Override
		public void updateAction() {
			action.setValue(instrument.scaleField.getValue());
		}
	}

	private class LabelFieldToChangeLabel extends JfxInteractor<ModifyLatexProperties, KeysTyped, DrawingPropertiesCustomiser> {
		LabelFieldToChangeLabel() throws InstantiationException, IllegalAccessException {
			super(DrawingPropertiesCustomiser.this, false, ModifyLatexProperties.class, KeysTyped.class, labelField);
		}

		@Override
		public void initAction() {
			action.setProperty(LatexProperties.LABEL);
			action.setGenerator(instrument.latexGen);
		}

		@Override
		public void updateAction() {
			action.setValue(labelField.getText());
		}
	}

	private class titleFieldToChangeCaption extends JfxInteractor<ModifyLatexProperties, KeysTyped, DrawingPropertiesCustomiser> {
		titleFieldToChangeCaption() throws InstantiationException, IllegalAccessException {
			super(DrawingPropertiesCustomiser.this, false, ModifyLatexProperties.class, KeysTyped.class, titleField);
		}

		@Override
		public void initAction() {
			action.setProperty(LatexProperties.CAPTION);
			action.setGenerator(instrument.latexGen);
		}

		@Override
		public void updateAction() {
			action.setValue(titleField.getText());
		}
	}
}
