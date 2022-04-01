package edu.itch2.ej225h8.controls2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    ArrayList<Student> list;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgStudent;
        public TextView lblStudentName;
        public TextView lblStudentID;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgStudent = itemView.findViewById(R.id.imgStudent);
            lblStudentName = itemView.findViewById(R.id.lblStudentName);
            lblStudentID = itemView.findViewById(R.id.lblStudentID);
        }
    }

    public StudentAdapter(ArrayList<Student> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View studentView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student currentStudent = list.get(position);

        //Asignar datos de estudiante a interfaz
        ImageView imageView = holder.imgStudent;
        imageView.setImageResource(currentStudent.getImageID());

        TextView nameTextView = holder.lblStudentName;
        nameTextView.setText(currentStudent.getName());

        TextView idTextView = holder.lblStudentID;
        idTextView.setText(currentStudent.getStdID());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return list.size();
    }


}
