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

import java.util.Collections;

/**
 * @author Patrick Lehner
 * @since 2015-10-02
 */
public abstract class RealExpressionUnary extends RealSuperExpression {
	/**
	 * Create a new unary super-expression containing the given sub-expression. It is the caller's
	 * responsibility to ensure that {@code subexpression} is not {@code null}.
	 *
	 * @param subexpression
	 * 		sub-expression contained in this unary super-expression
	 */
	protected RealExpressionUnary(final Class<? extends RealExpression> newClazz, final RealExpression subexpression) {
		super(newClazz, Collections.singletonList(subexpression));
	}
}
