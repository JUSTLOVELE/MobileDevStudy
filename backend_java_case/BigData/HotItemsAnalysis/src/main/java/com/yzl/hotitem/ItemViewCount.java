package com.yzl.hotitem;

/**
 * @author yangzl 2021.06.09
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class ItemViewCount {

    private Long itemId;

    private Long windowEnd;

    private Long count;

    public ItemViewCount(){

    }

    public ItemViewCount(Long itemId, Long windowEnd, Long count) {
        this.itemId = itemId;
        this.windowEnd = windowEnd;
        this.count = count;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getWindowEnd() {
        return windowEnd;
    }

    public void setWindowEnd(Long windowEnd) {
        this.windowEnd = windowEnd;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
