package nl.qbus.sizemeup;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SizeFragment extends Fragment {
    private TextView mLabelArrowWidth;
    private TextView mLabelArrowHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.size_view, container, false);

        TextView screenDimensionPixels = (TextView) view.findViewById(R.id.screenDimensionsPixels);
        TextView screenDimensionDips = (TextView) view.findViewById(R.id.screenDimensionsDips);
        TextView model = (TextView) view.findViewById(R.id.model);
        mLabelArrowWidth = (TextView) view.findViewById(R.id.horizontal_label);
        mLabelArrowHeight = (TextView) view.findViewById(R.id.vertical_label);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        screenDimensionPixels.setText(getString(R.string.screen_dimensions_pixels, metrics.widthPixels, metrics.heightPixels));
        screenDimensionDips.setText(getString(R.string.screen_dimensions_dips, metrics.widthPixels/metrics.density, metrics.heightPixels/metrics.density));
        model.setText(Build.MODEL);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.post(new Runnable() {
            @Override
            public void run() {
                showViewDimensions();
            }
        });
    }

    protected void showViewDimensions() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = getView().getWidth();
        int height = getView().getHeight();
        float widthDp = width/metrics.density;
        float heightDp = height/metrics.density;

        mLabelArrowWidth.setText(getString(R.string.view_width, widthDp, width));
        mLabelArrowHeight.setText(getString(R.string.view_height, heightDp, height));
    }


}
