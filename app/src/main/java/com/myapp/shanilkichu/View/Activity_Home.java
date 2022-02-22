package com.myapp.shanilkichu.View;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.tabs.TabLayout;
import com.myapp.shanilkichu.Adapter.BestTitle_Adapter;
import com.myapp.shanilkichu.Adapter.MainCategory_Adapter;
import com.myapp.shanilkichu.Adapter.Products_Adapter;
import com.myapp.shanilkichu.Adapter.SliderAdapterExample;
import com.myapp.shanilkichu.Adapter.SubCategory_Adapter;
import com.myapp.shanilkichu.Adapter.TopCategory_Adapter;
import com.myapp.shanilkichu.Model.ImageData;
import com.myapp.shanilkichu.Model.SliderItem;
import com.myapp.shanilkichu.R;
import com.myapp.shanilkichu.databinding.LayoutHomeBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Home extends AppCompatActivity {

    LayoutHomeBinding binding;
    Activity activity=this;

    FragmentTransaction transaction;

    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    Context context;
    SliderAdapterExample adapterads;

    List<String> CategoryList=new ArrayList<>();
    List<String> UserName=new ArrayList<>();
    List<String> SubCategory=new ArrayList<>();

    List<String> Km=new ArrayList<>();
    List<String> List_OriginalPrice=new ArrayList<>();
    List<String> List_OfferlPrice=new ArrayList<>();
    List<String> List_Description=new ArrayList<>();
    List<String> Product_Km=new ArrayList<>();
    List<String> Product_OriginalPrice=new ArrayList<>();
    List<String> Product_OfferlPrice=new ArrayList<>();
    List<String> Product_Description=new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding= LayoutHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        initFunctions();
    }

    private void initFunctions() {

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("HEAD TIL 1"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("HEAD TIL 2"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("HEAD TIL 3"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("HEAD TIL 4"));
        binding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        MyHomepage_Adapter adapter = new MyHomepage_Adapter(activity,getChildFragmentManager(),
//                tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });

        
        String text = "<font color=#A4A4A3>PROJECT BY</font> <font color=#444444>EZENESS TECHNOLOGY</font>";
        binding.txtCompanyName.setText(Html.fromHtml(text));

        adapterads = new SliderAdapterExample(context);
        binding.imageSlider.setSliderAdapter(adapterads);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(3);
        binding.imageSlider.setAutoCycle(true);
        binding.imageSlider.startAutoCycle();
        binding.imageSlider.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + binding.imageSlider.getCurrentPagePosition());
            }
        });
        addNewItem( "https://www.marketing91.com/wp-content/uploads/2020/06/COKE-Advertising-Example-Share-a-Coke-Campaign.jpg");
        addNewItem( "https://i.ytimg.com/vi/5SyIMvBlol4/maxresdefault.jpg");
        addNewItem( "https://www.marketing91.com/wp-content/uploads/2020/06/Heinz-Ketchup-Advertising-Example-No-one-develops-Ketchup-like-Heinz-Campaign.jpg");
        addNewItem( "https://techcrunch.com/wp-content/uploads/2019/03/Screen-Shot-2019-03-14-at-12.12.42-PM.png");
        addNewItem( "https://www.marketing91.com/wp-content/uploads/2020/06/COKE-Advertising-Example-Share-a-Coke-Campaign.jpg");
        addNewItem( "https://www.onemorething.nl/wp-content/uploads/2019/05/MacBook-Air-2017-16x9-1.png");
        addNewItem( "https://www.marketing91.com/wp-content/uploads/2020/06/COKE-Advertising-Example-Share-a-Coke-Campaign.jpg");

        MainCategoryList();
        BestTitles();
        TopTitles();
        SubCategory();
        ProductsList();
    }


    private void SubCategory() {

        SubCategory.add("Sub Category");
        SubCategory.add("Sub Category");
        SubCategory.add("Sub Category");
        SubCategory.add("Sub Category");
        SubCategory.add("Sub Category");
        SubCategory.add("Sub Category");
        SubCategory.add("Sub Category");

        SubCategory_Adapter adapter = new SubCategory_Adapter(SubCategory,context);
        binding.recySubCategories.setLayoutManager(new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL, false));
        binding.recySubCategories.setItemAnimator(new DefaultItemAnimator());
        binding.recySubCategories.setAdapter(adapter);

    }

    private void TopTitles() {

        UserName.add("@_User1");
        UserName.add("@_User2");
        UserName.add("@_User3");
        UserName.add("@_User4");
        UserName.add("@_User5");
        UserName.add("@_User6");

        TopCategory_Adapter adapter = new TopCategory_Adapter(UserName,context);
        binding.recyTopTitleCategories.setLayoutManager(new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL, false));
        binding.recyTopTitleCategories.setItemAnimator(new DefaultItemAnimator());
        binding.recyTopTitleCategories.setAdapter(adapter);

    }

    private void BestTitles() {

        Km.add("3 Km");
        Km.add("3 Km");
        Km.add("3 Km");
        Km.add("3 Km");
        Km.add("3 Km");
        Km.add("3 Km");
        Km.add("3 Km");
        Km.add("3 Km");
        Km.add("3 Km");

        List_OfferlPrice.add("00.00 /-");
        List_OfferlPrice.add("");
        List_OfferlPrice.add("00.00 /-");
        List_OfferlPrice.add("00.00 /-");
        List_OfferlPrice.add("");
        List_OfferlPrice.add("00.00 /-");
        List_OfferlPrice.add("00.00 /-");
        List_OfferlPrice.add("");
        List_OfferlPrice.add("00.00 /-");

        List_OriginalPrice.add("00.00 /-");
        List_OriginalPrice.add("00.00 /-");
        List_OriginalPrice.add("00.00 /-");
        List_OriginalPrice.add("00.00 /-");
        List_OriginalPrice.add("00.00 /-");
        List_OriginalPrice.add("00.00 /-");
        List_OriginalPrice.add("00.00 /-");
        List_OriginalPrice.add("00.00 /-");
        List_OriginalPrice.add("00.00 /-");

        List_Description.add("Product Service \nTitle Product");
        List_Description.add("Product Service \nTitle Product");
        List_Description.add("Product Service \nTitle Product");
        List_Description.add("Product Service \nTitle Product");
        List_Description.add("Product Service \nTitle Product");
        List_Description.add("Product Service \nTitle Product");
        List_Description.add("Product Service \nTitle Product");
        List_Description.add("Product Service \nTitle Product");
        List_Description.add("Product Service \nTitle Product");

        ArrayList<ImageData> data= new ArrayList<>();

        data.add(new ImageData( R.drawable.amithab));
        data.add(new ImageData( R.drawable.pantene));
        data.add(new ImageData( R.drawable.pepsi));
        data.add(new ImageData( R.drawable.nothingfake));
        data.add(new ImageData( R.drawable.amithab));
        data.add(new ImageData( R.drawable.pantene));
        data.add(new ImageData( R.drawable.pepsi));
        data.add(new ImageData( R.drawable.nothingfake));
        data.add(new ImageData( R.drawable.amithab));

        BestTitle_Adapter adapter = new BestTitle_Adapter(data,context,Km,List_Description,List_OriginalPrice,List_OfferlPrice);
        binding.recyBestTitles.setLayoutManager(new GridLayoutManager(activity, 3));
        binding.recyBestTitles.setItemAnimator(new DefaultItemAnimator());
        binding.recyBestTitles.setAdapter(adapter);
    }
    private void ProductsList() {

        Product_Km.add("3 Km");
        Product_Km.add("3 Km");
        Product_Km.add("3 Km");
        Product_Km.add("3 Km");
        Product_Km.add("3 Km");
        Product_Km.add("3 Km");
        Product_Km.add("3 Km");
        Product_Km.add("3 Km");
        Product_Km.add("3 Km");

        Product_OfferlPrice.add("00.00 /-");
        Product_OfferlPrice.add("");
        Product_OfferlPrice.add("");
        Product_OfferlPrice.add("00.00 /-");
        Product_OfferlPrice.add("");
        Product_OfferlPrice.add("00.00 /-");
        Product_OfferlPrice.add("00.00 /-");
        Product_OfferlPrice.add("");
        Product_OfferlPrice.add("00.00 /-");

        Product_OriginalPrice.add("00.00 /-");
        Product_OriginalPrice.add("00.00 /-");
        Product_OriginalPrice.add("00.00 /-");
        Product_OriginalPrice.add("00.00 /-");
        Product_OriginalPrice.add("00.00 /-");
        Product_OriginalPrice.add("00.00 /-");
        Product_OriginalPrice.add("00.00 /-");
        Product_OriginalPrice.add("00.00 /-");
        Product_OriginalPrice.add("00.00 /-");

        Product_Description.add("Product Service \nTitle Product");
        Product_Description.add("Title Product \nService Title");
        Product_Description.add("Title Product \nService Title");
        Product_Description.add("Product Service \nTitle Product");
        Product_Description.add("Product Service \nTitle Product");
        Product_Description.add("Product Service \nTitle Product");
        Product_Description.add("Product Service \nTitle Product");
        Product_Description.add("Product Service \nTitle Product");
        Product_Description.add("Product Service \nTitle Product");

        ArrayList<ImageData> data= new ArrayList<>();

        data.add(new ImageData( R.drawable.kfc));
        data.add(new ImageData( R.drawable.pepsinew));
        data.add(new ImageData( R.drawable.macroni));
        data.add(new ImageData( R.drawable.kfc));
        data.add(new ImageData( R.drawable.pepsinew));
        data.add(new ImageData( R.drawable.macroni));
        data.add(new ImageData( R.drawable.kfc));
        data.add(new ImageData( R.drawable.pepsinew));
        data.add(new ImageData( R.drawable.macroni));
        data.add(new ImageData( R.drawable.pepsinew));
        Products_Adapter adapter = new Products_Adapter(data,context,Product_Km,Product_Description,
                Product_OriginalPrice,Product_OfferlPrice);
        binding.recyProducts.setLayoutManager(new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL, false));
        binding.recyProducts.setItemAnimator(new DefaultItemAnimator());
        binding.recyProducts.setAdapter(adapter);
    }

    private void MainCategoryList() {

        CategoryList.add("Main \nCategory 1");
        CategoryList.add("Main \nCategory 2");
        CategoryList.add("Main \nCategory 3");
        CategoryList.add("Main \nCategory 4");
        CategoryList.add("Main \nCategory 5");
        CategoryList.add("Main \nCategory 6");
        CategoryList.add("Main \nCategory 7");

        MainCategory_Adapter adapter = new MainCategory_Adapter(CategoryList,context);
        binding.recyMainCategories.setLayoutManager(new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL, false));
        binding.recyMainCategories.setItemAnimator(new DefaultItemAnimator());
        binding.recyMainCategories.setAdapter(adapter);

    }
    private void addNewItem( String imageURL) {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("AED 300");
        sliderItem.setImageUrl(imageURL);
        adapterads.addItem(sliderItem);
    }


    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getApplicationContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }


}
