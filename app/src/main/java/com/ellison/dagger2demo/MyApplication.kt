package com.ellison.dagger2demo

import android.app.Application
import android.util.Log

import dagger.Component

import com.ellison.dagger2demo.model.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationGraph {
    fun inject(activity: DemoActivity)
}

//@Singleton
//@Component(modules = [NetworkModule::class, MovieGraphModule::class]) // 子模块添加到应用图
//interface ApplicationGraph {
//    fun repository(): MovieRepository
//    fun movieGraph(): MovieGraph.Factory // 告知Dagger如何创建子组件
//}

class MyApplication : Application() {
    val appGraph = DaggerApplicationGraph.create()
    // val appGraph = DaggerApplicationGraph.builder().networkModule().build()

    override fun onCreate() {
        super.onCreate()

    }
}