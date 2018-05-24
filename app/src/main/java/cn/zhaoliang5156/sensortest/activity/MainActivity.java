package cn.zhaoliang5156.sensortest.activity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cn.zhaoliang5156.sensortest.R;
import cn.zhaoliang5156.sensortest.base.BaseActivity;

/**
 * 主界面
 * 需求：获取手机中支持的传感器列表
 *
 * @author zhaoliang
 * @version 1.0
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    // 声明控件
    private ListView mainList;

    @Override
    protected void initData() {
        // 获取所有的传感器
        List<Sensor> sensorList = getAllSensor();
        // 在列表中显示
        mainList.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1, sensorList));
    }

    // 声明SensorManager对象
    private SensorManager mSensorManager;

    /**
     * 获取所有的传感器
     */
    private List<Sensor> getAllSensor() {
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        return mSensorManager.getSensorList(Sensor.TYPE_ALL);
    }

    @Override
    protected void initListener() {
        mainList.setOnItemClickListener(this);
    }

    @Override
    protected void initView() {
        mainList = findViewById(R.id.main_sensor_list);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 奇数进加速度传感器页面偶数进光传感器页面
        if (position % 2 == 0) {    // 偶数
            startActivity(new Intent(this, AccActivity.class));
        } else {    // 奇数
            startActivity(new Intent(this, LightActivity.class));
        }
    }
}
