package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.firebase:firebase-auth@@19.3.2 */
public final class zzdf implements Parcelable.Creator<zzdg> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdg[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzfr zzfr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 1) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzfr = (zzfr) SafeParcelReader.createParcelable(parcel, readHeader, zzfr.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzdg(zzfr);
    }
}
