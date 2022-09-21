/*
 * adventure-dsl, A Kotlin DSL for Kyori's Adventure API.
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
