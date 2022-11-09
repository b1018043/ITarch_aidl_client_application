package com.example.aidlclientapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aidlapplication.IITArchAidlInterface

class MainActivity : AppCompatActivity() {

    public var myService: IITArchAidlInterface? = null

    private val conn: ServiceConnection = object: ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            myService = IITArchAidlInterface.Stub.asInterface(p1)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            myService = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent("itarchservice")
        intent.setPackage("com.example.aidlapplication")
        bindService(intent,conn, Context.BIND_AUTO_CREATE)
    }
}