package net.sf.latexdraw.view.svg;

import java.awt.geom.Point2D;
import java.util.List;
import net.sf.latexdraw.models.MathUtils;
import net.sf.latexdraw.models.ShapeFactory;
import net.sf.latexdraw.models.interfaces.shape.IPoint;
import net.sf.latexdraw.models.interfaces.shape.ITriangle;
import net.sf.latexdraw.parsers.svg.SVGAttributes;
import net.sf.latexdraw.parsers.svg.SVGDocument;
import net.sf.latexdraw.parsers.svg.SVGElement;
import net.sf.latexdraw.parsers.svg.SVGGElement;
import net.sf.latexdraw.parsers.svg.SVGPolygonElement;
import net.sf.latexdraw.parsers.svg.parsers.SVGPointsParser;
import net.sf.latexdraw.util.LNamespace;
import net.sf.latexdraw.view.pst.PSTricksConstants;

/**
 * Defines an SVG generator for a triangle.
 * This file is part of LaTeXDraw.
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 *  LaTeXDraw is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  LaTeXDraw is distributed without any warranty; without even the
 *  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 * 11/11/07
 * @author Arnaud BLOUIN
 * @version 3.0
 */
class LTriangleSVGGenerator extends LShapeSVGGenerator<ITriangle> {
	/**
	 * Creates a generator of SVG triangle.
	 * @param triangle The triangle used for the generation.
	 * @throws IllegalArgumentException If the given triangle is null.
	 * @since 2.0
	 */
	protected LTriangleSVGGenerator(final ITriangle triangle) {
		super(triangle);
	}


	/**
	 * Creates a triangle from a latexdraw-SVG element.
	 * @param elt The source element.
	 * @since 2.0.0
	 */
	protected LTriangleSVGGenerator(final SVGGElement elt, final boolean withTransformation) {
		this(ShapeFactory.INST.createTriangle());

		final SVGElement elt2 = getLaTeXDrawElement(elt, null);

		if(elt==null || !(elt2 instanceof SVGPolygonElement))
			throw new IllegalArgumentException();

		final SVGPolygonElement main = (SVGPolygonElement)elt2;
		setSVGLatexdrawParameters(elt);
		setSVGParameters(main);

		final List<Point2D> ptsPol = SVGPointsParser.getPoints(elt.getAttribute(
								 elt.getUsablePrefix(LNamespace.LATEXDRAW_NAMESPACE_URI)+LNamespace.XML_POINTS));

		if(ptsPol==null || ptsPol.size()!=4)
			throw new IllegalArgumentException();

		shape.getPtAt(0).setPoint2D(ptsPol.get(0));
		shape.getPtAt(1).setPoint2D(ptsPol.get(1));
		shape.getPtAt(2).setPoint2D(ptsPol.get(2));
		shape.getPtAt(3).setPoint2D(ptsPol.get(3));

		setSVGShadowParameters(getLaTeXDrawElement(elt, LNamespace.XML_TYPE_SHADOW));
		setSVGDbleBordersParameters(getLaTeXDrawElement(elt, LNamespace.XML_TYPE_DBLE_BORDERS));

		if(withTransformation)
			applyTransformations(elt);

		// Managing inverted triangle.
		if(ptsPol.get(0).getY()>ptsPol.get(2).getY())
			shape.addToRotationAngle(null, Math.PI);
	}




	@Override
	public SVGElement toSVG(final SVGDocument doc) {
		if(doc==null || doc.getFirstChild().getDefs()==null)
			return null;

		final SVGElement root = new SVGGElement(doc);
        SVGElement elt;
        root.setAttribute(LNamespace.LATEXDRAW_NAMESPACE+':'+LNamespace.XML_TYPE, LNamespace.XML_TYPE_TRIANGLE);
		root.setAttribute(SVGAttributes.SVG_ID, getSVGID());
	    final double gap 		= getPositionGap()/2.;
	    final IPoint pt1 		= shape.getTopLeftPoint();
	    final IPoint pt2 		= shape.getBottomRightPoint();
		final IPoint p1 		= ShapeFactory.INST.createPoint((pt1.getX()+pt2.getX())/2., pt1.getY());
		final IPoint p2 		= ShapeFactory.INST.createPoint(pt2.getX(), pt2.getY());
		final IPoint p3 		= ShapeFactory.INST.createPoint(pt1.getX(), pt2.getY());
	    final double p1x = p1.getX();
	    final double p1y = p1.getY();
	    final double p2x = p2.getX();
	    final double p2y = p2.getY();
	    final double p3x = p3.getX();
	    double cornerGap1 = MathUtils.INST.getCornerGap(ShapeFactory.INST.createPoint(p1x, p2y), p1, p2, gap);
	    double cornerGap2 = MathUtils.INST.getCornerGap(shape.getGravityCentre(), p2, p3, gap);

	    if(p2x>p3x)
	    	cornerGap2*=-1;

	    if(p1y>p2y)
	    	cornerGap1*=-1;

		final String points = p1x + "," + (p1y - cornerGap1) + " " + //$NON-NLS-1$//$NON-NLS-2$
						(p2x - cornerGap2) + "," + (p2y + (p1y<p2y ? gap : -gap)) + " " + //$NON-NLS-1$//$NON-NLS-2$
						(p3x + cornerGap2) + "," + (p2y + (p1y<p2y ? gap : -gap));//$NON-NLS-1$
	    final String ltdPoints = pt1.getX() + " " + pt1.getY() + " " + shape.getPtAt(1).getX() + " " + shape.getPtAt(1).getY() +//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
	    					" " + shape.getPtAt(2).getX() + " " + shape.getPtAt(2).getY() + " " + pt2.getX() + " " + pt2.getY();//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$

		if(shape.hasShadow()){
			final SVGElement shad = new SVGPolygonElement(doc);

	   		shad.setAttribute(SVGAttributes.SVG_POINTS, points);
	   		setSVGShadowAttributes(shad, true);
	   		root.appendChild(shad);
		}

        if(shape.hasShadow() && !shape.getLineStyle().getLatexToken().equals(PSTricksConstants.LINE_NONE_STYLE)) {
        	// The background of the borders must be filled is there is a shadow.
    		elt = new SVGPolygonElement(doc);
    		elt.setAttribute(SVGAttributes.SVG_POINTS, points);
    		setSVGBorderBackground(elt, root);
        }

		elt = new SVGPolygonElement(doc);
		elt.setAttribute(SVGAttributes.SVG_POINTS, points);
		root.appendChild(elt);
		root.setAttribute(LNamespace.LATEXDRAW_NAMESPACE+':'+LNamespace.XML_POINTS, ltdPoints);

		if(shape.hasDbleBord()){
			final SVGElement dblBord = new SVGPolygonElement(doc);

			dblBord.setAttribute(SVGAttributes.SVG_POINTS, points);
			setSVGDoubleBordersAttributes(dblBord);
			root.appendChild(dblBord);
		}

		setSVGAttributes(doc, elt, true);
		setSVGRotationAttribute(root);

		return root;
	}
}

