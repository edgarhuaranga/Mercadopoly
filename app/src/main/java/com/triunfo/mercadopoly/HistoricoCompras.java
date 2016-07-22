package com.triunfo.mercadopoly;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HistoricoCompras extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_compras);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerComprasAdapter adapter = new ViewPagerComprasAdapter(getSupportFragmentManager());
        adapter.addFragment(ComprasMesFragment.newInstance("LI0001","Agosto"), "Agosto");
        adapter.addFragment(ComprasMesFragment.newInstance("LI0001","Setiembre"), "Setiembre");
        adapter.addFragment(ComprasMesFragment.newInstance("LI0001","Octubre"), "Octubre");
        adapter.addFragment(ComprasMesFragment.newInstance("LI0001","Noviembre"), "Noviembre");
        adapter.addFragment(ComprasMesFragment.newInstance("LI0001","Diciembre"), "Diciembre");
        adapter.addFragment(ComprasMesFragment.newInstance("LI0001","Enero"), "Enero");
        viewPager.setAdapter(adapter);
        //TODO obtener lista de nombres participantes por cliente
        //TODO obtener valor de cada compra
    }

    class ViewPagerComprasAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerComprasAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
