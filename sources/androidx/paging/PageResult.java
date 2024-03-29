package androidx.paging;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

class PageResult<T> {
    static final int APPEND = 1;
    private static final PageResult EMPTY_RESULT = new PageResult(Collections.emptyList(), 0);
    static final int INIT = 0;
    private static final PageResult INVALID_RESULT = new PageResult(Collections.emptyList(), 0);
    static final int PREPEND = 2;
    static final int TILE = 3;
    public final int leadingNulls;
    public final List<T> page;
    public final int positionOffset;
    public final int trailingNulls;

    @Retention(RetentionPolicy.SOURCE)
    @interface ResultType {
    }

    static <T> PageResult<T> getEmptyResult() {
        return EMPTY_RESULT;
    }

    static <T> PageResult<T> getInvalidResult() {
        return INVALID_RESULT;
    }

    PageResult(List<T> list, int leadingNulls2, int trailingNulls2, int positionOffset2) {
        this.page = list;
        this.leadingNulls = leadingNulls2;
        this.trailingNulls = trailingNulls2;
        this.positionOffset = positionOffset2;
    }

    PageResult(List<T> list, int positionOffset2) {
        this.page = list;
        this.leadingNulls = 0;
        this.trailingNulls = 0;
        this.positionOffset = positionOffset2;
    }

    public String toString() {
        return "Result " + this.leadingNulls + ", " + this.page + ", " + this.trailingNulls + ", offset " + this.positionOffset;
    }

    public boolean isInvalid() {
        return this == INVALID_RESULT;
    }

    static abstract class Receiver<T> {
        public abstract void onPageResult(int i, PageResult<T> pageResult);

        Receiver() {
        }
    }
}
