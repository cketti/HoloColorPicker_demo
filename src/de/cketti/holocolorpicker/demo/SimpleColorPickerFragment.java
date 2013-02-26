package de.cketti.holocolorpicker.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.larswerkman.colorpicker.ColorPicker;


/**
 * Fragment that demonstrates how to use {@link ColorPicker} in the most simple way.
 */
public class SimpleColorPickerFragment extends Fragment {

    private ColorPicker mColorPicker;
    private Button mButton;
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.simple_color_picker_fragment, null);

        mColorPicker = (ColorPicker) view.findViewById(R.id.color_picker);
        mButton = (Button) view.findViewById(R.id.change_color_button);
        mTextView = (TextView) view.findViewById(R.id.text_view);

        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setTextColor(mColorPicker.getColor());
                mColorPicker.setOldCenterColor(mColorPicker.getColor());
            }
        });

        return view;
    }
}
