package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AudioFocusRequestCompat {
    static final AudioAttributesCompat FOCUS_DEFAULT_ATTR = new AudioAttributesCompat.Builder().setUsage(1).build();
    private final AudioAttributesCompat mAudioAttributesCompat;
    private final Handler mFocusChangeHandler;
    private final int mFocusGain;
    private final Object mFrameworkAudioFocusRequest;
    private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private final boolean mPauseOnDuck;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusGainType {
    }

    AudioFocusRequestCompat(int focusGain, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler focusChangeHandler, AudioAttributesCompat audioFocusRequestCompat, boolean pauseOnDuck) {
        this.mFocusGain = focusGain;
        this.mFocusChangeHandler = focusChangeHandler;
        this.mAudioAttributesCompat = audioFocusRequestCompat;
        this.mPauseOnDuck = pauseOnDuck;
        if (Build.VERSION.SDK_INT >= 26 || this.mFocusChangeHandler.getLooper() == Looper.getMainLooper()) {
            this.mOnAudioFocusChangeListener = onAudioFocusChangeListener;
        } else {
            this.mOnAudioFocusChangeListener = new OnAudioFocusChangeListenerHandlerCompat(onAudioFocusChangeListener, focusChangeHandler);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mFrameworkAudioFocusRequest = new AudioFocusRequest.Builder(this.mFocusGain).setAudioAttributes(getAudioAttributes()).setWillPauseWhenDucked(this.mPauseOnDuck).setOnAudioFocusChangeListener(this.mOnAudioFocusChangeListener, this.mFocusChangeHandler).build();
        } else {
            this.mFrameworkAudioFocusRequest = null;
        }
    }

    public int getFocusGain() {
        return this.mFocusGain;
    }

    public AudioAttributesCompat getAudioAttributesCompat() {
        return this.mAudioAttributesCompat;
    }

    public boolean willPauseWhenDucked() {
        return this.mPauseOnDuck;
    }

    public AudioManager.OnAudioFocusChangeListener getOnAudioFocusChangeListener() {
        return this.mOnAudioFocusChangeListener;
    }

    public Handler getFocusChangeHandler() {
        return this.mFocusChangeHandler;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AudioFocusRequestCompat that = (AudioFocusRequestCompat) o;
        if (this.mFocusGain != that.mFocusGain || this.mPauseOnDuck != that.mPauseOnDuck || !ObjectsCompat.equals(this.mOnAudioFocusChangeListener, that.mOnAudioFocusChangeListener) || !ObjectsCompat.equals(this.mFocusChangeHandler, that.mFocusChangeHandler) || !ObjectsCompat.equals(this.mAudioAttributesCompat, that.mAudioAttributesCompat)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mFocusGain), this.mOnAudioFocusChangeListener, this.mFocusChangeHandler, this.mAudioAttributesCompat, Boolean.valueOf(this.mPauseOnDuck));
    }

    /* access modifiers changed from: package-private */
    public AudioAttributes getAudioAttributes() {
        AudioAttributesCompat audioAttributesCompat = this.mAudioAttributesCompat;
        if (audioAttributesCompat != null) {
            return (AudioAttributes) audioAttributesCompat.unwrap();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public AudioFocusRequest getAudioFocusRequest() {
        return (AudioFocusRequest) this.mFrameworkAudioFocusRequest;
    }

    public static final class Builder {
        private boolean mAcceptsDelayedFocusGain;
        private AudioAttributesCompat mAudioAttributesCompat = AudioFocusRequestCompat.FOCUS_DEFAULT_ATTR;
        private Handler mFocusChangeHandler;
        private int mFocusGain;
        private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
        private boolean mPauseOnDuck;

        public Builder(int focusGain) {
            setFocusGain(focusGain);
        }

        public Builder(AudioFocusRequestCompat requestToCopy) {
            if (requestToCopy != null) {
                this.mFocusGain = requestToCopy.getFocusGain();
                this.mOnAudioFocusChangeListener = requestToCopy.getOnAudioFocusChangeListener();
                this.mFocusChangeHandler = requestToCopy.getFocusChangeHandler();
                this.mAudioAttributesCompat = requestToCopy.getAudioAttributesCompat();
                this.mPauseOnDuck = requestToCopy.willPauseWhenDucked();
                return;
            }
            throw new IllegalArgumentException("AudioFocusRequestCompat to copy must not be null");
        }

        public Builder setFocusGain(int focusGain) {
            if (isValidFocusGain(focusGain)) {
                if (Build.VERSION.SDK_INT < 19 && focusGain == 4) {
                    focusGain = 2;
                }
                this.mFocusGain = focusGain;
                return this;
            }
            throw new IllegalArgumentException("Illegal audio focus gain type " + focusGain);
        }

        public Builder setOnAudioFocusChangeListener(AudioManager.OnAudioFocusChangeListener listener) {
            return setOnAudioFocusChangeListener(listener, new Handler(Looper.getMainLooper()));
        }

        public Builder setOnAudioFocusChangeListener(AudioManager.OnAudioFocusChangeListener listener, Handler handler) {
            if (listener == null) {
                throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
            } else if (handler != null) {
                this.mOnAudioFocusChangeListener = listener;
                this.mFocusChangeHandler = handler;
                return this;
            } else {
                throw new IllegalArgumentException("Handler must not be null");
            }
        }

        public Builder setAudioAttributes(AudioAttributesCompat attributes) {
            if (attributes != null) {
                this.mAudioAttributesCompat = attributes;
                return this;
            }
            throw new NullPointerException("Illegal null AudioAttributes");
        }

        public Builder setWillPauseWhenDucked(boolean pauseOnDuck) {
            this.mPauseOnDuck = pauseOnDuck;
            return this;
        }

        public AudioFocusRequestCompat build() {
            if (this.mOnAudioFocusChangeListener != null) {
                return new AudioFocusRequestCompat(this.mFocusGain, this.mOnAudioFocusChangeListener, this.mFocusChangeHandler, this.mAudioAttributesCompat, this.mPauseOnDuck);
            }
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }

        static boolean isValidFocusGain(int focusGain) {
            if (focusGain == 1 || focusGain == 2 || focusGain == 3 || focusGain == 4) {
                return true;
            }
            return false;
        }
    }

    private static class OnAudioFocusChangeListenerHandlerCompat implements Handler.Callback, AudioManager.OnAudioFocusChangeListener {
        private static final int FOCUS_CHANGE = 2782386;
        private final Handler mHandler;
        private final AudioManager.OnAudioFocusChangeListener mListener;

        OnAudioFocusChangeListenerHandlerCompat(AudioManager.OnAudioFocusChangeListener listener, Handler handler) {
            this.mListener = listener;
            this.mHandler = new Handler(handler.getLooper(), this);
        }

        public void onAudioFocusChange(int focusChange) {
            Handler handler = this.mHandler;
            handler.sendMessage(Message.obtain(handler, FOCUS_CHANGE, focusChange, 0));
        }

        public boolean handleMessage(Message message) {
            if (message.what != FOCUS_CHANGE) {
                return false;
            }
            this.mListener.onAudioFocusChange(message.arg1);
            return true;
        }
    }
}
