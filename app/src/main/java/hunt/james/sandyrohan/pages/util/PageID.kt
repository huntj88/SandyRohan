package hunt.james.sandyrohan.pages.util

import hunt.james.sandyrohan.pages.ItemPage
import hunt.james.sandyrohan.pages.OtherPage
import hunt.james.sandyrohan.pages.TestPage

/**
 * Created by James on 7/8/2017.
 */
enum class PageID(val pageID: Int) : PageBuilder {
    TEST(0) {
        override fun build(): PageRequired {
            return TestPage()
        }
    },
    OTHER(1) {
        override fun build(): PageRequired {
            return OtherPage()
        }
    },
    ITEM(2) {
        override fun build(): PageRequired {
            return ItemPage()
        }
    }
}