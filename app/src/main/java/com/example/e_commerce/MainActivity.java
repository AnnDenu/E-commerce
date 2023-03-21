package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.adapter.CourseAdapter;
import com.example.e_commerce.model.Category;
import com.example.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1, "java_2", "Профессия Java\nразработчик", "1 января","начальный", "#424345","Программа обучения Джава – рассчитана \n" +
                "на новичков в данной сфере.\n" +
                "\n" +
                "За программу вы изучите построение\n" +
                "графических приложений под ПК,\n" +
                "разработку веб сайтов на основе Java \n" +
                "Spring Boot, изучите построение \n" +
                "полноценных Андроид приложений\n" +
                "и отлично изучите сам язык Джава!", 3));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "10 января","начальный","#9FA52D","Test", 3));
        courseList.add(new Course(3, "unity", "Профессия Unity\nразработчик", "5 января","начальный", "#FF5253","Test", 1));
        courseList.add(new Course(4, "front_end", "Профессия Front_end\nразработчик", "10 января","начальный","#215545","Test", 2));
        courseList.add(new Course(5, "back_end", "Профессия Back_end\nразработчик", "8 января","начальный", "#36506B","Test", 2));
        courseList.add(new Course(6, "full_stack", "Профессия Full_stack\nразработчик", "7 января","начальный","#1A5049","Test", 2));

        fullCourseList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    public void openShoppingCart(View view){
        Intent intent= new Intent(this, OrderPage.class);
            startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycle);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter= new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);


    }

    public static void showCoursesByCategory(int category){

        courseList.clear();
        courseList.addAll(fullCourseList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c : courseList){
            if(c.getCategory() == category)
                filterCourses.add(c);
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();

    }

}