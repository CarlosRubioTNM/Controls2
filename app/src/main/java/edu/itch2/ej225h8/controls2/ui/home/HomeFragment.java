package edu.itch2.ej225h8.controls2.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.itch2.ej225h8.controls2.R;
import edu.itch2.ej225h8.controls2.Student;
import edu.itch2.ej225h8.controls2.StudentAdapter;
import edu.itch2.ej225h8.controls2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<Student> arrayListStudents;
    private RecyclerView lstStudents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListStudents = new ArrayList<>();
        arrayListStudents.add(new Student("Chris Pérez", "94550563",R.drawable.chris));
        arrayListStudents.add(new Student("Barack Ornelas", "91550111",R.drawable.barack));
        arrayListStudents.add(new Student("Kanye López", "03550501",R.drawable.kanye));
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lstStudents = view.findViewById(R.id.lstStudents);

        StudentAdapter adapter = new StudentAdapter(arrayListStudents);
        lstStudents.setAdapter(adapter);
        lstStudents.setLayoutManager(new LinearLayoutManager(getContext()));
        //lstStudents.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}