package com.amatda.tasks;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.amatda.R;
import com.amatda.data.MockPreparationData;

public class PreparationViewHolder extends RecyclerView.ViewHolder {

    private TextView textPreparation;

    public PreparationViewHolder(View itemView) {
        super(itemView);

        textPreparation = itemView.findViewById(R.id.textPreparation);
    }

    public void setData(MockPreparationData data) {
        textPreparation.setText(data.getName());
    }
}
