package app.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.R;

public class CheckinTipsFragment extends Fragment {

    public CheckinTipsFragment() {
    }

    public static CheckinTipsFragment newInstance() {
        return new CheckinTipsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_checkin_tips, container, false);
    }

}
