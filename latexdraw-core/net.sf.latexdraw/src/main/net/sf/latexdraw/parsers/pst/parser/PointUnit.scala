package net.sf.latexdraw.parsers.pst.parser

/**
 * A point which each coordinate may have a unit.
 * This file is part of LaTeXDraw
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 *  LaTeXDraw is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  LaTeXDraw is distributed without any warranty; without even the
 *  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 * 2013-04-01
 * @author Arnaud BLOUIN
 * @version 3.0
 */
class PointUnit(val x:Double, val y:Double, val xUnit:String, val yUnit:String) {
	/**
	 * Duplicates the point.
	 */
	def dup() = new PointUnit(x, y, xUnit, yUnit)
}
