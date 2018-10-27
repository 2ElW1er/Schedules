package app.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.R;

public class CheckInTipsFragment extends Fragment {

    public CheckInTipsFragment() {
    }

    public static CheckInTipsFragment newInstance() {
        return new CheckInTipsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_checkin_tips, container, false);
    }

}
