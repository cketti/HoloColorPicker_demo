package de.cketti.holocolorpicker.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.larswerkman.colorpicker.ColorPicker;
import com.larswerkman.colorpicker.OpacityBar;
import com.larswerkman.colorpicker.SVBar;


/**
 * Fragment that displays a customized {@link ColorPicker}.
 *
 * <p>All the magic happens in the layout file.</p>
 */
public class CustomizedColorPickerFragment extends Fragment {

    private ColorPicker mColorPicker;
    private SVBar mSvBar;
    private OpacityBar mOpacityBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.customized_color_picker_fragment, null);

        mColorPicker = (ColorPicker) view.findViewById(R.id.color_picker);
        mSvBar = (SVBar) view.findViewById(R.id.svbar);
        mOpacityBar = (OpacityBar) view.findViewById(R.id.opacitybar);

        mColorPicker.addSVBar(mSvBar);
        mColorPicker.addOpacityBar(mOpacityBar);

        return view;
    }
}
