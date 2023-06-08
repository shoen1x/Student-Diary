package com.mikepenz.materialdrawer.model.interfaces;

import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002J\u0017\u0010\u0007\u001a\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0002\u0010\bJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/mikepenz/materialdrawer/model/interfaces/Badgeable;", "T", "", "badge", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getBadge", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "withBadge", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)Lcom/mikepenz/materialdrawer/model/interfaces/Badgeable;", "badgeRes", "", "(I)Lcom/mikepenz/materialdrawer/model/interfaces/Badgeable;", "", "(Ljava/lang/String;)Lcom/mikepenz/materialdrawer/model/interfaces/Badgeable;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: Badgeable.kt */
public interface Badgeable<T extends Badgeable<T>> {
    StringHolder getBadge();

    T withBadge(int i);

    T withBadge(StringHolder stringHolder);

    T withBadge(String str);
}
