@file:JvmName("BossBarDSL")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package games.dualis.dsl.adventure

import net.kyori.adventure.bossbar.BossBar
import net.kyori.adventure.text.*
import org.jetbrains.annotations.ApiStatus
import org.jetbrains.annotations.Contract

/**
 * A builder class for Adventure's [BossBar], used for syntactic purposes.
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
// TODO find some way to avoid having this kind of class that will be required during runtime
// TODO add the ability to register events from the KBossBar builder class
@ApiStatus.Internal
class BossBarBuilder(
    var name: ComponentLike = Component.empty(),
    var progress: Float = 0F,
    var color: BossBar.Color = BossBar.Color.RED,
    var overlay: BossBar.Overlay = BossBar.Overlay.PROGRESS,
    var flags: Set<BossBar.Flag> = emptySet(),
) {
    @ApiStatus.Internal
    inline fun build() = BossBar.bossBar(name, progress, color, overlay, flags)
}

/**
 * Creates a new [BossBar] from scratch.
 *
 * @param name the new boss bar's name.
 * @param block a block to apply to the newly created boss bar.
 *
 * @return the newly created [BossBar].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("newBossBarFromComponentLike")
@Contract("_ -> new", pure = true)
inline fun bossBar(
    name: ComponentLike = Component.empty(),
    crossinline block: BossBarBuilder.() -> Unit,
): BossBar = BossBarBuilder(name).apply(block).build()

/**
 * Creates a new [BossBar] from this existing [Component] that will be used as
 * the [BossBar]'s name.
 *
 * @param block a block to apply to the newly created boss bar.
 *
 * @return the newly created [BossBar].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("\$newBossBarFromComponentLike")
@Contract("_ -> new", pure = true)
inline fun ComponentLike.bossBar(
    crossinline block: BossBarBuilder.() -> Unit,
): BossBar = bossBar(this, block)

/**
 * Creates a new [BossBar] from this existing [String] that will be used as the
 * [BossBar]'s name after being converted to a [Component].
 *
 * @param block a block to apply to the newly created [BossBar].
 *
 * @return the newly created [BossBar].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("newBossBarFromString")
@Contract("_ -> new", pure = true)
inline fun String.bossBar(
    crossinline block: BossBarBuilder.() -> Unit,
): BossBar = this.component().bossBar(block)

/**
 * Adds a `bossBarNameChanged` [BossBar.Listener] to this existing [BossBar].
 *
 * @param block the block to execute when the event is fired.
 *
 * @return this [BossBar].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("addNameChangedListenerToBossBar")
@Contract("_ -> this")
inline fun BossBar.nameChanged(
    crossinline block: BossBar.(
        oldName: Component,
        newName: Component,
    ) -> Unit,
): BossBar = this.addListener(object : BossBar.Listener {
    override fun bossBarNameChanged(
        _bar: BossBar,
        oldName: Component,
        newName: Component,
    ) = block(oldName, newName)
})

/**
 * Adds a `progressChanged` [BossBar.Listener] to this existing [BossBar].
 *
 * @param block the block to execute when the event is fired.
 *
 * @return this [BossBar].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("addProgressChangedListenerToBossBar")
@Contract("_ -> this")
inline fun BossBar.progressChanged(
    crossinline block: BossBar.(
        oldProgression: Float,
        newProgression: Float,
    ) -> Unit,
): BossBar = this.addListener(object : BossBar.Listener {
    override fun bossBarProgressChanged(
        _bar: BossBar,
        oldProgress: Float,
        newProgress: Float,
    ) = block(oldProgress, newProgress)
})

/**
 * Adds a `bossBarColorChanged` [BossBar.Listener] to this existing [BossBar].
 *
 * @param block the block to execute when the event is fired.
 *
 * @return this [BossBar].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("addColorChangedListenerToBossBar")
@Contract("_ -> this")
inline fun BossBar.colorChanged(
    crossinline block: BossBar.(
        oldColor: BossBar.Color,
        newColor: BossBar.Color,
    ) -> Unit,
): BossBar = this.addListener(object : BossBar.Listener {
    override fun bossBarColorChanged(
        _bar: BossBar,
        oldColor: BossBar.Color,
        newColor: BossBar.Color,
    ) = block(oldColor, newColor)
})

/**
 * Adds a `bossBarOverlayChanged` [BossBar.Listener] to this existing [BossBar].
 *
 * @param block the block to execute when the event is fired.
 *
 * @return this [BossBar].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("addOverlayChangedListenerToBossBar")
@Contract("_ -> this")
inline fun BossBar.overlayChanged(
    crossinline block: BossBar.(
        oldOverlay: BossBar.Overlay,
        newOverlay: BossBar.Overlay,
    ) -> Unit,
): BossBar = this.addListener(object : BossBar.Listener {
    override fun bossBarOverlayChanged(
        _bar: BossBar,
        oldOverlay: BossBar.Overlay,
        newOverlay: BossBar.Overlay,
    ) = block(oldOverlay, newOverlay)
})

/**
 * Adds a `bossBarFlagsChanged` [BossBar.Listener] to this existing [BossBar].
 *
 * @param block the block to execute when the event is fired.
 *
 * @return this [BossBar].
 *
 * @author Shyrogan
 * @author lambdagg
 * @since 0.0.1
 */
@JvmName("addFlagsChangedListenerToBossBar")
@Contract("_ -> this")
inline fun BossBar.flagsChanged(
    crossinline block: BossBar.(
        oldFlag: Set<BossBar.Flag>,
        newFlag: Set<BossBar.Flag>,
    ) -> Unit,
): BossBar = this.addListener(object : BossBar.Listener {
    override fun bossBarFlagsChanged(
        bar: BossBar,
        oldFlag: Set<BossBar.Flag>,
        newFlag: Set<BossBar.Flag>,
    ) = block(oldFlag, newFlag)
})
