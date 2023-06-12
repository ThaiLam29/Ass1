package com.thailam.ass1;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class phongban extends AppCompatActivity {

    private class PhongbanModel{
        private String nhansu;

        public PhongbanModel(String nhansu) {
            this.nhansu = nhansu;
        }

        public String getNhansu() {
            return nhansu;
        }

        public void setNhansu(String nhansu) {
            this.nhansu = nhansu;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phong_ban);

        Toolbar toolbar_pb=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar_pb);
        getSupportActionBar().setTitle("Phòng ban ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView lvPhongban = findViewById(R.id.lvPhongban);

        ArrayList<PhongbanModel> listpb = new ArrayList<>();
        listpb.add(new PhongbanModel("Nhân sự "));
        listpb.add(new PhongbanModel("Hành Chính "));
        listpb.add(new PhongbanModel("Đào Tạo"));

        PhongbanAdapter adapter= new PhongbanAdapter( this, listpb);
        lvPhongban.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.toolbarpb, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        } else if (item.getItemId()==R.id.timkiem_pb) {
            Toast.makeText(this, "Tìm Kiếm", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    private class PhongbanAdapter extends BaseAdapter {

        private Activity activity;
        private ArrayList<PhongbanModel> list;

        public PhongbanAdapter(Activity activity, ArrayList<PhongbanModel> list) {
            this.activity = activity;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater=activity.getLayoutInflater();
            convertView=inflater.inflate(R.layout.item_phongban, parent, false);

            TextView tv_nhansu=convertView.findViewById(R.id.TxtPhongban);

            tv_nhansu.setText(list.get(position).getNhansu());

            return convertView;
        }

}
}

