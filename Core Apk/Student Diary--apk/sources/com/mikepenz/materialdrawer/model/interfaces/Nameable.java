package com.mikepenz.materialdrawer.model.interfaces;

import com.mikepenz.materialdrawer.holder.StringHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0007\u001a\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0002\u0010\bJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/mikepenz/materialdrawer/model/interfaces/Nameable;", "T", "", "name", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getName", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "withName", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)Ljava/lang/Object;", "nameRes", "", "(I)Ljava/lang/Object;", "", "(Ljava/lang/String;)Ljava/lang/Object;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: Nameable.kt */
public interface Nameable<T> {
    StringHolder getName();

    T withName(int i);

    T withName(StringHolder stringHolder);

    T withName(String str);
}
