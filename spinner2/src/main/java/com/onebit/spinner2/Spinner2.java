package com.onebit.spinner2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/**
 * Created by scijoker on 11.10.15.
 */
public class Spinner2 extends Spinner {
    private int noClickSelectedPosition = NO_POSITION;
    private boolean isLoadedAdapter;
    private boolean withDefAction = true;
    private final static int NO_POSITION = -1;

    private OnItemSelectedSpinner2Listener onItemSelectedSpinner2Listener;

    public Spinner2(Context context) {
        super(context);
        setup();
    }

    public Spinner2(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public Spinner2(Context context, int mode) {
        super(context, mode);
        setup();
    }

    private void setup() {
        Spinner2.this.setOnItemSelectedListener(null);
    }

    public void setSelection(boolean withAction, int position) {
        setSelection(withAction, position, false);
    }

    public void setSelection(boolean withAction, int position, boolean animate) {
        if (!withAction) {
            this.noClickSelectedPosition = position;
        }
        super.setSelection(position, animate);
    }


    @Deprecated
    @Override
    public void setSelection(int position) {
        this.noClickSelectedPosition = NO_POSITION;
        super.setSelection(position);
    }

    @Deprecated
    @Override
    public void setSelection(int position, boolean animate) {
        this.noClickSelectedPosition = NO_POSITION;
        super.setSelection(position, animate);
    }


    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        setAdapter(adapter, true);
    }

    public void setAdapter(SpinnerAdapter adapter, boolean withAction) {
        this.withDefAction = withAction;
        this.isLoadedAdapter = false;
        super.setAdapter(adapter);
        this.isLoadedAdapter = true;
    }

    /**
     * Don't override this callback!
     * For add callback use @method setOnItemSelectedSpinner2Listener();
     */
    @Deprecated
    @Override
    public final void setOnItemSelectedListener(OnItemSelectedListener noUse) {
        OnItemSelectedListener listener = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (getOnItemSelectedSpinner2Listener() != null) {
                    if (!isLoadedAdapter || !withDefAction || (isLoadedAdapter && noClickSelectedPosition == position)) {
                        withDefAction = true;
                        noClickSelectedPosition = NO_POSITION;
                        return;
                    } else {
                        noClickSelectedPosition = NO_POSITION;
                        getOnItemSelectedSpinner2Listener().onItemSelected(parent, view, position, id);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        super.setOnItemSelectedListener(listener);
    }

    public OnItemSelectedSpinner2Listener getOnItemSelectedSpinner2Listener() {
        return onItemSelectedSpinner2Listener;
    }

    public void setOnItemSelectedSpinner2Listener(OnItemSelectedSpinner2Listener onItemSelectedSpinner2Listener) {
        this.onItemSelectedSpinner2Listener = onItemSelectedSpinner2Listener;
    }

    public static interface OnItemSelectedSpinner2Listener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3);
    }
}
