package com.example.admin.people_blood.view.view1;

import com.example.admin.people_blood.bean.ReMenDoctorBean;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 10:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface IReMenView {
      void  remen(List<ReMenDoctorBean.DataBean>  dataBeen);

      int page();
}
