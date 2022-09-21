@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package games.dualis.dsl.adventure

import net.kyori.adventure.text.format.*
import net.kyori.adventure.util.*
import org.jetbrains.annotations.Contract

// Color extensions

/**
 * Applies the given [color] to this [Style.Builder].
 *
 * @param color the color to apply.
 *
 * @return this builder.
 *
 * @author Shyrogan
 * @since 0.0.1
 */
@Contract("_ -> this")
inline fun Style.Builder.color(color: Int): Style.Builder =
    this.color(TextColor.color(color))

/**
 * Applies the given [color] to this [Style.Builder].
 *
 * @param color the color to apply.
 *
 * @return this builder.
 *
 * @author Shyrogan
 * @since 0.0.1
 */
@Contract("_ -> this")
inline fun Style.Builder.color(color: RGBLike): Style.Builder =
    this.color(TextColor.color(color))

/**
 * Applies the given [color] to this [Style.Builder].
 *
 * @param color the color to apply.
 *
 * @return this builder.
 *
 * @author Shyrogan
 * @since 0.0.1
 */
@Contract("_ -> this")
inline fun Style.Builder.color(color: HSVLike): Style.Builder =
    this.color(TextColor.color(color))

/**
 * Applies the given ([r], [g], [b]) color to this [Style.Builder].
 *
 * @param r the red value of the color to apply (in [0;255]).
 * @param g the green value of the color to apply (in [0;255]).
 * @param b the blue value of the color to apply (in [0;255]).
 *
 * @return this builder.
 *
 * @author Shyrogan
 * @since 0.0.1
 */
@Contract("_ -> this")
inline fun Style.Builder.color(r: Int, g: Int, b: Int): Style.Builder =
    this.color(TextColor.color(r, g, b))

/**
 * Applies the given ([r], [g], [b]) color to this [Style.Builder].
 *
 * @param r the red value of the color to apply (in [0;1]).
 * @param g the green value of the color to apply (in [0;1]).
 * @param b the blue value of the color to apply (in [0;1]).
 *
 * @return this builder.
 *
 * @author Shyrogan
 * @since 0.0.1
 */
@Contract("_ -> this")
inline fun Style.Builder.color(r: Float, g: Float, b: Float): Style.Builder =
    this.color(TextColor.color(r, g, b))
