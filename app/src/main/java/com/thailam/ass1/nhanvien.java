package com.thailam.ass1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class nhanvien extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhan_vien);


        Toolbar toolbar_nv= findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar_nv);
        getSupportActionBar().setTitle("Nhân viên");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView lv_nhanvien = findViewById(R.id.lv_nhanvien);



        ArrayList<NhanvienModel> arr_nv=new ArrayList<>();
        arr_nv.add(new NhanvienModel("PH001", "Nguyễn Văn A", "Hành Chính"));
        arr_nv.add(new NhanvienModel("PH002", "Nguyễn Văn B", "Nhân Sự"));
        arr_nv.add(new NhanvienModel("PH003", "Nguyễn Văn C", "Hàn Chính"));
        arr_nv.add(new NhanvienModel("PH004", "Nguyễn Văn D", "Đào Tạo"));

        NhanvienAdapter nhanvienAdapter=new NhanvienAdapter(this, arr_nv);
        lv_nhanvien.setAdapter(nhanvienAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.toolbarnv, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        } else if (item.getItemId()==R.id.timkiemnv) {
            Toast.makeText(this, "Tim kiem", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    static class NhanvienModel{
        private String manv;
        private String tennv;
        private String pb;

        public NhanvienModel(String manv, String tennv, String pb) {
            this.manv = manv;
            this.tennv = tennv;
            this.pb = pb;
        }

        public String getManv() {
            return manv;
        }

        public void setManv(String manv) {
            this.manv = manv;
        }

        public String getTennv() {
            return tennv;
        }

        public void setTennv(String tennv) {
            this.tennv = tennv;
        }

        public String getPb() {
            return pb;
        }

        public void setPb(String pb) {
            this.pb = pb;
        }
    }
   public class NhanvienAdapter extends BaseAdapter {

        private Activity activity;
        private ArrayList<NhanvienModel> list;

        public NhanvienAdapter(Activity activity, ArrayList<NhanvienModel> list) {
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

            convertView=inflater.inflate(R.layout.item_nhanvien, parent, false);

            TextView tv_manv=convertView.findViewById(R.id.tv_manv);
            TextView tv_tennv=convertView.findViewById(R.id.tv_tennv);
            TextView tv_pb=convertView.findViewById(R.id.tv_pb);

            tv_manv.setText(list.get(position).getManv());
            tv_tennv.setText(list.get(position).getTennv());
            tv_pb.setText(list.get(position).getPb());

            ImageButton btn_delete= convertView.findViewById(R.id.btn_delete);
            btn_delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new AlertDialog.Builder(activity)
                                    .setMessage("Bạn có muốn xóa không ?")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            list.remove(position);
                                            notifyDataSetChanged();
                                        }
                                    })
                                    .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    }).show();
                        }
                    });


            ImageButton btn_edit = convertView.findViewById(R.id.btn_edit);
            btn_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sManv= tv_manv.getText().toString();
                    String sTennv=tv_tennv.getText().toString();
                    String sPb=tv_pb.getText().toString();


                    Intent intent=new Intent(getApplicationContext(), UpdateOrEdit.class);
                    startActivity(intent);
                    Bundle bundle=new Bundle();
                    bundle.putString("Manv", sManv);
                    bundle.putString("Tennv", sTennv);
                    bundle.putString("Pb", sPb);
                    intent.putExtras(bundle);

                }
            });


            return convertView;
        }


    }
}
