package com.fevziomurtekin.android_mvvm_architecture

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fevziomurtekin.android_mvvm_architecture.Retro.RetrofitInterface
import com.fevziomurtekin.android_mvvm_architecture.ViewModel.userInfoModel
import com.fevziomurtekin.android_mvvm_architecture.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: userInfoModel
    private var disposable: Disposable? = null

    private val githubApi by lazy { //Using a custom getter.
        RetrofitInterface.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding             = DataBindingUtil.setContentView(this,R.layout.activity_main) //binding methot.
        binding.viewModel   = viewModel

        loadView()

    }

    private fun loadView() {
        disposable = githubApi.userInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> viewModel.username=result.name},
                { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
            )
    }
}
