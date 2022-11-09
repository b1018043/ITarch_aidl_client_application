package com.example.aidlclientapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.aidlapplication.IITArchAidlInterface

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    val args: DetailFragmentArgs by navArgs()

    private var myService: IITArchAidlInterface? = null

    private lateinit var img: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        img = view.findViewById<ImageView>(R.id.imageView)
        val intent = Intent("itarchservice")
        intent.setPackage("com.example.aidlapplication")
        activity?.bindService(intent,object: ServiceConnection {
            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                myService = IITArchAidlInterface.Stub.asInterface(p1)
                Glide.with(activity).load(myService!!.calcStatusURL(args.id)).into(img)
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
                myService = null
            }
        }, Context.BIND_AUTO_CREATE)
        return view
    }

}