@file:JvmName("AudienceDSL")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package games.dualis.dsl.adventure

import net.kyori.adventure.audience.*
import org.jetbrains.annotations.Contract

/**
 * Creates an [Audience] that forwards to many other instances.
 *
 * The underlying [Iterable] is not copied, therefore any changes made WILL be
 * reflected in [Audience].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("forwardAudienceIterable")
@Contract(pure = true)
inline fun Iterable<Audience>.forward(): ForwardingAudience =
    Audience.audience(this)

/**
 * Creates an [Audience] that forwards to many other instances.
 *
 * As opposed to the `Iterable<Audience>.forward` extension, this one applies
 * to an array that is then wrapped as an [Iterable], therefore the array
 * is copied, and any changes made will NOT be reflected in [Audience].
 *
 * To use with precaution.
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@Contract(pure = true)
@JvmName("forwardAudienceArray")
inline fun Array<Audience>.forward(): ForwardingAudience =
    this.asIterable().forward()
