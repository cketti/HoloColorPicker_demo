package de.cketti.holocolorpicker.demo;

import com.actionbarsherlock.app.SherlockDialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Show an "About" dialog
 */
public class AboutDialogFragment extends SherlockDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.about_dialog, null);

        TextView about = (TextView) view.findViewById(R.id.about_text);
        about.setText(Html.fromHtml(getString(R.string.about_text)));
        about.setMovementMethod(LinkMovementMethod.getInstance());

        Dialog dialog = getDialog();
        dialog.setTitle(R.string.label_about);

        return view;
    }
}
