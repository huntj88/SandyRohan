package hunt.james.sandyrohan.view.pages.util

import hunt.james.sandyrohan.view.pages.ItemPage
import hunt.james.sandyrohan.view.pages.SearchPage
import hunt.james.sandyrohan.view.pages.TestPage

/**
 * Created by James on 7/8/2017.
 */
enum class PageID(val pageID: Int) : PageBuilder {
    TEST(0) {
        override fun build(): PageRequired {
            return TestPage()
        }
    },
    SEARCH(1) {
        override fun build(): PageRequired {
            return SearchPage()
        }
    },
    ITEM(2) {
        override fun build(): PageRequired {
            return ItemPage()
        }
    }
}