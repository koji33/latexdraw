package net.sf.latexdraw.parsers.svg.path;

/**
 * Defines the SVGPath quadratic smooth curveto segment.
 * This file is part of LaTeXDraw.
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 *  LaTeXDraw is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  LaTeXDraw is distributed without any warranty; without even the
 *  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 * 10/20/07
 * @author Arnaud BLOUIN
 * @version 3.0
 */
public class SVGPathSegCurvetoQuadraticSmooth extends SVGPathPointSeg {
	/**
	 * The main constructor.
	 * @param x The X-coordinate of the second point of the curve.
	 * @param y The Y-coordinate of the second point of the curve.
	 * @param isRelative isRelative True: the path segment is relative, false it is absolute.
	 */
	public SVGPathSegCurvetoQuadraticSmooth(final double x, final double y, final boolean isRelative) {
		super(isRelative, x, y);
	}


	@Override
	public String toString() {
        return String.valueOf(isRelative() ? 't' : 'T') + ' ' + x + ' ' + y;
	}
}
