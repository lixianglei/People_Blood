package com.example.admin.people_blood.presenter;

import com.example.admin.people_blood.view.fragment.BloodManagerFragmentImpl;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/10 15:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class BloodManagerPressenter {
    private BloodManagerFragmentImpl bloodManagerFragment;

    public BloodManagerPressenter(BloodManagerFragmentImpl bloodManagerFragment) {
        this.bloodManagerFragment = bloodManagerFragment;
    }
    public void shangchuan(){
        bloodManagerFragment.showPopWindow();
    }
    public void shoudongCe(){
        bloodManagerFragment.shoudongshangchuan();
    }
    public void kangbaobei(){
        bloodManagerFragment.kangBaoBeiShangChuan();
    }
    public void finshpop(){
        bloodManagerFragment.finshpop();
    }
}
