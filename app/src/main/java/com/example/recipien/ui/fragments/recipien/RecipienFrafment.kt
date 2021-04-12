package com.example.recipien.ui.fragments.recipien

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipien.R
import com.example.recipien.adapters.ItemRowAdpater
import com.example.recipien.viewmodels.MainViewModel
import com.example.recipien.utils.Constances
import com.example.recipien.utils.Networkresult
import com.example.recipien.viewmodels.RecipienViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipien_frafment.view.*
@AndroidEntryPoint
class RecipienFrafment : Fragment() {

    private lateinit var mView:View
    private val mRecyAdapter by lazy { ItemRowAdpater() }
    private lateinit var mainViewModel: MainViewModel
    private lateinit var recipViewModel:RecipienViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel=ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        recipViewModel=ViewModelProvider(requireActivity()).get(RecipienViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_recipien_frafment, container, false)

        setUpRecycleView()
        fetchDataFromApi(recipViewModel.applyQuery())

        return mView
    }

    fun fetchDataFromApi(query:HashMap<String,String>)
    {
        mainViewModel.getRecipe(query)
        mainViewModel.response.observe(viewLifecycleOwner, Observer {
            when(it)
            {
                is Networkresult.Success->{
                    hideShimmerEffect()
                    it.data?.let { mRecyAdapter.setData(it) }

                }
                is Networkresult.Error ->{
                    hideShimmerEffect()
                    Toast.makeText(requireActivity(),it.massage.toString(),Toast.LENGTH_LONG).show()
                }
                is Networkresult.Loading ->{
                    showShimmerEffect()
                }
            }
        })
    }



    fun setUpRecycleView()
    {
        val recy=mView.recy_recipFrag//cheak here to delete find view
        recy.adapter=mRecyAdapter
        recy.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
        showShimmerEffect()
    }

    fun showShimmerEffect()
    {
        mView.recy_recipFrag.showShimmer()//cheak here to delete find view
    }
    fun hideShimmerEffect()
    {
        mView.recy_recipFrag.hideShimmer()//cheak here to delete find view
    }


}