package com.hku.course;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Course> {

    private Context context;
    private int resource;

    public ListViewAdapter(Context context, int resource, List<Course> courses) {
        super(context, resource, courses);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.courseNameTextView = convertView.findViewById(R.id.courseNameTextView);
            viewHolder.teacherNameTextView = convertView.findViewById(R.id.teacherTextView);
            viewHolder.ratingBar = convertView.findViewById(R.id.ratingBar);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Course course = getItem(position);

        viewHolder.courseNameTextView.setText(course.getCourseName());
        viewHolder.teacherNameTextView.setText(course.getTeacherName());
        viewHolder.ratingBar.setRating(Float.parseFloat(course.getRating()));

        return convertView;
    }

    private static class ViewHolder {
        TextView courseNameTextView;
        TextView teacherNameTextView;
        RatingBar ratingBar;
    }
}

/*
public class ListViewAdapter extends BaseAdapter {

    private List<String> listViewData;

    private Context mContext;

    public ListViewAdapter(List<String> listViewData, Context mContext) {
        this.listViewData = listViewData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return listViewData.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item = View.inflate(mContext, R.layout.course_item, null);

        return item;
    }
}

 */

