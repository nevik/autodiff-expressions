/**
 * ISC License Terms (http://opensource.org/licenses/isc-license):
 *
 * Copyright (c) 2015, Patrick Lehner <lehner dot patrick at gmx dot de>
 *
 * Permission to use, copy, modify, and/or distribute this software for any purpose with or without fee is hereby
 * granted, provided that the above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT,
 * INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN
 * AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
 * PERFORMANCE OF THIS SOFTWARE.
 */

package nevik.autodiff.expr.real;

import nevik.autodiff.expr.real.visitor.VisitorRealExpression;

import java.util.Arrays;
import java.util.List;

/**
 * N-ary multiplication expression, i.e. product of 1 or more terms.
 *
 * @author Patrick Lehner
 * @since 2015-10-03
 */
public class RealExprMultiplication extends RealSuperExpression {
	// ===============================================================================================================
	// ====  Static fields and methods  ==============================================================================
	// ===============================================================================================================
	private static final int HASHCODE_PRIME_OFFSET = 10867;

	/**
	 * Create a new multiplication expression containing the given list of sub-expressions, in sorted order.
	 * <p/>
	 * The given list of sub-expressions is shallow-copied internally, so the list reference used can be freely
	 * modified afterwards.
	 *
	 * @param subexpressions
	 * 		list of sub-expressions contained in this multiplication expression; must be non-{@code null}, must not be
	 * 		empty, and must not contain any {@code null} elements
	 * @throws NullPointerException
	 * 		if {@code subexpressions} is {@code null}
	 * @throws IllegalArgumentException
	 * 		if {@code subexpressions} is empty or contains a {@code null} entry
	 */
	public static RealExprMultiplication reMult(final List<RealExpression> subexpressions) {
		return new RealExprMultiplication(subexpressions, /*sortSubexprs=*/true);
	}

	/**
	 * Create a new multiplication expression containing the given sub-expressions in the given order.
	 * <p/>
	 * The given list of sub-expressions is shallow-copied internally, so the list reference used can be freely
	 * modified afterwards.
	 *
	 * @param subexpressions
	 * 		one or more sub-expressions contained in this multiplication expression; must be non-{@code null} (if passed
	 * 		as array), must not be empty, and must not contain any {@code null} elements
	 * @throws java.lang.NullPointerException
	 * 		if {@code subexpressions} is {@code null}
	 * @throws java.lang.IllegalArgumentException
	 * 		if {@code subexpressions} is empty or contains a {@code null} entry
	 */
	public static RealExprMultiplication reMult(final RealExpression... subexpressions) {
		return new RealExprMultiplication(Arrays.asList(subexpressions), /*sortSubexprs=*/true);
	}

	/**
	 * Create a new multiplication expression containing the given list of sub-expressions in the given order (w/o
	 * resorting).
	 * <p/>
	 * The given list of sub-expressions is shallow-copied internally, so the list reference used can be freely
	 * modified afterwards.
	 *
	 * @param subexpressions
	 * 		list of sub-expressions contained in this multiplication expression; must be non-{@code null}, must not be
	 * 		empty, and must not contain any {@code null} elements
	 * @throws NullPointerException
	 * 		if {@code subexpressions} is {@code null}
	 * @throws IllegalArgumentException
	 * 		if {@code subexpressions} is empty or contains a {@code null} entry
	 */
	public static RealExprMultiplication reMultUsrtd(final List<RealExpression> subexpressions) {
		return new RealExprMultiplication(subexpressions, /*sortSubexprs=*/false);
	}

	/**
	 * Create a new multiplication expression containing the given sub-expressions in the given order (w/o resorting).
	 * <p/>
	 * The given list of sub-expressions is shallow-copied internally, so the list reference used can be freely
	 * modified afterwards.
	 *
	 * @param subexpressions
	 * 		one or more sub-expressions contained in this multiplication expression; must be non-{@code null} (if passed
	 * 		as array), must not be empty, and must not contain any {@code null} elements
	 * @throws java.lang.NullPointerException
	 * 		if {@code subexpressions} is {@code null}
	 * @throws java.lang.IllegalArgumentException
	 * 		if {@code subexpressions} is empty or contains a {@code null} entry
	 */
	public static RealExprMultiplication reMultUsrtd(final RealExpression... subexpressions) {
		return new RealExprMultiplication(Arrays.asList(subexpressions), /*sortSubexprs=*/false);
	}

	// ===============================================================================================================
	// ====  Instance fields and methods  ============================================================================
	// ===============================================================================================================

	protected final int hashCode;

	/**
	 * Create a new multiplication expression containing the given list of sub-expressions, in sorted order. The
	 * subexpressions are sorted according to {@link RealExpression#COMPARATOR}.
	 * <p/>
	 * The given list of sub-expressions is shallow-copied internally, so the list reference used can be freely
	 * modified afterwards.
	 *
	 * @param subexpressions
	 * 		list of sub-expressions contained in this multiplication expression; must be non-{@code null}, must not be
	 * 		empty, and must not contain any {@code null} elements
	 * @throws NullPointerException
	 * 		if {@code subexpressions} is {@code null}
	 * @throws IllegalArgumentException
	 * 		if {@code subexpressions} is empty or contains a {@code null} entry
	 */
	public RealExprMultiplication(final List<RealExpression> subexpressions) {
		this(subexpressions, /*sortSubexprs=*/true);
	}

	/**
	 * Create a new multiplication expression containing the given list of sub-expressions, in either given or sorted
	 * order (depending on the value of {@code sortSubexprs}). If {@code sortSubexprs} is {@code true}, the
	 * subexpressions are sorted according to {@link RealExpression#COMPARATOR}.
	 * <p/>
	 * The given list of sub-expressions is shallow-copied internally, so the list reference used can be freely
	 * modified afterwards.
	 *
	 * @param subexpressions
	 * 		list of sub-expressions contained in this multiplication expression; must be non-{@code null}, must not be
	 * 		empty, and must not contain any {@code null} elements
	 * @param sortSubexprs
	 * 		whether to sort (the copy of) {@code subexpressions}
	 * @throws NullPointerException
	 * 		if {@code subexpressions} is {@code null}
	 * @throws IllegalArgumentException
	 * 		if {@code subexpressions} is empty or contains a {@code null} entry
	 */
	public RealExprMultiplication(final List<RealExpression> subexpressions, final boolean sortSubexprs) {
		super(RealExprMultiplication.class, immutableCopy(argCheck(subexpressions), sortSubexprs));
		this.hashCode = HASHCODE_PRIME_OFFSET + super.hashCode;
	}

	@Override
	public boolean equals(final Object o) {
		return this == o || (o instanceof RealExprMultiplication
				&& ((RealExprMultiplication) o).hashCode == this.hashCode);
	}

	@Override
	public int hashCode() {
		return this.hashCode;
	}

	@Override
	public <ExprResultType, StateType> ExprResultType accept(
			final VisitorRealExpression<?, ExprResultType, StateType> visitor, final StateType state) {
		return visitor.visit(this, state);
	}
}
