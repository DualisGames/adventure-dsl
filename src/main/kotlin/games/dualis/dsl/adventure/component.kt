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

@file:JvmName("ComponentDSL")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package games.dualis.dsl.adventure

import net.kyori.adventure.text.*
import net.kyori.adventure.text.format.Style
import org.jetbrains.annotations.Contract

/**
 * Creates a new [TextComponent] from the given [TextComponent.Builder] [block].
 *
 * @param block the [TextComponent.Builder] block to apply to the newly created
 *              [TextComponent].
 *
 * @return the newly created [TextComponent].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("newTextComponentFromBuilder")
@Contract("_ -> new", pure = true)
inline fun textComponent(
    crossinline block: TextComponent.Builder.() -> Unit,
): TextComponent = Component.text().apply(block).build()

// String extensions

/**
 * Converts this existing [String] to a new [TextComponent].
 *
 * @return the newly created [TextComponent].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("newTextComponentFromString")
@Contract("_ -> new", pure = true)
inline fun String.component(): TextComponent =
    Component.text(this)

/**
 * Converts this existing [String] to a new [TextComponent], applying the given
 * [style].
 *
 * @param style a [Style] to be applied to the new [TextComponent].
 *
 * @return the newly created [TextComponent].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("newStyledTextComponentFromString")
@Contract("_ -> new", pure = true)
inline fun String.component(style: Style): TextComponent =
    this.component().style(style)

/**
 * Converts this existing [String] to a new [TextComponent], applying the style
 * from the given [Style.Builder] [block].
 *
 * @param block a [Style.Builder] block to apply to the newly created
 *              [TextComponent].
 *
 * @return the newly created [TextComponent].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("newStyledTextComponentFromString")
@Contract("_ -> new", pure = true)
inline fun String.component(
    noinline block: Style.Builder.() -> Unit,
): TextComponent = this.component().style(block)

// Operator overloads (operation extensions)

/**
 * Concatenates this [Component] with another one using Kotlin's `+` operator:
 * ```kotlin
 * val result: Component = text1 + text2 // yay!
 * ```
 *
 * @param other the [ComponentLike] to append to this [Component].
 *
 * @return the newly concatenated [Component].
 *
 * @author Shyrogan
 * @since 0.0.1
 */
@JvmName("concatenateComponents")
inline operator fun <C, T : ScopedComponent<C>> T.plus(
    other: ComponentLike,
): C = this.append(other)

/**
 * Concatenates this [Component] with a [String] using Kotlin's `+` operator:
 * ```kotlin
 * val result: Component = text1 + "hello" // yay!
 * ```
 *
 * @param other the [String] to append to this [Component].
 *
 * @return the newly concatenated [Component].
 *
 * @author Shyrogan
 * @since 0.0.1
 */
@JvmName("concatenateComponentWithString")
inline operator fun <C, T : ScopedComponent<C>> T.plus(other: String): C =
    this.append(other.component())

// Iterable extensions

/**
 * Joins an [Iterable] of [ComponentLike]s into a [TextComponent]:
 * ```kotlin
 * val existingComponent: Component = ...
 * val componentList: List<Component> = ...
 * sendMessage(componentList.join(existingComponent)) // yay!
 * ```
 *
 * @param separator the [ComponentLike] to append between every other.
 *
 * @return the newly created [TextComponent].
 */
@JvmName("joinComponentLikeIterableToTextComponent")
@Contract("_ -> new", pure = true)
inline fun Iterable<ComponentLike>.joinToText(
    separator: ComponentLike,
): TextComponent = textComponent {
    val it = this@joinToText.iterator()
    while (it.hasNext()) {
        this.append(it.next())
        if (it.hasNext()) {
            this.append(separator)
        }
    }
}

/**
 * Joins this [Iterable] of [ComponentLike]s into a [TextComponent], appending
 * the given [separator] between every element:
 *  ```kotlin
 * val componentList: List<Component> = ...
 * val result: Component = componentList.join(" ")
 * sendMessage(result) // yay!
 * ```
 *
 * @param separator the separator.
 *
 * @return the newly created [TextComponent].
 *
 * @author Shyrogan
 * @since 0.0.1
 */
@JvmName("joinComponentLikeIterableToTextComponent")
@Contract("_ -> new", pure = true)
inline fun Iterable<ComponentLike>.joinToText(
    separator: String,
): TextComponent = joinToText(separator.component())

/**
 * Joins this [Iterable] of [ComponentLike]s into a [TextComponent]:
 * ```kotlin
 * val componentList: List<Component> = ...
 * val result: Component = componentList.join(" ")
 * sendMessage(result) // yay!
 * ```
 *
 * @return the newly created [TextComponent].
 *
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("joinComponentLikeIterableToTextComponent")
@Contract("_ -> new", pure = true)
inline fun Iterable<ComponentLike>.joinToText(): TextComponent =
    joinToText(Component.empty())
