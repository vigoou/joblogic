package com.quoctran.joblogic

import android.app.Application
import com.quoctran.joblogic.core.RetrofitHelper
import com.quoctran.joblogic.data.db.AppDatabase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class JobLogicApplication: Application()  {
//    val database by lazy { AppDatabase.getDatabase(this) }
//    val retrofit by lazy { RetrofitHelper.getInstance()}
}
