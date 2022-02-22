package com.myapp.shanilkichu.Fragmnets;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.shanilkichu.Adapter.BestTitle_Adapter;
import com.myapp.shanilkichu.Adapter.MainCategory_Adapter;
import com.myapp.shanilkichu.Adapter.Products_Adapter;
import com.myapp.shanilkichu.Adapter.SliderAdapterExample;
import com.myapp.shanilkichu.Adapter.SubCategory_Adapter;
import com.myapp.shanilkichu.Adapter.TopCategory_Adapter;
import com.myapp.shanilkichu.Model.ImageData;
import com.myapp.shanilkichu.Model.SliderItem;
import com.myapp.shanilkichu.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Header1_Fragment extends Fragment {

    Context context;
    SliderView sliderView;
    SliderAdapterExample adapterads;

    RecyclerView recyMainCategories,recyBestTitles,recyTopTitleCategories,recySubCategories,recyProducts;
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

    TextView txtCompanyName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.headerone_layout, container, false);
        context=getActivity();
        initServices(view);
        return view;

    }

    private void initServices(View view) {

        sliderView = view.findViewById(R.id.imageSlider);
        recyMainCategories=view.findViewById(R.id.recyMainCategories);
        recyBestTitles=view.findViewById(R.id.recyBestTitles);
        recySubCategories=view.findViewById(R.id.recySubCategories);
        recyProducts=view.findViewById(R.id.recyProducts);
        recyTopTitleCategories=view.findViewById(R.id.recyTopTitleCategories);
        txtCompanyName=view.findViewById(R.id.txtCompanyName);
        String text = "<font color=#A4A4A3>PROJECT BY</font> <font color=#444444>EZENESS TECHNOLOGY</font>";
        txtCompanyName.setText(Html.fromHtml(text));

        adapterads = new SliderAdapterExample(context);
        sliderView.setSliderAdapter(adapterads);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });
        addNewItem(view, "https://www.marketing91.com/wp-content/uploads/2020/06/COKE-Advertising-Example-Share-a-Coke-Campaign.jpg");
        addNewItem(view, "https://i.ytimg.com/vi/5SyIMvBlol4/maxresdefault.jpg");
        addNewItem(view, "https://www.marketing91.com/wp-content/uploads/2020/06/Heinz-Ketchup-Advertising-Example-No-one-develops-Ketchup-like-Heinz-Campaign.jpg");
        addNewItem(view, "https://techcrunch.com/wp-content/uploads/2019/03/Screen-Shot-2019-03-14-at-12.12.42-PM.png");
        addNewItem(view, "https://www.marketing91.com/wp-content/uploads/2020/06/COKE-Advertising-Example-Share-a-Coke-Campaign.jpg");
        addNewItem(view, "https://www.onemorething.nl/wp-content/uploads/2019/05/MacBook-Air-2017-16x9-1.png");
        addNewItem(view, "https://www.marketing91.com/wp-content/uploads/2020/06/COKE-Advertising-Example-Share-a-Coke-Campaign.jpg");

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
        recySubCategories.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        recySubCategories.setItemAnimator(new DefaultItemAnimator());
        recySubCategories.setAdapter(adapter);

    }

    private void TopTitles() {

        UserName.add("@_User1");
        UserName.add("@_User2");
        UserName.add("@_User3");
        UserName.add("@_User4");
        UserName.add("@_User5");
        UserName.add("@_User6");

        TopCategory_Adapter adapter = new TopCategory_Adapter(UserName,context);
        recyTopTitleCategories.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        recyTopTitleCategories.setItemAnimator(new DefaultItemAnimator());
        recyTopTitleCategories.setAdapter(adapter);

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
        recyBestTitles.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyBestTitles.setItemAnimator(new DefaultItemAnimator());
        recyBestTitles.setAdapter(adapter);
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
        recyProducts.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        recyProducts.setItemAnimator(new DefaultItemAnimator());
        recyProducts.setAdapter(adapter);
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
        recyMainCategories.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        recyMainCategories.setItemAnimator(new DefaultItemAnimator());
        recyMainCategories.setAdapter(adapter);

    }
    private void addNewItem(View view, String imageURL) {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("AED 300");
        sliderItem.setImageUrl(imageURL);
        adapterads.addItem(sliderItem);
    }

}
