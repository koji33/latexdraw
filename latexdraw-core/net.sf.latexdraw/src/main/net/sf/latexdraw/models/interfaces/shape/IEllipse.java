package net.sf.latexdraw.models.interfaces.shape;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Defines an interface that classes defining an ellipse should implement.<br>
 * <br>
 * This file is part of LaTeXDraw.<br>
 * Copyright (c) 2005-2015 Arnaud BLOUIN<br>
 * <br>
 * LaTeXDraw is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * <br>
 * LaTeXDraw is distributed without any warranty; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br>
 * <br>
 * 07/02/2009<br>
 * @author Arnaud BLOUIN
 * @version 3.0
 * @since 3.0
 */
public interface IEllipse extends IRectangularShape {
	/**
	 * @return The half of the biggest axe.
	 * @since 3.0
	 */
	double getA();


	/**
	 * @return The half of the smallest axe.
	 * @since 3.0
	 */
	double getB();


	/**
	 * Translates the shape to its new centre.
	 * @param centre The new centre.
	 * @since 3.0
	 */
	void setCentre(final IPoint centre);

	/**
	 * @return The center of the ellipse. Cannot be null.
	 */
	@NonNull IPoint getCenter();
}