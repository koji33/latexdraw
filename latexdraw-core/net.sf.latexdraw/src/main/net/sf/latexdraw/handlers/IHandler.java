package net.sf.latexdraw.handlers;

import java.awt.Graphics2D;
import java.awt.Shape;
import net.sf.latexdraw.models.interfaces.shape.IPoint;
import net.sf.latexdraw.models.interfaces.shape.IShape;
import org.malai.picking.Pickable;

/**
 * This interface defines a handler.
 * This file is part of LaTeXDraw
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 *  LaTeXDraw is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  LaTeXDraw is distributed without any warranty; without even the
 *  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 * 08/29/11
 * @author Arnaud BLOUIN
 * @version 3.0
 * @param <T> The type of the shape model that the handler controls.
 */
public interface IHandler<T extends IShape> extends Pickable {
	/** The default size of a handler. */
	int DEFAULT_SIZE = 16;

	/**
	 * Updates the handler using the given shape.
	 * @param shape The shape used to updated the handler.
	 * @since 3.0
	 */
	void updateFromShape(final Shape shape);

	/**
	 * Changes the centre of the handler and updates the shape.
	 * @param x The new X coordinate.
	 * @param y The new Y coordinate.
	 */
	void setPoint(final double x, final double y);


	/**
	 * @return The centre of the handler.
	 */
	IPoint getCentre();

	/**
	 * paint the handler.
	 * @param g The object into which objects are painted.
	 */
	void paint(final Graphics2D g);

	/**
	 * Updates the handler.
	 * @param shape The shape model.
	 * @param zoom The current zoom level.
	 */
	void update(final T shape, final double zoom);
}
