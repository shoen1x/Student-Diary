package jp.co.cyberagent.android.gpuimage;

public enum Rotation {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270;

    /* renamed from: jp.co.cyberagent.android.gpuimage.Rotation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$co$cyberagent$android$gpuimage$Rotation = null;

        static {
            int[] iArr = new int[Rotation.values().length];
            $SwitchMap$jp$co$cyberagent$android$gpuimage$Rotation = iArr;
            try {
                iArr[Rotation.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$jp$co$cyberagent$android$gpuimage$Rotation[Rotation.ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$jp$co$cyberagent$android$gpuimage$Rotation[Rotation.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$jp$co$cyberagent$android$gpuimage$Rotation[Rotation.ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public int asInt() {
        int i = AnonymousClass1.$SwitchMap$jp$co$cyberagent$android$gpuimage$Rotation[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 90;
        }
        if (i == 3) {
            return 180;
        }
        if (i == 4) {
            return 270;
        }
        throw new IllegalStateException("Unknown Rotation!");
    }

    public static Rotation fromInt(int rotation) {
        if (rotation == 0) {
            return NORMAL;
        }
        if (rotation == 90) {
            return ROTATION_90;
        }
        if (rotation == 180) {
            return ROTATION_180;
        }
        if (rotation == 270) {
            return ROTATION_270;
        }
        if (rotation == 360) {
            return NORMAL;
        }
        throw new IllegalStateException(rotation + " is an unknown rotation. Needs to be either 0, 90, 180 or 270!");
    }
}
