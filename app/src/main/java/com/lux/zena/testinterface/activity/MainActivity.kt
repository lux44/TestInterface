package com.lux.zena.testinterface.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lux.zena.testinterface.R
import com.lux.zena.testinterface.databinding.ActivityMainBinding
import com.lux.zena.testinterface.fragments.FirstFragment
import com.lux.zena.testinterface.fragments.FourthFragment
import com.lux.zena.testinterface.fragments.SecondFragment
import com.lux.zena.testinterface.fragments.ThirdFragment

class MainActivity : AppCompatActivity() {
    val binding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val fragments:MutableList<Fragment> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        fragments.add(FirstFragment())
        fragments.add(SecondFragment())
        fragments.add(ThirdFragment())
        fragments.add(FourthFragment())

        supportFragmentManager.beginTransaction().add(R.id.container_fragment, fragments[0]).commit()

        binding.bnv.setOnItemSelectedListener {

            supportFragmentManager.fragments.forEach {
                supportFragmentManager.beginTransaction().hide(it).commit()
            }

            val tran = supportFragmentManager.beginTransaction()
            when(it.itemId){
                R.id.bnv1 -> {
                    tran.show(fragments[0])
                }
                R.id.bnv2 -> {
                    if (!supportFragmentManager.fragments.contains(fragments[1])) tran.add(R.id.container_fragment, fragments[1])
                    tran.show(fragments[1])
                }
                R.id.bnv3 -> {
                    if (!supportFragmentManager.fragments.contains(fragments[2])) tran.add(R.id.container_fragment,fragments[2])
                    tran.show(fragments[2])
                }
                R.id.bnv4 -> {
                    if (!supportFragmentManager.fragments.contains(fragments[3])) tran.add(R.id.container_fragment, fragments[3])
                    tran.show(fragments[3])
                }
            }
            tran.commit()
            true
        }
    }
}