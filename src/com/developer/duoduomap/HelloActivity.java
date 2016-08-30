package com.developer.duoduomap;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ZoomControls;

public class HelloActivity extends Activity {

	MapView mMapView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 在使用SDK各组件之前初始化context信息，传入ApplicationContext
		// 注意该方法要再setContentView方法之前实现
		SDKInitializer.initialize(getApplicationContext());
		requestWindowFeature(Window.FEATURE_NO_TITLE);//设置没有标题栏
		setContentView(R.layout.hello_activity);

		// 获取地图控件引用
		mMapView = (MapView) findViewById(R.id.bmapView);
		// 隐藏logo
		View child = mMapView.getChildAt(1);
		if (child != null
				&& (child instanceof ImageView || child instanceof ZoomControls)) {
			child.setVisibility(View.INVISIBLE);
		}

		// 放大缩小图标
		View scaleView = mMapView.getChildAt(2);
		if (scaleView != null
				&& (child instanceof ImageView || child instanceof ZoomControls)) {
			scaleView.setVisibility(View.INVISIBLE);
		}
		// 比例尺图标
		View zoomView = mMapView.getChildAt(3);
		if (zoomView != null
				&& (child instanceof ImageView || child instanceof ZoomControls)) {
			zoomView.setVisibility(View.INVISIBLE);
		}

		// 地图上比例尺
		// mMapView.showScaleControl(false);
		// 隐藏缩放控件
		// mMapView.showZoomControls(false);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
		mMapView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// 在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
		mMapView.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
		mMapView.onDestroy();
	}
}
