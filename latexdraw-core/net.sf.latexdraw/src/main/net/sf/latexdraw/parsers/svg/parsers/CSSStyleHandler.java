package net.sf.latexdraw.parsers.svg.parsers;

/**
 * Defines the model of a CSS style handler.
 * This file is part of LaTeXDraw.
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 *  LaTeXDraw is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  LaTeXDraw is distributed without any warranty; without even the
 *  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 * 10/24/07
 * @author Arnaud BLOUIN
 * @version 3.0
 */
public interface CSSStyleHandler {
	/**
	 * Actions to do when a CSS style is parsed.
	 * @param name The name of the style.
	 * @param value The value of the style.
	 */
	void onCSSStyle(final String name, final String value);
}
