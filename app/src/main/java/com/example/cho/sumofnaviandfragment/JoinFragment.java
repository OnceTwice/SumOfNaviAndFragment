package com.example.cho.sumofnaviandfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cho.sumofnaviandfragment.sortjoin.MasterFragment;
import com.example.cho.sumofnaviandfragment.sortjoin.OwnerFragment;
import com.example.cho.sumofnaviandfragment.sortjoin.UserFragment;

public class JoinFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JoinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JoinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JoinFragment newInstance(String param1, String param2) {
        JoinFragment fragment = new JoinFragment();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private Button btnFirstJoin;
    private Button btnSecondJoin;
    private Button btnThirdJoin;

    private ViewPager pager;

    private Fragment masterFragment;
    private Fragment ownerFragment;
    private Fragment userFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_join, container, false);

        masterFragment = new MasterFragment();
        ownerFragment = new OwnerFragment();
        userFragment = new UserFragment();

        btnFirstJoin = (Button) view.findViewById(R.id.btnFirstJoin);
        btnFirstJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(0);
            }
        });

        btnSecondJoin = (Button) view.findViewById(R.id.btnSecondJoin);
        btnSecondJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
            }
        });

        btnThirdJoin = (Button) view.findViewById(R.id.btnThirdJoin);
        btnThirdJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(2);
            }
        });

        // View Pager 선언
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter(getActivity().getSupportFragmentManager()));

        // 처음으로 0번째 Fragment를 보여줌
        pager.setCurrentItem(0);

        // Title 설정
        getActivity().setTitle("Join Fragment");

        // Inflate the layout for this fragment
        return view;
    }

    private class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * View Pager의 Fragment들은 각각 Index를 가짐
         * Android OS로부터 요청된 Pager의 Index를 보내주면,
         * 해당되는 Fragment를 리턴
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return masterFragment;
            } else if(position == 1) {
                return ownerFragment;
            } else {
                return userFragment;
            }
        }

        /**
         * View Pager에 몇 개의 Fragment가 들어가는지 설정
         * @return
         */
        @Override
        public int getCount() {
            return 3;
        }
    }
}
