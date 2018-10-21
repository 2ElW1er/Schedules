package app.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.R;

public class TimesFragment extends Fragment {
    private static final String KEY_TIMES = "times";

    private String[] times;

    public TimesFragment() {
    }

    public static TimesFragment newInstance(String[] times) {
        TimesFragment fragment = new TimesFragment();
        Bundle args = new Bundle();
        args.putStringArray(KEY_TIMES, times);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            times = getArguments().getStringArray(KEY_TIMES);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_times, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);
        recyclerView.setAdapter(new TimeAdapter(getContext(), times));
        return view;
    }

    class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder> {
        private final Context context;
        private final String[] mValues;

        TimeAdapter(Context context, String[] items) {
            this.context = context;
            this.mValues = items;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_time, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.mNameView.setText(mValues[position]);
            if (holder.getAdapterPosition() == 0) {
                holder.itemView.setPadding(0, (int) (8 * context.getResources().getDisplayMetrics().density + 0.5F), 0, 0);
            }
            if (holder.getAdapterPosition() == mValues.length - 1) {
                holder.itemView.setPadding(0, 0, 0, (int) (8 * context.getResources().getDisplayMetrics().density + 0.5F));
            }
        }

        @Override
        public int getItemCount() {
            return mValues.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mNameView;

            ViewHolder(@NonNull View view) {
                super(view);
                mNameView = view.findViewById(R.id.tv_name);
            }
        }
    }
}
