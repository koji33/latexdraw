package test.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.sf.latexdraw.models.ShapeFactory;
import net.sf.latexdraw.models.interfaces.shape.ICircle;
import net.sf.latexdraw.models.interfaces.shape.IPositionShape;
import net.sf.latexdraw.models.interfaces.shape.IRectangle;
import net.sf.latexdraw.models.interfaces.shape.IRectangularShape;
import net.sf.latexdraw.models.interfaces.shape.IShape;
import net.sf.latexdraw.models.interfaces.shape.ITriangle;

import org.junit.Before;
import org.junit.Test;

import test.models.interfaces.TestITriangle;

public class TestLTriangle extends TestITriangle<ITriangle> {
	@Before
	public void setUp() {
		shape = ShapeFactory.INST.createTriangle();
		shape2 = ShapeFactory.INST.createTriangle();
	}

	@Override
	@Test
	public void testIsTypeOf() {
		assertFalse(shape.isTypeOf(null));
		assertFalse(shape.isTypeOf(IRectangle.class));
		assertFalse(shape.isTypeOf(ICircle.class));
		assertTrue(shape.isTypeOf(IShape.class));
		assertTrue(shape.isTypeOf(IPositionShape.class));
		assertTrue(shape.isTypeOf(IRectangularShape.class));
		assertTrue(shape.isTypeOf(ITriangle.class));
		assertTrue(shape.isTypeOf(shape.getClass()));
	}
}
