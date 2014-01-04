package com.androidlb.dirtywater;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
        tv.setText(getArguments().getString("msg"));
        TextView tvCriteria0 = (TextView) v.findViewById(R.id.tvCriteria0);
        tvCriteria0.setText(getArguments().getString("crit0"));
        TextView tvCriteria1 = (TextView) v.findViewById(R.id.tvCriteria1);
        tvCriteria1.setText(getArguments().getString("crit1"));
        TextView tvCriteria2 = (TextView) v.findViewById(R.id.tvCriteria2);
        tvCriteria2.setText(getArguments().getString("crit2"));
        TextView tvCriteria3 = (TextView) v.findViewById(R.id.tvCriteria3);
        tvCriteria3.setText(getArguments().getString("crit3"));


        return v;
    }

    public static FirstFragment newInstance(Evaluation eval) {

    	Evaluation curr_eval = eval;
        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", curr_eval.name);
        b.putString("crit0", curr_eval.criterias[0]);
        b.putString("crit1", curr_eval.criterias[1]);
        b.putString("crit2", curr_eval.criterias[2]);
        b.putString("crit3", curr_eval.criterias[3]);

        f.setArguments(b);

        return f;
    }
}
