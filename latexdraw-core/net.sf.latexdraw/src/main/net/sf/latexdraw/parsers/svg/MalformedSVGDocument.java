package net.sf.latexdraw.parsers.svg;

/**
 * Defines the exception to use when an SVG document is malformed.
 * This file is part of LaTeXDraw.
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 *  LaTeXDraw is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  LaTeXDraw is distributed without any warranty; without even the
 *  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 * 09/11/07
 * @author Arnaud BLOUIN
 * @version 3.0
 */
public class MalformedSVGDocument extends Exception {
	private static final long	serialVersionUID	= 1L;

	@Override
	public String toString() {
		return "The SVG document is malformed.";//$NON-NLS-1$
	}
}
