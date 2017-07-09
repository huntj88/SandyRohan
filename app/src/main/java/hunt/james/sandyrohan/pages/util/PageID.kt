package hunt.james.sandyrohan.pages.util

import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.pages.ItemPage
import hunt.james.sandyrohan.pages.OtherPage
import hunt.james.sandyrohan.pages.TestPage
import hunt.james.sandyrohan.toolbar.MenuToolbar
import hunt.james.sandyrohan.toolbar.SearchToolbar
import hunt.james.sandyrohan.toolbar.TitleToolbar
import hunt.james.sandyrohan.toolbar.ToolbarRequired

/**
 * Created by James on 7/8/2017.
 */
enum class PageID(val pageID: Int, var hasMenu: Boolean, var menu: Int) : PageBuilder {
    TEST(0, false, 0) {
        override fun build(): PageRequired {
            return TestPage()
        }

        override fun buildToolbar(): ToolbarRequired {
            return MenuToolbar()
        }
    },
    OTHER(1, true, R.menu.menu_scrolling) {
        override fun build(): PageRequired {
            return OtherPage()
        }

        override fun buildToolbar(): ToolbarRequired {
            return TitleToolbar("Other")
        }
    },
    ITEM(2, false, 0) {
        override fun build(): PageRequired {
            return ItemPage()
        }

        override fun buildToolbar(): ToolbarRequired {
            return SearchToolbar()
        }
    }
}