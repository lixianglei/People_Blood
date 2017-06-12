// Generated code from Butter Knife. Do not modify!
package com.example.admin.people_blood.view.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GuanJianZiActivity$$ViewBinder<T extends com.example.admin.people_blood.view.activity.GuanJianZiActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493077, "field 'GuanJianZiEditText'");
    target.GuanJianZiEditText = finder.castView(view, 2131493077, "field 'GuanJianZiEditText'");
    view = finder.findRequiredView(source, 2131493078, "field 'GuanJianZiSure' and method 'onViewClicked'");
    target.GuanJianZiSure = finder.castView(view, 2131493078, "field 'GuanJianZiSure'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked();
        }
      });
    view = finder.findRequiredView(source, 2131493079, "field 'GuanJianZiListView'");
    target.GuanJianZiListView = finder.castView(view, 2131493079, "field 'GuanJianZiListView'");
  }

  @Override public void unbind(T target) {
    target.GuanJianZiEditText = null;
    target.GuanJianZiSure = null;
    target.GuanJianZiListView = null;
  }
}
