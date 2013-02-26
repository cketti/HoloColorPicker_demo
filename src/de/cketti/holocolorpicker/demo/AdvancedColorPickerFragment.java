package de.cketti.holocolorpicker.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.larswerkman.colorpicker.ColorPicker;
import com.larswerkman.colorpicker.ColorPicker.OnColorChangedListener;
import com.larswerkman.colorpicker.OpacityBar;
import com.larswerkman.colorpicker.SVBar;


/**
 * Fragment that demonstrates how to use {@link ColorPicker} in combination with {@link SVBar} and
 * {@link OpacityBar}.
 */
public class AdvancedColorPickerFragment extends Fragment {

    private ColorPicker mColorPicker;
    private SVBar mSvBar;
    private OpacityBar mOpacityBar;
    private View mColorSquare;
    private Button mButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.advanced_color_picker_fragment, null);

        mColorPicker = (ColorPicker) view.findViewById(R.id.color_picker);
        mSvBar = (SVBar) view.findViewById(R.id.svbar);
        mOpacityBar = (OpacityBar) view.findViewById(R.id.opacitybar);
        mColorSquare = view.findViewById(R.id.color_square);
        mButton = (Button) view.findViewById(R.id.select_color_button);

        mColorPicker.addSVBar(mSvBar);
        mColorPicker.addOpacityBar(mOpacityBar);

        mColorPicker.setOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                mColorSquare.setBackgroundColor(color);
            }
        });

        int color = Color.argb(120, 255, 0, 0);
        mColorPicker.setColor(color);
        mColorPicker.setOldCenterColor(color);

        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorPicker.setOldCenterColor(mColorPicker.getColor());
            }
        });

        return view;
    }
}
