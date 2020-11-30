package com.zhengsr.opengldemo

import android.app.ActivityManager
import android.content.Context
import android.opengl.GLES30
import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.NestedScrollingParent3
import kotlinx.android.synthetic.main.activity_main.*
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class MainActivity : AppCompatActivity() {
    companion object{
        private const val TAG = "MainActivity"
    }
    private lateinit var glSurfaceView:GLSurfaceView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        glSurfaceView = MyGlSurfaceView(this)
        //检察是否支持openGL3
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE)as ActivityManager
        val config = activityManager.deviceConfigurationInfo
        val isSupportEs3 = config.reqGlEsVersion >= 0x30000

        Log.d(TAG, "zsr onCreate: $isSupportEs3")

        setContentView(glSurfaceView)
    }

    override fun onPause() {
        super.onPause()
        glSurfaceView.onPause()
    }

    override fun onResume() {
        super.onResume()
        glSurfaceView.onResume()
    }

    class MyGlSurfaceView(context: Context) : GLSurfaceView(context) {
        init {
            //设置支持es3.0
            setEGLContextClientVersion(3)
            //设置纹理
            val renderer = MyGlRenderer()
            setRenderer(renderer)
            //仅数据发生变化时绘制视图
            renderMode = RENDERMODE_WHEN_DIRTY
        }
    }

    class MyGlRenderer : GLSurfaceView.Renderer {
        //每绘制一帧就会调用
        override fun onDrawFrame(p0: GL10?) {
            //清空屏幕，并会使用 glClearColor 的颜色渲染
            GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT)
        }
        //当大小发生变化
        override fun onSurfaceChanged(p0: GL10?, p1: Int, p2: Int) {
            //设置gl的视图大小
            GLES30.glViewport(0,0,p1,p2)
        }

        //设备第一次运行，或从其他activity切回来
        override fun onSurfaceCreated(p0: GL10?, p1: EGLConfig?) {
            //设置红色背景
            GLES30.glClearColor(1f, 0f, 0f, 0f)
        }

    }
}