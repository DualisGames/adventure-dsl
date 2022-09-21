/*
 * adventure-dsl, a Kotlin DSL for Kyori's Adventure API.
 * Copyright (C) 2022  Dualis Games
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

@file:JvmName("StyleDSL")
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
