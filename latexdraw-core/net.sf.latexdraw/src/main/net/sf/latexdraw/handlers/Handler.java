package net.sf.latexdraw.handlers;

import java.awt.Graphics2D;
import java.awt.Shape;
import net.sf.latexdraw.models.MathUtils;
import net.sf.latexdraw.models.ShapeFactory;
import net.sf.latexdraw.models.interfaces.shape.Color;
import net.sf.latexdraw.models.interfaces.shape.IPoint;
import net.sf.latexdraw.models.interfaces.shape.IShape;
import org.malai.picking.Picker;

/**
 * A handler helps to manipulate and to delimit a shape view.
 * This file is part of LaTeXDraw
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 *  LaTeXDraw is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  LaTeXDraw is distributed without any warranty; without even the
 *  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 * 08/28/11
 * @author Arnaud BLOUIN
 * @version 3.0
 */
abstract class Handler<T extends Shape, S extends IShape> implements IHandler<S> {
	/** The coordinates of the centre of the delimiter. */
	protected IPoint point;

	/** The size of the handler. */
	protected double size;

	/** The opacity of the delimiters. Can be changed. */
	protected double opacity;

	/** The colour of the handler. */
	protected Color colour;

	/** The shape of the handler. */
	protected T shape;


	/**
	 * Creates the handler.
	 */
    protected Handler() {
		super();
		opacity	= 0.4;
		size   	= DEFAULT_SIZE;
		colour 	= ShapeFactory.INST.createColor(0, 0, 0, opacity);
		point  	= ShapeFactory.INST.createPoint();
	}


	/**
	 * Changes the centre of the handler and updates the shape.
	 * @param x The new X coordinate.
	 * @param y The new Y coordinate.
	 */
	@Override
	public void setPoint(final double x, final double y) {
		if(MathUtils.INST.isValidPt(x, y)) {
			point.setPoint(x, y);
			updateShape();
		}
	}


	/**
	 * @return The centre of the handler.
	 */
	@Override
	public IPoint getCentre() {
		return point;
	}


	/**
	 * paint the handler.
	 */
	@Override
	public void paint(final Graphics2D g) {
		if(g==null) return ;

		g.setColor(colour.toAWT());
		g.fill(shape);
	}


	/**
	 * Updates the handler.
	 */
	@Override
	public void update(final S model, final double zoom) {
		colour.setO(opacity);
		updateShape();
	}


	/**
	 * Updates the Java2D shape of the handler.
	 * @since 3.0
	 */
	protected abstract void updateShape();


	@Override
	public String toString() {
        return super.toString() + "[centre=" + point + ", size=" + size + ", colour=" + colour + ']'; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public void updateFromShape(final Shape sh) {
		updateShape();
	}


	@Override
	public boolean contains(final double x, final double y) {
		return shape.contains(x, y);
	}


	@Override
	public Picker getPicker() {
		return null;
	}
}
