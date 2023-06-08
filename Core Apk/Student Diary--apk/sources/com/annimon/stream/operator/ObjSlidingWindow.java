package com.annimon.stream.operator;

import com.annimon.stream.internal.Compat;
import com.annimon.stream.iterator.LsaIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class ObjSlidingWindow<T> extends LsaIterator<List<T>> {
    private final Iterator<? extends T> iterator;
    private final Queue<T> queue = Compat.queue();
    private final int stepWidth;
    private final int windowSize;

    public ObjSlidingWindow(Iterator<? extends T> iterator2, int windowSize2, int stepWidth2) {
        this.iterator = iterator2;
        this.windowSize = windowSize2;
        this.stepWidth = stepWidth2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public List<T> nextIteration() {
        for (int i = this.queue.size(); i < this.windowSize && this.iterator.hasNext(); i++) {
            this.queue.offer(this.iterator.next());
        }
        List<T> list = new ArrayList<>(this.queue);
        int pollCount = Math.min(this.queue.size(), this.stepWidth);
        for (int j = 0; j < pollCount; j++) {
            this.queue.poll();
        }
        for (int j2 = this.windowSize; j2 < this.stepWidth && this.iterator.hasNext(); j2++) {
            this.iterator.next();
        }
        return list;
    }
}
