/*
 * This file is part of LaTeXDraw
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 * LaTeXDraw is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * LaTeXDraw is distributed without any warranty; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
package net.sf.latexdraw.view.jfx;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import net.sf.latexdraw.models.interfaces.shape.IDot;
import net.sf.latexdraw.models.interfaces.shape.IPlot;
import net.sf.latexdraw.view.PlotViewHelper;

/**
 * The JFX view of a plot.
 */
public class ViewPlot extends ViewPositionShape<IPlot> {
	private ViewPolyline lineView;
	private ViewPolygon polygonView;
	private ViewBezierCurve curveView;
	private List<ViewDot> dotsView;
	private final ChangeListener<Object> updatePath = (observable, oldValue, newValue) -> updatePath();

	/**
	 * Creates the view.
	 * @param sh The model.
	 */
	ViewPlot(final IPlot sh) {
		super(sh);

		model.plotEquationProperty().addListener(updatePath);
		model.dotDiametreProperty().addListener(updatePath);
		model.dotStyleProperty().addListener(updatePath);
		model.nbPlottedPointsProperty().addListener(updatePath);
		model.plotMaxXProperty().addListener(updatePath);
		model.plotMinXProperty().addListener(updatePath);
		model.plotStyleProperty().addListener(updatePath);
		model.polarProperty().addListener(updatePath);
		model.xScaleProperty().addListener(updatePath);
		model.yScaleProperty().addListener(updatePath);

		updatePath();
	}

	private void updatePath() {
		final double minX = model.getPlotMinX();
		final double maxX = model.getPlotMaxX();
		final double step = model.getPlottingStep();

		getChildren().forEach(ch -> {
			if(ch instanceof ViewShape<?>) {
				((ViewShape<?>) ch).flush();
			}
		});
		getChildren().clear();

		switch(model.getPlotStyle()) {
			case LINE:
				updateLine(minX, maxX, step);
				break;
			case CURVE:
				updateCurve(minX, maxX, step);
				break;
			case ECURVE:
				updateCurve(minX + step, maxX - step, step);
				break;
			case CCURVE:
				updateCurve(minX, maxX, step);
				break;
			case DOTS:
				updatePoints(minX, maxX, step);
				break;
			case POLYGON:
				updatePolygon(minX, maxX, step);
				break;
		}
	}


	private void updatePoints(final double minX, final double maxX, final double step) {
		if(dotsView == null) {
			dotsView = new ArrayList<>();
		}else {
			for(ViewDot v : dotsView) {
				v.flush();
			}
			dotsView.clear();
		}

		final List<IDot> dots = PlotViewHelper.INSTANCE.updatePoints(model, 0d, 0d, minX, maxX, step);

		for(final IDot dot : dots) {
			dotsView.add(new ViewDot(dot));
		}
		getChildren().addAll(dotsView);
	}

	private void updatePolygon(final double minX, final double maxX, final double step) {
		polygonView = new ViewPolygon(PlotViewHelper.INSTANCE.updatePolygon(model, 0d, 0d, minX, maxX, step));
		getChildren().add(polygonView);
	}


	private void updateLine(final double minX, final double maxX, final double step) {
		lineView = new ViewPolyline(PlotViewHelper.INSTANCE.updateLine(model, 0d, 0d, minX, maxX, step));
		getChildren().add(lineView);
	}


	private void updateCurve(final double minX, final double maxX, final double step) {
		curveView = new ViewBezierCurve(PlotViewHelper.INSTANCE.updateCurve(model, 0d, 0d, minX, maxX, step));
		getChildren().add(curveView);
	}

	@Override
	public void flush() {
		super.flush();

		model.plotEquationProperty().removeListener(updatePath);
		model.dotDiametreProperty().removeListener(updatePath);
		model.dotStyleProperty().removeListener(updatePath);
		model.nbPlottedPointsProperty().removeListener(updatePath);
		model.plotMaxXProperty().removeListener(updatePath);
		model.plotMinXProperty().removeListener(updatePath);
		model.plotStyleProperty().removeListener(updatePath);
		model.polarProperty().removeListener(updatePath);
		model.xScaleProperty().removeListener(updatePath);
		model.yScaleProperty().removeListener(updatePath);

		if(lineView != null) {
			lineView.flush();
		}
		if(curveView != null) {
			curveView.flush();
		}
		if(dotsView != null) {
			for(ViewDot v : dotsView) {
				v.flush();
			}
			dotsView.clear();
		}
		if(polygonView != null) {
			polygonView.flush();
		}
	}
}
