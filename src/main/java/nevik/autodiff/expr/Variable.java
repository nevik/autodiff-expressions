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

package nevik.autodiff.expr;

/**
 * Base interface for all (symbolic) variables. The base contract for {@code Variable}s is that {@link
 * Expression#getVariables()} must return a singleton set containing only the variable itself.
 * <p/>
 * Like expressions, these must be immutable.
 *
 * @author Patrick Lehner
 * @since 2015-10-02
 */
public interface Variable<VarType extends Variable> extends Expression<VarType> {}
