package com.example.androidfundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.animations.AnimationExampleActivity
import com.example.androidfundamental.contentprovider.ContactsActivity
import com.example.androidfundamental.asynctask.ReadWebpageAsyncTask
import com.example.androidfundamental.customviews.CustomViewActivity
import com.example.androidfundamental.drawables.DrawableActivity
import com.example.androidfundamental.draganddrop.DragActivity
import com.example.androidfundamental.fragments.MenuFragmentsActivity
import com.example.androidfundamental.fundamental.FundamentalActivity
import com.example.androidfundamental.mvpsample.createtask.ui.TasksActivity
import com.example.androidfundamental.handler.ProgressTestActivity
import com.example.androidfundamental.network.NetworkMenuActivity
import com.example.androidfundamental.roomexample.MainRoomActivity
import com.example.androidfundamental.wallpaper.SetWallpaperActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btn_fundamental.setOnClickListener {
            startActivity(Intent(this, FundamentalActivity::class.java))
            }
        btn_android_network.setOnClickListener {
            startActivity(Intent(this, NetworkMenuActivity::class.java))
        }
        btn_fragments_toolbar.setOnClickListener {
            startActivity(Intent(this, MenuFragmentsActivity::class.java))
    }
        btn_handler.setOnClickListener {
            startActivity(Intent(this, ProgressTestActivity::class.java))
        }
        btn_asynctask.setOnClickListener {
            startActivity(Intent(this, ReadWebpageAsyncTask::class.java))
        }
        btn_room.setOnClickListener {
            startActivity(Intent(this, MainRoomActivity::class.java))
        }
        btn_content_provider.setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))
        }
        btn_mvp.setOnClickListener {
            startActivity(Intent(this, TasksActivity::class.java))
        }
        btn_wallpaper.setOnClickListener{
            startActivity(Intent(this, SetWallpaperActivity::class.java))
        }
        btn_custom_view.setOnClickListener {
            startActivity(Intent(this, CustomViewActivity::class.java))
        }
        btn_animation.setOnClickListener {
            startActivity(Intent(this, AnimationExampleActivity::class.java))
        }
        btn_wallpaper.setOnClickListener{
            startActivity(Intent(this, SetWallpaperActivity::class.java))
        }
        btn_drawable.setOnClickListener {
            startActivity(Intent(this, DrawableActivity::class.java))
        }
        btn_drag.setOnClickListener {
            startActivity(Intent(this, DragActivity::class.java))
        }
}
}