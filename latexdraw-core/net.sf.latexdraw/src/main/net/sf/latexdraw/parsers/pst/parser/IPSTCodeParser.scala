package net.sf.latexdraw.parsers.pst.parser

import net.sf.latexdraw.models.interfaces.shape.{IGroup, IShape}

import scala.util.parsing.combinator.syntactical.TokenParsers

/**
 * Defines an interface for a parser parsing basic PST expressions.
 * This file is part of LaTeXDraw
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 *  LaTeXDraw is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  LaTeXDraw is distributed without any warranty; without even the
 *  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 * 2013-02-26
 * @author Arnaud BLOUIN
 * @version 3.0
 */
trait IPSTCodeParser extends TokenParsers {
	/** The entry point to parse PST texts. */
	def parsePSTCode(ctx : PSTContext) : Parser[IGroup]

	/** This parser rule parses texts (raw text, unknown commands, math area, etc.) and transforms them into shapes. */
	def parseText(ctx : PSTContext) : Parser[List[IShape]]

	def parsePscustom(ctx : PSTContext) : Parser[IGroup]

	def parseNewpsobject(ctx : PSTContext) : Parser[List[IShape]]

	def parseNewpsstyle(ctx : PSTContext) : Parser[List[IShape]]

	def parseIncludeGraphics(ctx : PSTContext) : Parser[IShape]

	def parsePSTBlock(ctx : PSTContext, isPsCustomBlock : Boolean) : Parser[IGroup]

	/** Parses the command definecolor. */
	def parseDefineColor(ctx:PSTContext) : Parser[Unit]

	/** Parses rput commands. */
	def parseRput(ctx : PSTContext) : Parser[IGroup]

	/** Parses begin{center} \end{center} blocks. */
	def parseCenterBlock(ctx : PSTContext) : Parser[IGroup]

	/** Parses begin{pspicture} \end{pspicture} blocks. */
	def parsePspictureBlock(ctx : PSTContext) : Parser[IGroup]
}