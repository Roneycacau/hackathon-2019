package br.com.iteris.iteris;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyHolder> {

    List<Property> properties;
    LayoutInflater inflater;
    Context context;

    public PropertyAdapter(Context context, List<Property> properties) {
        this.context = context;
        this.properties = properties;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public PropertyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.adapter_property, viewGroup, false);
        return new PropertyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyHolder propertyHolder, int i) {
        Property property = properties.get(i);
        Glide.with(context)
                .load(property.getImage())
                .into(propertyHolder.ivProperty);
        propertyHolder.tvAddress.setText(property.getAddress());
        propertyHolder.tvPrice.setText(property.getPrice());
        propertyHolder.tvOwner.setText(property.getOwner());
        propertyHolder.tvBusinessType.setText(property.getBusinessType());
    }

    @Override
    public int getItemCount() {
        return properties.size();
    }

    public static class PropertyHolder extends RecyclerView.ViewHolder {
        ImageView ivProperty;
        TextView tvAddress;
        TextView tvPrice;
        TextView tvOwner;
        TextView tvBusinessType;

        public PropertyHolder(@NonNull View itemView) {
            super(itemView);
            ivProperty = itemView.findViewById(R.id.iv_property);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvOwner = itemView.findViewById(R.id.tv_owner);
            tvBusinessType = itemView.findViewById(R.id.tv_business_type);

        }
    }
}
