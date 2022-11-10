package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.mediarouter.media.MediaRouteSelector;

public class MediaRouteControllerDialogFragment extends DialogFragment {
    private static final String ARGUMENT_SELECTOR = "selector";
    private Dialog mDialog;
    private MediaRouteSelector mSelector;
    private boolean mUseDynamicGroup = false;

    public MediaRouteControllerDialogFragment() {
        setCancelable(true);
    }

    public MediaRouteSelector getRouteSelector() {
        ensureRouteSelector();
        return this.mSelector;
    }

    private void ensureRouteSelector() {
        if (this.mSelector == null) {
            Bundle args = getArguments();
            if (args != null) {
                this.mSelector = MediaRouteSelector.fromBundle(args.getBundle(ARGUMENT_SELECTOR));
            }
            if (this.mSelector == null) {
                this.mSelector = MediaRouteSelector.EMPTY;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setUseDynamicGroup(boolean useDynamicGroup) {
        if (this.mDialog == null) {
            this.mUseDynamicGroup = useDynamicGroup;
            return;
        }
        throw new IllegalStateException("This must be called before creating dialog");
    }

    public void setRouteSelector(MediaRouteSelector selector) {
        if (selector != null) {
            ensureRouteSelector();
            if (!this.mSelector.equals(selector)) {
                this.mSelector = selector;
                Bundle args = getArguments();
                if (args == null) {
                    args = new Bundle();
                }
                args.putBundle(ARGUMENT_SELECTOR, selector.asBundle());
                setArguments(args);
                Dialog dialog = this.mDialog;
                if (dialog != null && this.mUseDynamicGroup) {
                    ((MediaRouteDynamicControllerDialog) dialog).setRouteSelector(selector);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("selector must not be null");
    }

    public MediaRouteDynamicControllerDialog onCreateDynamicControllerDialog(Context context) {
        return new MediaRouteDynamicControllerDialog(context);
    }

    public MediaRouteControllerDialog onCreateControllerDialog(Context context, Bundle savedInstanceState) {
        return new MediaRouteControllerDialog(context);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (this.mUseDynamicGroup) {
            MediaRouteDynamicControllerDialog onCreateDynamicControllerDialog = onCreateDynamicControllerDialog(getContext());
            this.mDialog = onCreateDynamicControllerDialog;
            onCreateDynamicControllerDialog.setRouteSelector(this.mSelector);
        } else {
            this.mDialog = onCreateControllerDialog(getContext(), savedInstanceState);
        }
        return this.mDialog;
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null && !this.mUseDynamicGroup) {
            ((MediaRouteControllerDialog) dialog).clearGroupListAnimation(false);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Dialog dialog = this.mDialog;
        if (dialog == null) {
            return;
        }
        if (this.mUseDynamicGroup) {
            ((MediaRouteDynamicControllerDialog) dialog).updateLayout();
        } else {
            ((MediaRouteControllerDialog) dialog).updateLayout();
        }
    }
}
