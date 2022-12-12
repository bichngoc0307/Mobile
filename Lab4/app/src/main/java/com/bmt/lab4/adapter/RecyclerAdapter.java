package com.bmt.lab4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bmt.lab4.R;
import com.bmt.lab4.dto.President;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PresidentViewHolder>{
    private List<President> presidents;
    private IClicked clicked;
    public interface IClicked {
        void isClicked(Integer position);
    }

    public void setData(List<President> presidents){
        this.presidents = presidents;
        notifyDataSetChanged();
    }
    public RecyclerAdapter(IClicked clicked) {
        this.clicked = clicked;
    }

    @NonNull
    @NotNull
    @Override
    public PresidentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chicago, parent, false);
        return new PresidentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PresidentViewHolder holder, int position) {
        holder.getRole().setText(presidents.get(position).getRole());
        holder.getPresident().setText(presidents.get(position).getName()+"("+presidents.get(position).getParty()+")");
        holder.wrapper.setOnClickListener(v->clicked.isClicked(position));
    }

    @Override
    public int getItemCount() {
        return presidents.size();
    }


    public class PresidentViewHolder extends RecyclerView.ViewHolder {
        public TextView role;
        public TextView president;

        public ConstraintLayout wrapper;
        public PresidentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            role = itemView.findViewById(R.id.role);
            president = itemView.findViewById(R.id.president);
            wrapper = itemView.findViewById(R.id.wrapper);
        }

        public TextView getRole() {
            return role;
        }

        public void setRole(TextView role) {
            this.role = role;
        }

        public TextView getPresident() {
            return president;
        }

        public void setPresident(TextView president) {
            this.president = president;
        }
    }
}
