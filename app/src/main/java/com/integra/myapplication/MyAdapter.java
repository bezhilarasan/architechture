package com.integra.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    int dw, dh;
    Context context;
    private ArrayList<String> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context ctx, ArrayList<String> myDataset, int deviceWidth, int deviceHeight) {
        mDataset = myDataset;
        context = ctx;
        dw = deviceWidth;
        dh = deviceHeight;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_call, parent, false);

        MyViewHolder vh = new MyViewHolder(v, mDataset.size(), context);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        RelativeLayout callerlayout;
        ViewGroup.LayoutParams layoutparams;


        public MyViewHolder(View v, int size, Context context) {
            super(v);
            textView = v.findViewById(R.id.uname);
            callerlayout = v.findViewById(R.id.callerlayout);
            layoutparams = v.getLayoutParams();
            switch (size) {
                case 1:
                    //Define your height here.
                    layoutparams.width = dw;
                    layoutparams.height = dh;
                    v.setLayoutParams(layoutparams);
                    break;
                case 2:
                    //Define your height here.
                    layoutparams.width = dw;
                    layoutparams.height = dh / 2;
                    v.setLayoutParams(layoutparams);
                    //layoutparams.height;
                    break;
//                case 3:
//                    layoutparams.width = layoutparams.width / 3;
//                    layoutparams.height = layoutparams.height / 4;
//                    v.setLayoutParams(layoutparams);
//                    v.setLayoutParams(layoutparams);
                //   layoutparams.height = 300;
//                    break;
//            default:
//                //Define your height here.
//                layoutparams.height = deviceHeight/4;
//                break;
            }


        }
    }
}
