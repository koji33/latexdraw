package test.parser.pst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import net.sf.latexdraw.models.ShapeFactory;
import net.sf.latexdraw.models.interfaces.shape.IDot;
import net.sf.latexdraw.models.interfaces.shape.IGroup;
import net.sf.latexdraw.models.interfaces.shape.IShape;
import net.sf.latexdraw.models.interfaces.shape.IText;
import net.sf.latexdraw.view.latex.DviPsColors;
import net.sf.latexdraw.parsers.pst.parser.PSTParser;

import org.junit.Ignore;
import org.junit.Test;

public class TestTextParsing extends TestPSTParser {
	@Test
	public void testBugParenthesis() throws ParseException {
		IText txt = (IText)parser.parsePSTCode("{( )}").get().getShapeAt(0); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
		assertEquals("( )", txt.getText()); //$NON-NLS-1$
	}

	@Test
	public void test_bf1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\bf coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\bf coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_bf2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\bf {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\bf coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\bf haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_sc1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\sc coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\sc coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_sc2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\sc {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\sc coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\sc haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_sl1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\sl coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\sl coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_sl2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\sl {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\sl coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\sl haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_it1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\it coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\it coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_it2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\it {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\it coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\it haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_scshape1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\scshape coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\scshape coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_scshape2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\scshape {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\sc coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\sc haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_slshape1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\slshape coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\slshape coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_slshape2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\slshape {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\sl coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\sl haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_itshape1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\itshape coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\itshape coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_itshape2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\itshape {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\it coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\it haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_upshape1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\upshape coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\upshape coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_upshape2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\upshape {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_bfseries1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\bfseries coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\bfseries coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_bfseries2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\bfseries {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\bf coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\bf haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_mdseries1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\mdseries coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\mdseries coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_mdseries2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\mdseries {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_ttfamily1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\ttfamily coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\ttfamily coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_ttfamily2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\ttfamily {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\ttfamily coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\ttfamily haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_sffamily1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\sffamily coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\sffamily coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_sffamily2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\sffamily {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\sffamily coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("\\sffamily haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_rmfamily1() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rmfamily coucou").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\rmfamily coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void test_rmfamily2() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rmfamily {coucou} {haha}").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("coucou", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertTrue(group.getShapeAt(1) instanceof IText);
		assertEquals("haha", ((IText)group.getShapeAt(1)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testtextsf() throws ParseException {
		IGroup group = parser.parsePSTCode("\\textsf{coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\textsf{coucou}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testtextsc() throws ParseException {
		IGroup group = parser.parsePSTCode("\\textsc{coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\textsc{coucou}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testtextsl() throws ParseException {
		IGroup group = parser.parsePSTCode("\\textsl{coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\textsl{coucou}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testunderline() throws ParseException {
		IGroup group = parser.parsePSTCode("\\underline{coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\underline{coucou}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testtexttt() throws ParseException {
		IGroup group = parser.parsePSTCode("\\texttt{coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\texttt{coucou}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testEmph() throws ParseException {
		IGroup group = parser.parsePSTCode("\\emph{coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\emph{coucou}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testTextbf() throws ParseException {
		IGroup group = parser.parsePSTCode("\\textbf{coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\textbf{coucou}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testTextit() throws ParseException {
		IGroup group = parser.parsePSTCode("\\textit{coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\textit{coucou}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	@Ignore
	public void testText_withDots() throws ParseException {
		IText txt = (IText)parser.parsePSTCode("0..n").get().getShapeAt(0); //$NON-NLS-1$
		assertEquals("0..n", txt.getText()); //$NON-NLS-1$
	}

	@Test
	@Ignore
	public void testText_withCommas() throws ParseException {
		IText txt = (IText)parser.parsePSTCode("0,fi,n,,a , b").get().getShapeAt(0); //$NON-NLS-1$
		assertEquals("0,fi,n,,a , b", txt.getText()); //$NON-NLS-1$
	}

	@Test
	public void testText_bugParsingSeveralRputCmds() throws ParseException {
		IGroup gp = parser.parsePSTCode("\\rput(0.9,0.6){aa}" + //$NON-NLS-1$
				"\\rput(7.4,0){bb}\\rput(1,0){cc}").get(); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
		assertEquals(3, gp.getShapes().size());
		assertEquals("aa", ((IText)gp.getShapeAt(0)).getText()); //$NON-NLS-1$
		assertEquals("bb", ((IText)gp.getShapeAt(1)).getText()); //$NON-NLS-1$
		assertEquals("cc", ((IText)gp.getShapeAt(2)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testText_when2usefontsTheLatestIsUsed1() throws ParseException {
		IGroup gp = parser.parsePSTCode("\\usefont{T1}{ptm}{m}{it}\\rput(0.9,0.6){aa}" + //$NON-NLS-1$
				"\\rput(7.4,0.92373){bb}\\usefont{T1}{ptm}{b}{sc}\\rput(1.1121212,0.1244){cc}").get(); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
		assertEquals(3, gp.getShapes().size());
		assertTrue(((IText)gp.getShapeAt(0)).getText().contains("\\it")); //$NON-NLS-1$
		assertTrue(((IText)gp.getShapeAt(0)).getText().contains("aa")); //$NON-NLS-1$
		assertTrue(((IText)gp.getShapeAt(1)).getText().contains("\\it")); //$NON-NLS-1$
		assertTrue(((IText)gp.getShapeAt(1)).getText().contains("bb")); //$NON-NLS-1$
		assertTrue(((IText)gp.getShapeAt(2)).getText().contains("\\sc")); //$NON-NLS-1$
		assertTrue(((IText)gp.getShapeAt(2)).getText().contains("\\bf")); //$NON-NLS-1$
		assertTrue(((IText)gp.getShapeAt(2)).getText().contains("cc")); //$NON-NLS-1$
	}

	@Test
	public void testText_when2usefontsTheLatestIsUsed2() throws ParseException {
		IText txt = (IText)parser.parsePSTCode("\\usefont{T1}{ptm}{m}{n}\n aa" + //$NON-NLS-1$
				"\\usefont{T1}{ptm}{b}{it}\n bb").get().getShapeAt(0); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
		assertTrue(txt.getText().contains("usefont{T1}{ptm}{m}{n}")); //$NON-NLS-1$
		assertTrue(txt.getText().contains("usefont{T1}{ptm}{b}{it}")); //$NON-NLS-1$
		assertTrue(txt.getText().contains("aa")); //$NON-NLS-1$
		assertTrue(txt.getText().contains("bb")); //$NON-NLS-1$
	}

	@Test
	public void testTextWithSpecialColour() throws ParseException {
		IText txt = (IText)parser.parsePSTCode("\\definecolor{color0}{rgb}{0.5,0.5,0.5}\\color{color0}couocu").get().getShapeAt(0); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
		assertNotNull(txt);
		assertEquals(ShapeFactory.INST.createColor(0.5, 0.5, 0.5), txt.getLineColour());
	}

	@Test
	public void testBug722075_3() throws ParseException {
		// https://bugs.launchpad.net/latexdraw/+bug/722075
		IGroup group = parser.parsePSTCode("\\textcolor{blue}{xyz} foobar").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("foobar", text.getText()); //$NON-NLS-1$
		assertEquals(DviPsColors.BLACK, text.getLineColour());
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testBug722075_2() throws ParseException {
		// https://bugs.launchpad.net/latexdraw/+bug/722075
		IGroup group = parser.parsePSTCode("\\textcolor{blue}{xyz}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("xyz", text.getText()); //$NON-NLS-1$
		assertEquals(DviPsColors.BLUE, text.getLineColour());
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testBug722075_1() throws ParseException {
		// https://bugs.launchpad.net/latexdraw/+bug/722075
		IGroup group = parser.parsePSTCode("\\color{blue} xyz").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("xyz", text.getText()); //$NON-NLS-1$
		assertEquals(DviPsColors.BLUE, text.getLineColour());
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testBug911816() throws ParseException {
		// https://bugs.launchpad.net/latexdraw/+bug/911816
		IGroup group = parser.parsePSTCode("\\psframebox{$E=mc^2$}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\psframebox{$E=mc^2$}", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_footnote() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\footnotesize coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\footnotesize coucou", text.getText()); //$NON-NLS-1$
		assertEquals(1. * IShape.PPC, text.getPosition().getX(), 0.001);
		assertEquals(-2. * IShape.PPC, text.getPosition().getY(), 0.001);
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_tiny() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\tiny coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\tiny coucou", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_scriptsize() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\scriptsize coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\scriptsize coucou", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_footnotesize() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\footnotesize coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\footnotesize coucou", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_small() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\small coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\small coucou", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_normalsize() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\normalsize coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\normalsize coucou", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_large() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\large coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\large coucou", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_Large() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\Large coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\Large coucou", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_huge() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\huge coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\huge coucou", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseText_Huge() throws ParseException {
		IGroup group = parser.parsePSTCode("\\rput(1,2){\\Huge coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\Huge coucou", text.getText()); //$NON-NLS-1$
		assertTrue(PSTParser.errorLogs().isEmpty());
	}

	@Test
	public void testParseTextLD2_bold_italic() throws ParseException {
		IGroup group = parser.parsePSTCode("\\usefont{T1}{ptm}{b}{it}\\rput(1,2){coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\it\\bf coucou", text.getText()); //$NON-NLS-1$
		assertEquals(1. * IShape.PPC, text.getPosition().getX(), 0.001);
		assertEquals(-2. * IShape.PPC, text.getPosition().getY(), 0.001);
	}

	@Test
	public void testParseTextLD2_bold() throws ParseException {
		IGroup group = parser.parsePSTCode("\\usefont{T1}{ptm}{b}{n}\\rput(1,2){coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\bf coucou", text.getText()); //$NON-NLS-1$
		assertEquals(1. * IShape.PPC, text.getPosition().getX(), 0.001);
		assertEquals(-2. * IShape.PPC, text.getPosition().getY(), 0.001);
	}

	@Test
	public void testParseTextLD2_italic() throws ParseException {
		IGroup group = parser.parsePSTCode("\\usefont{T1}{ptm}{m}{it}\\rput(1,2){coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("\\it coucou", text.getText()); //$NON-NLS-1$
		assertEquals(1. * IShape.PPC, text.getPosition().getX(), 0.001);
		assertEquals(-2. * IShape.PPC, text.getPosition().getY(), 0.001);
	}

	@Test
	public void testParseTextLD2_basic() throws ParseException {
		IGroup group = parser.parsePSTCode("\\usefont{T1}{ptm}{m}{n}\\rput(1,2){coucou}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		IText text = (IText)group.getShapeAt(0);
		assertEquals("coucou", text.getText()); //$NON-NLS-1$
		assertEquals(1. * IShape.PPC, text.getPosition().getX(), 0.001);
		assertEquals(-2. * IShape.PPC, text.getPosition().getY(), 0.001);
	}

	@Test
	public void testBackSlashBackSlashIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\\\").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\\\", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashSharpIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\#").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\#", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashPercentIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\%").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\%", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashUnderscoreIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\_").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\_", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashAmperstampIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\&").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\&", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashRightBracketIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashLeftBracketIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\{").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\{", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashHatIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\^").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\^", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashDollarIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\$").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashTildeIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\~").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\~", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashDoubleQuoteIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\\"").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\\"", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashQuoteIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\'").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\'", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashMultIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\*").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\*", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashCommaIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\,").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\,", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashSlashIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\/").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\/", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashDotIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\.").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\.", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashArobasIsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\@").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\@", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashQuote2IsACommand() throws ParseException {
		IGroup group = parser.parsePSTCode("\\`").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\`", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashDoubleQuoteLetter() throws ParseException {
		IGroup group = parser.parsePSTCode("\\\"e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\\" e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testUnknownCommandParsedAsText() throws ParseException {
		IGroup group = parser.parsePSTCode("\\thisisnotacommande").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\thisisnotacommande", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testBackSlashDoubleQuoteLetterBrackets() throws ParseException {
		IGroup group = parser.parsePSTCode("\\\"{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\\"{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentGraveBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\`{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\`{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentGrave() throws ParseException {
		IGroup group = parser.parsePSTCode("\\`e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\` e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentAcuteBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\'{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\'{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentAcute() throws ParseException {
		IGroup group = parser.parsePSTCode("\\'e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\' e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentcircumflexBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\^{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\^{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentcircumflex() throws ParseException {
		IGroup group = parser.parsePSTCode("\\^e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\^ e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentHumlautBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\H{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\H{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentHumlaut() throws ParseException {
		IGroup group = parser.parsePSTCode("\\H e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\H e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccenttildeBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\~{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\~{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccenttilde() throws ParseException {
		IGroup group = parser.parsePSTCode("\\~e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\~ e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentcedillaBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\c{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\c{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentcedilla() throws ParseException {
		IGroup group = parser.parsePSTCode("\\c e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\c e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentogonekBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\k{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\k{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentogonek() throws ParseException {
		IGroup group = parser.parsePSTCode("\\k e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\k e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentlBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\l").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\l", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentmacronBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\={ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\={ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentmacron() throws ParseException {
		IGroup group = parser.parsePSTCode("\\=e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\= e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentbarUnderBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\b{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\b{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentbarUnder() throws ParseException {
		IGroup group = parser.parsePSTCode("\\b e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\b e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentdotOverBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\.{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\.{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentdotOver() throws ParseException {
		IGroup group = parser.parsePSTCode("\\.e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\. e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentdotUnderBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\d{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\d{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentDotUnder() throws ParseException {
		IGroup group = parser.parsePSTCode("\\d e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\d e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentRingOverBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\r{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\r{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentRingOver() throws ParseException {
		IGroup group = parser.parsePSTCode("\\r e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\r e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentbreveBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\u{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\u{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentbreve() throws ParseException {
		IGroup group = parser.parsePSTCode("\\u e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\u e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentcaronBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\v{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\v{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccentcaron() throws ParseException {
		IGroup group = parser.parsePSTCode("\\v e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\v e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccenttieBlock() throws ParseException {
		IGroup group = parser.parsePSTCode("\\t{ee}").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\t{ee}", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testAccenttie() throws ParseException {
		IGroup group = parser.parsePSTCode("\\t e").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\t e", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testMathModeStd() throws ParseException {
		IGroup group = parser.parsePSTCode("$coucou$").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$coucou$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test(expected = ParseException.class)
	public void testMathModeNotClosed() throws ParseException {
		parser.parsePSTCode("$foo"); //$NON-NLS-1$
	}

	@Test
	public void testMathModeWithSpecialCharacters() throws ParseException {
		IGroup group = parser.parsePSTCode("$foo_{test}$").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$foo_{test}$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$

		group = parser.parsePSTCode("$\\|$").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$\\|$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$

		group = parser.parsePSTCode("$\\mathcal{M}$").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$\\mathcal{M}$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testMathModeStdParenthesis() throws ParseException {
		IGroup group = parser.parsePSTCode("\\(coucou\\)").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$coucou$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test(expected = ParseException.class)
	public void testMathModeNotClosedParenthesis() throws ParseException {
		parser.parsePSTCode("\\(foo"); //$NON-NLS-1$
	}

	@Test
	public void testMathModeWithSpecialCharactersParenthesis() throws ParseException {
		IGroup group = parser.parsePSTCode("\\(foo_{test}\\)").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$foo_{test}$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$

		group = parser.parsePSTCode("\\(\\|\\)").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$\\|$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$

		group = parser.parsePSTCode("\\(\\mathcal{M}\\)").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$\\mathcal{M}$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testMathModeStdBrackets() throws ParseException {
		IGroup group = parser.parsePSTCode("\\[coucou\\]").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$coucou$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test(expected = ParseException.class)
	public void testMathModeNotClosedBrackets() throws ParseException {
		parser.parsePSTCode("\\[foo"); //$NON-NLS-1$
	}

	@Test
	public void testMathModeWithSpecialCharactersBrackets() throws ParseException {
		IGroup group = parser.parsePSTCode("\\[foo_{test}\\]").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$foo_{test}$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$

		group = parser.parsePSTCode("\\[\\|\\]").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$\\|$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$

		group = parser.parsePSTCode("\\[\\mathcal{M}\\]").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("$\\mathcal{M}$", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testParse1WordBracketedInto1TextShape() throws ParseException {
		IGroup group = parser.parsePSTCode("{ foo }").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("foo", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testParse1WordInto1TextShape() throws ParseException {
		IGroup group = parser.parsePSTCode("foo").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("foo", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testParse2WordsInto1TextShape() throws ParseException {
		IGroup group = parser.parsePSTCode("foo bar").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("foo bar", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testParseMixedTextInto1TextShape() throws ParseException {
		IGroup group = parser.parsePSTCode("foo \\bloodyCmd $math formula_{r}$ bar").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("foo \\bloodyCmd $math formula_{r}$ bar", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testParseFloatNumbersInto1TextShape() throws ParseException {
		IGroup group = parser.parsePSTCode("121.1248 -.1 ++1").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("121.1248 -.1 ++1", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testParseNumberInto1TextShape() throws ParseException {
		IGroup group = parser.parsePSTCode("121").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("121", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testParseUnknownCmdInto1TextShape() throws ParseException {
		IGroup group = parser.parsePSTCode("\\bloodyCmd").get(); //$NON-NLS-1$
		assertEquals(1, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertEquals("\\bloodyCmd", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Test
	public void testParseMixedTextAndShapeInto2TextShapesAnd1Shape() throws ParseException {
		IGroup group = parser.parsePSTCode("foo bar \\psdot(1,1) foo $math formula_{r}$ bar").get(); //$NON-NLS-1$
		assertEquals(2, group.size());
		assertTrue(group.getShapeAt(0) instanceof IText);
		assertTrue(group.getShapeAt(1) instanceof IDot);
		assertEquals("foo bar foo $math formula_{r}$ bar", ((IText)group.getShapeAt(0)).getText()); //$NON-NLS-1$
	}

	@Override
	public String getCommandName() {
		return ""; //$NON-NLS-1$
	}

	@Override
	public String getBasicCoordinates() {
		return ""; //$NON-NLS-1$
	}
}
