package www.oztaking.com.a15_dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //0.获取点击的四个按钮
        Button bt_0 = (Button) findViewById(R.id.bt_0);
        Button bt_1 = (Button) findViewById(R.id.bt_1);
        Button bt_2 = (Button) findViewById(R.id.bt_2);
        Button bt_3 = (Button) findViewById(R.id.bt_3);
        //1.普通对话框
        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_0:
                click_genericDialog();
                break;

            case R.id.bt_1:
                click_singalSelectDialog();
                break;

            case R.id.bt_2:
                MutiSelecDialog();
                break;

            case R.id.bt_3:
                ProgressDialog();
                break;
        }
    }

    //普通对话框
    public void click_genericDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("世界上最遥远的距离就是没有网！！！");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("点击了确定按钮");
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("点击了取消按钮");
            }
        });

        //记得一定要show出来；
        builder.show();
    }

    //单选对话框
    public void click_singalSelectDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please select yout favbrarite fruits");
        final String item[] = {"77", "66", "55", "44", "33", "22", "11"};
        builder.setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String s = item[which];
                Toast.makeText(getApplication(), s, Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        builder.show();
    }

    //多选对话框
    public void MutiSelecDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please MultiSelect your course");
        final String curses[] = {"77", "66", "55", "44", "33", "22", "11"};
        final boolean[] checkedItem = {false, false, false, false, false, false, true};
        builder.setMultiChoiceItems(curses, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < checkedItem.length; i++) {
                    if (checkedItem[i]) {
                        String fruit = curses[i];
                        sb.append(fruit + "");

                    }
                }
                Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.show();
    }

    //进度条对话框
    public void ProgressDialog() {

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("正在玩命加载中...");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.show();
        dialog.setMax(100);
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    SystemClock.sleep(50);
                    dialog.setProgress(i);
                }
                dialog.dismiss();
            }
        }.start();
    }
    
}
