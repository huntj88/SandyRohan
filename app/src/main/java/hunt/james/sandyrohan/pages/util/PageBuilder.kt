package hunt.james.sandyrohan.pages.util

import hunt.james.sandyrohan.toolbar.ToolbarRequired

/**
 * Created by James on 7/8/2017.
 */
interface PageBuilder {
    fun build(): PageRequired
    fun buildToolbar(): ToolbarRequired
}