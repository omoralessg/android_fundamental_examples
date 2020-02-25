package com.example.androidfundamental.traceview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Debug;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidfundamental.R;

import java.util.Collections;
import java.util.List;

public class TraceArrayAdapter extends ArrayAdapter<String> {

    private List<String> values;
    private Context context;

    public TraceArrayAdapter(Context context, List<String> values) {
        super(context, R.layout.rowlayout);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Debug.startMethodTracing("getViewOfTrace");
        // Ensure sorted values
        Collections.sort(values);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.rowlayouttrace, parent, false);
        Resources res = context.getResources();
        String text = String.format(res.getString(R.string.number_template),
                values.get(position));
        CharSequence styledText = Html.fromHtml(text);
        TextView textView = (TextView) view.findViewById(R.id.textView3);
        textView.setText(styledText);
        Debug.stopMethodTracing();
        return view;
    }
}
